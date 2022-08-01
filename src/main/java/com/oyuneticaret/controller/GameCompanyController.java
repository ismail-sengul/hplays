package com.oyuneticaret.controller;

import com.oyuneticaret.dao.GameCompanyDao;
import com.oyuneticaret.dto.gamecompany.*;
import com.oyuneticaret.model.Game;
import com.oyuneticaret.model.GameCompany;
import com.oyuneticaret.service.GameCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/gamecompany")
public class GameCompanyController {

    @Autowired
    private GameCompanyService gameCompanyService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> gameCompanySave(@RequestBody GameCompanyCreateDTO gameCompanyCreateDTO){
        GameCompanySuccessDTO successDTO = new GameCompanySuccessDTO();
        if(gameCompanyCreateDTO.getCompanyName() == null){
            throw new IllegalArgumentException("Şirket adı girilmesi zorunludur.");
        }else{

            GameCompany gameCompany = new GameCompany();
            gameCompany.setCompanyName(gameCompanyCreateDTO.getCompanyName());
            gameCompany.setCompanyDescription(gameCompanyCreateDTO.getCompanyDescription());
            gameCompany.setFoundationYear(gameCompanyCreateDTO.getFoundationYear());

            gameCompanyService.save(gameCompany);

            successDTO.setId(gameCompany.getId());
            successDTO.setCompanyDescription(gameCompanyCreateDTO.getCompanyDescription());
            successDTO.setCompanyName(gameCompanyCreateDTO.getCompanyName());
            successDTO.setFoundationYear(gameCompanyCreateDTO.getFoundationYear());
            successDTO.setMessage("Create işlemi başarılı.");

        }
        return ResponseEntity.ok(successDTO);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> findAllGameCompanies(){
        GameCompanyFindSuccessDTO gameCompanyFindSuccessDTO = new GameCompanyFindSuccessDTO();

        List<GameCompany> gameCompanies = gameCompanyService.findAllGameCompanies();
        List<GameCompanyDTO> gameCompanyDTOS = new ArrayList<>();
        for (GameCompany gameCompany: gameCompanies){
            GameCompanyDTO gameCompanyDTO = new GameCompanyDTO();
            gameCompanyDTO.setId(gameCompany.getId());
            gameCompanyDTO.setCompanyName(gameCompany.getCompanyName());
            gameCompanyDTO.setCompanyDescription(gameCompany.getCompanyDescription());
            gameCompanyDTO.setFoundationYear(gameCompany.getFoundationYear());

            gameCompanyDTOS.add(gameCompanyDTO);
        }
        gameCompanyFindSuccessDTO.setGameCompanies(gameCompanyDTOS);
        gameCompanyFindSuccessDTO.setMessage("Listeleme işlemi başarılı.");

        return ResponseEntity.ok(gameCompanyFindSuccessDTO);
    }

    @RequestMapping(value = "/list?{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findGameCompanyById(@PathVariable(value = "id") Long id){
        GameCompany gameCompany = gameCompanyService.findGameCompanyById(id);
        GameCompanySuccessDTO foundedGameCompany = new GameCompanySuccessDTO();
        if (gameCompany == null){
            throw new IllegalArgumentException("Id değeri yanlış girildi");
        }else{
            foundedGameCompany.setId(gameCompany.getId());
            foundedGameCompany.setFoundationYear(gameCompany.getFoundationYear());
            foundedGameCompany.setCompanyName(gameCompany.getCompanyName());
            foundedGameCompany.setCompanyDescription(gameCompany.getCompanyDescription());
            foundedGameCompany.setMessage("İşlem Başarılı.");
        }
        return ResponseEntity.ok(foundedGameCompany);
    }

    @RequestMapping(value = "/get" , method = RequestMethod.GET)
    public ResponseEntity<?> findGameCompaniesByName(@RequestParam String companyName){
        GameCompanyFindSuccessDTO gameCompanyFindSuccessDTO = new GameCompanyFindSuccessDTO();

        List<GameCompany> gameCompanies = gameCompanyService.findGameCompaniesByName(companyName);
        List<GameCompanyDTO> gameCompanyDTOS = new ArrayList<>();
        for (GameCompany gameCompany: gameCompanies){
            GameCompanyDTO gameCompanyDTO = new GameCompanyDTO();
            gameCompanyDTO.setId(gameCompany.getId());
            gameCompanyDTO.setCompanyName(gameCompany.getCompanyName());
            gameCompanyDTO.setCompanyDescription(gameCompany.getCompanyDescription());
            gameCompanyDTO.setFoundationYear(gameCompany.getFoundationYear());

            gameCompanyDTOS.add(gameCompanyDTO);
        }
        gameCompanyFindSuccessDTO.setGameCompanies(gameCompanyDTOS);
        gameCompanyFindSuccessDTO.setMessage("Listeleme işlemi başarılı.");

        return ResponseEntity.ok(gameCompanyFindSuccessDTO);
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateGameCompany(@RequestBody GameCompanyUpdateDTO gameCompanyUpdateDTO){
        GameCompanySuccessDTO successDTO = new GameCompanySuccessDTO();
        GameCompany gameCompany = gameCompanyService.findGameCompanyById(gameCompanyUpdateDTO.getId());

        if(gameCompany == null){
            throw new IllegalArgumentException("Id yanlış girildi.");
        }else{
            if(gameCompanyUpdateDTO.getCompanyDescription() != null && !(gameCompanyUpdateDTO.getCompanyDescription().equalsIgnoreCase(gameCompany.getCompanyDescription()))){
                gameCompany.setCompanyDescription(gameCompanyUpdateDTO.getCompanyDescription());
            }
            if(gameCompanyUpdateDTO.getCompanyName() != null && !(gameCompanyUpdateDTO.getCompanyName().equalsIgnoreCase(gameCompany.getCompanyName()))){
                gameCompany.setCompanyName(gameCompanyUpdateDTO.getCompanyName());
            }
            if(gameCompanyUpdateDTO.getFoundationYear() != null){
                gameCompany.setFoundationYear(gameCompanyUpdateDTO.getFoundationYear());
            }

            gameCompanyService.save(gameCompany);
            successDTO.setId(gameCompanyUpdateDTO.getId());
            successDTO.setCompanyDescription(gameCompanyUpdateDTO.getCompanyDescription());
            successDTO.setCompanyName(gameCompanyUpdateDTO.getCompanyName());
            successDTO.setFoundationYear(gameCompanyUpdateDTO.getFoundationYear());
            successDTO.setMessage("Update işlemi başarılı.");
        }
        return ResponseEntity.ok(successDTO);
    }

    @RequestMapping(value = "/delete" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteGameCompany(@RequestParam Long id){
        GameCompanySuccessDTO successDTO = new GameCompanySuccessDTO();
        GameCompany gameCompany = gameCompanyService.findGameCompanyById(id);

        if(gameCompany == null){
            throw new IllegalArgumentException("Id yanlış girildi.");
        }else{
            gameCompanyService.delete(gameCompany);
            successDTO.setFoundationYear(gameCompany.getFoundationYear());
            successDTO.setCompanyName(gameCompany.getCompanyName());
            successDTO.setCompanyDescription(gameCompany.getCompanyDescription());
            successDTO.setId(gameCompany.getId());
            successDTO.setMessage("Silme İşlemi Başarılı.");
        }
        return ResponseEntity.ok(successDTO);
    }

}
