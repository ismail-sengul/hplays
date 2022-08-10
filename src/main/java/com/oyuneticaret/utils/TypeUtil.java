package com.oyuneticaret.utils;

import com.oyuneticaret.dto.type.TypeDTO;
import com.oyuneticaret.dto.type.TypeFindDTO;
import com.oyuneticaret.dto.type.TypeFindSuccessDTO;
import com.oyuneticaret.dto.type.TypeSuccessDTO;
import com.oyuneticaret.model.Types;

import java.lang.reflect.Type;
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
