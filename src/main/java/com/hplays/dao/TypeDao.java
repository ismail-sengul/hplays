package com.hplays.dao;

import com.hplays.model.Types;

import java.util.List;

public interface TypeDao {
    void save(Types types);

    List<Types> listTypes();

    Types listTypesById(Long id);

    List<Types> listTypesByName(String name);

    void delete(Types type);
}
