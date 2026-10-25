package com.detectivebureau.model;

public class Detective {
    private final String name;
    private final String specialization;
    private int workload;

    public Detective(String name, String specialization, int workload) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be empty");
        }
        if (workload < 0) {
            throw new IllegalArgumentException("Workload cannot be negative.");
        }
        this.name = name.trim();
        this.specialization = specialization.trim();
        this.workload = workload;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {

        return specialization;
    }

    public int getWorkload() {

        return workload;
    }

    public void addEvidence() {

        workload++;
    }
}
