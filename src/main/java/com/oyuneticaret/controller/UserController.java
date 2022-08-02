package com.oyuneticaret.controller;

import com.oyuneticaret.dto.user.UserCreateDTO;
import com.oyuneticaret.dto.user.UserDTO;
import com.oyuneticaret.dto.user.UserFindDTO;
import com.oyuneticaret.dto.user.UserFindSuccessDTO;
import com.oyuneticaret.model.User;
import com.oyuneticaret.service.UserService;
import com.oyuneticaret.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    UserUtil userUtil = new UserUtil();

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody UserCreateDTO userCreateDTO){

        if(userCreateDTO.getLastName() == null){
            throw new IllegalArgumentException("Soyadı Boş Bırakılamaz.");
        }else if(userCreateDTO.getFirstName() == null){
            throw new IllegalArgumentException("Ad Boş Bırakılamaz");
        }else if(userCreateDTO.getEmail() == null){
            throw new IllegalArgumentException("Email Boş bırakılamaz");
        }else if(userCreateDTO.getNickname() == null){
            throw new IllegalArgumentException("Kullanıcı Adı boş bırakılamaz.");
        }

        User user = new User();
        user.setLastName(userCreateDTO.getLastName());
        user.setBirthOfDate(userCreateDTO.getBirthOfDate());
        user.setEmail(userCreateDTO.getEmail());
        user.setFirstName(userCreateDTO.getFirstName());
        user.setNickname(userCreateDTO.getNickname());
        user.setAddress(userCreateDTO.getAddress());

        userService.save(user);

        return ResponseEntity.ok(userUtil.createUserSuccessDTO(user,"Ekleme İşlemi Başarılı."));
    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public ResponseEntity<?> findGames(@RequestBody UserFindDTO userFindDTO){
        UserFindSuccessDTO userFindSuccessDTO = new UserFindSuccessDTO();
        List<User> users = userService.findUsers(userFindDTO);
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user: users){
            UserDTO userDTO = new UserDTO();

            userDTO.setId(user.getId());
            userDTO.setLastName(user.getLastName());
            userDTO.setBirthOfDate(user.getBirthOfDate());
            userDTO.setEmail(user.getEmail());
            userDTO.setFirstName(user.getFirstName());
            userDTO.setNickname(user.getNickname());
            userDTO.setAddress(user.getAddress());

            userDTOS.add(userDTO);
        }
        userFindSuccessDTO.setUsers(userDTOS);
        userFindSuccessDTO.setMessage("Listeleme İşlemi Başarılı.");

        return ResponseEntity.ok(userFindSuccessDTO);
    }

    @RequestMapping(value = "/get?{id}" , method = RequestMethod.GET)
    public ResponseEntity<?> findGameById(@PathVariable(value = "/id") Long id){
        User user = userService.findUserById(id);

        if(user == null){
            throw new IllegalArgumentException("Kullanıcı bulunamadı.");
        }

        return ResponseEntity.ok(userUtil.createUserSuccessDTO(user,"İşlem Başarılı."));
    }

    @RequestMapping(value = "/update" ,method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO){
        User user = userService.findUserById(userDTO.getId());

        if(userDTO.getAddress() != null){
            user.setAddress(userDTO.getAddress());
        }
        if(userDTO.getBirthOfDate() != null){
            user.setBirthOfDate(userDTO.getBirthOfDate());
        }
        if(userDTO.getFirstName() != null){
            user.setFirstName(userDTO.getFirstName());
        }
        if(userDTO.getLastName() != null){
            user.setLastName(userDTO.getLastName());
        }
        if(userDTO.getEmail() != null){
            user.setEmail(userDTO.getEmail());
        }
        if(userDTO.getNickname() != null){
            //TODO Burada bir kontrol işlemi yapılması gerek
            user.setNickname(userDTO.getNickname());
        }

        userService.save(user);

        return ResponseEntity.ok(userUtil.createUserSuccessDTO(user,"Güncelleme işlemi başarılı."));
    }

    @RequestMapping(value = "/delete" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@RequestParam Long id){
        User user = userService.findUserById(id);

        if(user == null){
            throw new IllegalArgumentException("Kullanıcı Bulunamadı.");
        }
        userService.delete(user);

        return ResponseEntity.ok(userUtil.createUserSuccessDTO(user,"Silme İşlemi Başarılı."));
    }
}
