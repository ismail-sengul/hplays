package com.hplays.utils;

import com.hplays.dto.type.TypeDTO;
import com.hplays.dto.type.TypeFindDTO;
import com.hplays.dto.type.TypeFindSuccessDTO;
import com.hplays.dto.type.TypeSuccessDTO;
import com.hplays.model.Types;

import java.util.ArrayList;
import java.util.List;

public class TypeUtil {

    public TypeDTO convertTypeDTO(Types type){
        TypeDTO typeDTO = new TypeDTO();

        typeDTO.setId(type.getId());
        typeDTO.setName(type.getName());

        return typeDTO;
    }
    public TypeFindSuccessDTO createTypeFindSuccessDTO(List<Types> types){
        List<TypeFindDTO> foundedTypes = new ArrayList<TypeFindDTO>();
        for (Types type: types){
            TypeFindDTO foundedType = new TypeFindDTO();
            foundedType.setId(type.getId());
            foundedType.setName(type.getName());
            foundedTypes.add(foundedType);
        }
        TypeFindSuccessDTO findSuccess = new TypeFindSuccessDTO();
        findSuccess.setFoundedTypes(foundedTypes);
        findSuccess.setMessage("İşlem Başarılı.");
        return findSuccess;
    }

    public TypeSuccessDTO createTypeSuccessDTO(Types type , String message){
        TypeSuccessDTO typeSuccessDTO = new TypeSuccessDTO();
        typeSuccessDTO.setId(type.getId());
        typeSuccessDTO.setName(type.getName());
        typeSuccessDTO.setMessage(message);
        return typeSuccessDTO;
    }
}
