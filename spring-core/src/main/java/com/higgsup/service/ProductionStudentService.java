package com.higgsup.service;

public class ProductionStudentService implements IStudentService {
    @Override
    public void createStudent() {
        System.out.println("Prod create student service...");
    }
}
