package com.practo1.payload;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeDeserializer extends JsonDeserializer<LocalTime> {
    @Override
    public LocalTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String timeString = p.getValueAsString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a"); // Adjust the pattern to match your input

        try {
            return LocalTime.parse(timeString, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid time format. Please use a format like '11:15 AM'.");
        }
    }
}

