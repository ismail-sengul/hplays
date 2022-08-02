package com.oyuneticaret.controller;

import com.oyuneticaret.dto.type.*;
import com.oyuneticaret.model.Types;
import com.oyuneticaret.service.TypeService;
import com.oyuneticaret.utils.TypeUtil;
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

    private TypeUtil typeUtil = new TypeUtil();


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> typeSave(@RequestBody TypeCreateDTO typeCreateDTO){
        if(typeCreateDTO.getName() == null){
            throw new IllegalArgumentException("Type adı boş olamaz!");
        }
        Types type = new Types();
        type.setName(typeCreateDTO.getName());

        typeService.save(type);

        return ResponseEntity.ok(typeUtil.createTypeSuccessDTO(type,"Ekleme işlemi başarılı."));
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<?> findAllTypes(){
        List<Types> types = typeService.listTypes();
        return ResponseEntity.ok(typeUtil.createTypeFindSuccessDTO(types));
    }

    @RequestMapping(value = "/get?{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findTypeById(@PathVariable(value = "id") Long id){

        Types type = typeService.listTypesById(id);
        if(type == null){
            throw new IllegalArgumentException("Id değeri yanlış girildi");
        }
        return ResponseEntity.ok(typeUtil.createTypeSuccessDTO(type,"İşlem Başarılı."));
    }

    @RequestMapping(value = "/list?{name}",method = RequestMethod.GET)
    public ResponseEntity<?> findTypeByName(@PathVariable(value = "name") String name){
        List<Types> types = typeService.listTypesByName(name);
        return ResponseEntity.ok(typeUtil.createTypeFindSuccessDTO(types));
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateName(@RequestBody TypeUpdateDTO typeUpdateDTO){
        Types type = typeService.listTypesById(typeUpdateDTO.getId());
        if(type == null) {
            throw new IllegalArgumentException("Oyun tipi bulunamadı");
        }
        type.setName(typeUpdateDTO.getNewName());
        typeService.save(type);

        return ResponseEntity.ok(typeUtil.createTypeSuccessDTO(type,"Güncelleme İşlemi Başarılı."));
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteName(@RequestParam Long id){
        Types type = typeService.listTypesById(id);
        if(type == null){
            throw new IllegalArgumentException(id+" id numarasına sahip type elemanı yok.");
        }
        typeService.delete(type);

        return ResponseEntity.ok(typeUtil.createTypeSuccessDTO(type,"Silme işlemi başarılı."));
    }
}

