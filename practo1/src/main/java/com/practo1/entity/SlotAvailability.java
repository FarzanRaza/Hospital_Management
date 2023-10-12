package com.practo1.entity;


import lombok.Setter;


public enum SlotAvailability {

    SLOT_10_15("10:15 AM"),
    SLOT_11_15("11:15 AM"),
    SLOT_12_15("12:15 PM");

    public String getLabel() {
        return label;
    }

    private final String label;

    SlotAvailability(String label) {
        this.label = label;
    }

}
