package com.mmendoza.internal_system_for_club.domain.model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Employee {

    private Long id;

    private String name;

    private String lastName;

    private LocalDate birthDate;

    private String cellPhone;

    private Long userId;

    public Employee(String name, String lastName, LocalDate birtDate, String cellphone, Long userId) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birtDate;
        this.cellPhone = cellphone;
        this.userId = userId;
    }
}
