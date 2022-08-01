package com.oyuneticaret.dto.type;

import java.io.Serializable;
import java.util.List;

public class TypeFindSuccessDTO implements Serializable {
    private List<TypeFindDTO> foundedTypes;
    private String message;

    public List<TypeFindDTO> getFoundedTypes() {
        return foundedTypes;
    }

    public void setFoundedTypes(List<TypeFindDTO> foundedTypes) {
        this.foundedTypes = foundedTypes;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
