package com.practo1.service;

import com.practo1.entity.Doctor;
import com.practo1.exception.DoctorNotFoundException;
import com.practo1.payload.DoctorDto;
import com.practo1.repository.DoctorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService{
    @Autowired
    private DoctorRepository repoo;
    @Autowired
    private ModelMapper modelMapper;
    private Doctor mapToEntity(DoctorDto doctorDto) {
        return modelMapper.map(doctorDto, Doctor.class);
    }
    private DoctorDto mapToDto(Doctor doctor) {
        return modelMapper.map(doctor, DoctorDto.class);
    }
    @Override
    public Doctor saveDoctor(Doctor doctor) {
        return repoo.save(doctor);
    }
    @Override
    public Doctor findRecordById(int doctorId) {
        return repoo.findByDoctorId(doctorId);
    }

    @Override
    public List<Doctor> searchDoctors(String searchTerm) {
        List<Doctor> doctors = repoo.searchDoctors(searchTerm);
        if (doctors.isEmpty()) {
            throw new DoctorNotFoundException("No doctors found with the provided search criteria.");
        }
        return doctors;
    }


}
