package com.hplays.dto.type;

import java.io.Serializable;

public class TypeUpdateDTO implements Serializable {

    private Long id;
    private String newName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }
}
