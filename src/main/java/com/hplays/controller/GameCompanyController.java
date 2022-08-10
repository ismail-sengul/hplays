package com.hplays.controller;

import com.hplays.dto.gamecompany.*;
import com.hplays.model.GameCompany;
import com.hplays.service.GameCompanyService;
import com.hplays.utils.GameCompanyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/gamecompany")
public class GameCompanyController {

    @Autowired
    private GameCompanyService gameCompanyService;

    private GameCompanyUtil gameCompanyUtil = new GameCompanyUtil();

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<?> gameCompanySave(@RequestBody GameCompanyCreateDTO gameCompanyCreateDTO){
        GameCompanySuccessDTO successDTO = new GameCompanySuccessDTO();
        if(gameCompanyCreateDTO.getCompanyName() == null){
            throw new IllegalArgumentException("Şirket adı girilmesi zorunludur.");
        }

        GameCompany gameCompany = new GameCompany();
        gameCompany.setCompanyName(gameCompanyCreateDTO.getCompanyName());
        gameCompany.setCompanyDescription(gameCompanyCreateDTO.getCompanyDescription());
        gameCompany.setFoundationYear(gameCompanyCreateDTO.getFoundationYear());

        gameCompanyService.save(gameCompany);

        return ResponseEntity.ok(gameCompanyUtil.createGameCompanySuccessDTO(gameCompany,"Ekleme işlemi başarılı"));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> findAllGameCompanies(){
        List<GameCompany> gameCompanies = gameCompanyService.findAllGameCompanies();

        return ResponseEntity.ok(gameCompanyUtil.createGameCompanyFindSuccessDTO(gameCompanies));
    }

    @RequestMapping(value = "/get?{id}",method = RequestMethod.GET)
    public ResponseEntity<?> findGameCompanyById(@PathVariable(value = "id") Long id){
        GameCompany gameCompany = gameCompanyService.findGameCompanyById(id);
        if (gameCompany == null) {
            throw new IllegalArgumentException("Id değeri yanlış girildi");
        }
        return ResponseEntity.ok(gameCompanyUtil.createGameCompanySuccessDTO(gameCompany,"İşlem Başarılı."));
    }

    @RequestMapping(value = "/list?{companyName}" , method = RequestMethod.GET)
    public ResponseEntity<?> findGameCompaniesByName(@PathVariable(value = "companyName") String companyName){
        List<GameCompany> gameCompanies = gameCompanyService.findGameCompaniesByName(companyName);
        return ResponseEntity.ok(gameCompanyUtil.createGameCompanyFindSuccessDTO(gameCompanies));
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateGameCompany(@RequestBody GameCompanyDTO gameCompanyDTO){
        GameCompanySuccessDTO successDTO = new GameCompanySuccessDTO();
        GameCompany gameCompany = gameCompanyService.findGameCompanyById(gameCompanyDTO.getId());

        if(gameCompany == null){
            throw new IllegalArgumentException("Id yanlış girildi.");
        }else{
            if(gameCompanyDTO.getCompanyDescription() != null && !(gameCompanyDTO.getCompanyDescription().equalsIgnoreCase(gameCompany.getCompanyDescription()))){
                gameCompany.setCompanyDescription(gameCompanyDTO.getCompanyDescription());
            }
            if(gameCompanyDTO.getCompanyName() != null && !(gameCompanyDTO.getCompanyName().equalsIgnoreCase(gameCompany.getCompanyName()))){
                gameCompany.setCompanyName(gameCompanyDTO.getCompanyName());
            }
            if(gameCompanyDTO.getFoundationYear() != null){
                gameCompany.setFoundationYear(gameCompanyDTO.getFoundationYear());
            }

            gameCompanyService.save(gameCompany);
        }
        return ResponseEntity.ok(gameCompanyUtil.createGameCompanySuccessDTO(gameCompany,"Update İşlemi Başarılı."));
    }

    @RequestMapping(value = "/delete" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteGameCompany(@RequestParam Long id){
        GameCompanySuccessDTO successDTO = new GameCompanySuccessDTO();
        GameCompany gameCompany = gameCompanyService.findGameCompanyById(id);

        if(gameCompany == null){
            throw new IllegalArgumentException("Id yanlış girildi.");
        }

        gameCompanyService.delete(gameCompany);

        return ResponseEntity.ok(gameCompanyUtil.createGameCompanySuccessDTO(gameCompany,"Silme işlemi başarılı."));
    }

}
