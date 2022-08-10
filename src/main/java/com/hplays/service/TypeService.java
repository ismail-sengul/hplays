package com.hplays.service;

import com.hplays.model.Types;

import java.util.List;

public interface TypeService {
    void save(Types types);
    List<Types> listTypes();

    Types listTypesById(Long id);

    List<Types> listTypesByName(String name);

    void delete(Types type);
}
