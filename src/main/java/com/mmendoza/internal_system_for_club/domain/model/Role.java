package com.mmendoza.internal_system_for_club.domain.model;

import lombok.Getter;

@Getter
public class Role {
    private Long id;
    private String name;

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
