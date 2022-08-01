package com.oyuneticaret.controller;

import com.oyuneticaret.dto.type.*;
import com.oyuneticaret.model.Types;
import com.oyuneticaret.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/type")
public class TypeController {

    @Autowired
    @Qualifier(value = "typeServiceImpl")
    private TypeService typeService;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> typeSave(@RequestBody TypeCreateDTO typeCreateDTO){
        if(typeCreateDTO.getName() == null){
            throw new IllegalArgumentException("Type adı boş olamaz!");
        }else{
            Types types = new Types();
            types.setName(typeCreateDTO.getName());

            typeService.save(types);

            TypeSuccessDTO successDTO = new TypeSuccessDTO();

            successDTO.setId(types.getId());
            successDTO.setName(typeCreateDTO.getName());
            successDTO.setMessage("İşlem Başarılı.");

            return ResponseEntity.ok(successDTO);
        }
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<?> findAllTypes(){
        List<Types> types = typeService.listTypes();
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
        return ResponseEntity.ok(findSuccess);
    }

    @RequestMapping(value = "/list?{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findTypeById(@PathVariable(value = "id") Long id){
        TypeSuccessDTO foundedType = new TypeSuccessDTO();
        Types type = typeService.listTypesById(id);
        if(type == null){
            throw new IllegalArgumentException("Id değeri yanlış girildi");
        }else{
            foundedType.setName(type.getName());
            foundedType.setId(type.getId());
            foundedType.setMessage("İşlem Başarılı.");
        }
        return ResponseEntity.ok(foundedType);
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResponseEntity<?> findTypeByName(@RequestParam String name){
        List<Types> types = typeService.listTypesByName(name);
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
        return ResponseEntity.ok(findSuccess);
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateName(@RequestBody TypeUpdateDTO typeUpdateDTO){
        TypeUpdateSuccessDTO successDTO = new TypeUpdateSuccessDTO();
        Types type = typeService.listTypesById(typeUpdateDTO.getId());
        String oldName = type.getName();
        if(type != null) {
            type.setName(typeUpdateDTO.getNewName());
            typeService.save(type);

            successDTO.setId(typeUpdateDTO.getId());
            successDTO.setOldName(oldName);
            successDTO.setNewName(type.getName());
            successDTO.setMessage("Update işlemi başarılı.");
        }else{
            throw new IllegalArgumentException(typeUpdateDTO.getId()+" id numarasına sahip type elemanı yok.");
        }
        return ResponseEntity.ok(successDTO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteName(@RequestParam Long id){
        TypeSuccessDTO successDTO = new TypeSuccessDTO();
        Types type = typeService.listTypesById(id);
        String deletedTypeName = type.getName();
        if(type != null){
            typeService.delete(type);
            successDTO.setId(id);
            successDTO.setName(deletedTypeName);
            successDTO.setMessage("Silme işlemi başarılı.");
        }else{
            throw new IllegalArgumentException(id+" id numarasına sahip type elemanı yok.");
        }
        return ResponseEntity.ok(successDTO);
    }
}

