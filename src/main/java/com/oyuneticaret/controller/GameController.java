package com.oyuneticaret.controller;

import com.oyuneticaret.dto.game.*;
import com.oyuneticaret.dto.gamecompany.GameCompanyDTO;
import com.oyuneticaret.model.Game;
import com.oyuneticaret.model.GameCompany;
import com.oyuneticaret.service.GameCompanyService;
import com.oyuneticaret.service.GameService;
import com.oyuneticaret.utils.GameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameCompanyService gameCompanyService;

    private GameUtil gameUtil = new GameUtil();

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody GameCreateDTO gameCreateDTO){

        if(gameCreateDTO.getName() == null){
            throw new IllegalArgumentException("Oyun adı boş olamaz.");
        }else if(gameCreateDTO.getPrice() == null){
            throw new IllegalArgumentException("Oyun fiyatı boş olamaz");
        }

        Game game = new Game();
        game.setName(gameCreateDTO.getName());
        game.setGameDescription(gameCreateDTO.getGameDescription());
        game.setPrice(gameCreateDTO.getPrice());
        game.setReleaseDate(gameCreateDTO.getReleaseDate());

        GameCompany gameCompany = gameCompanyService.findGameCompanyById(gameCreateDTO.getGameCompanyId());

        if(gameCompany == null) {
            throw new IllegalArgumentException("Oyun şirketi bulunamadı.");
        }

        game.setGameCompany(gameCompany);

        gameService.save(game);

        return ResponseEntity.ok(gameUtil.createGameSuccessDTO(game,"Oyun Ekleme İşlemi Başarılı."));
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> findGames(@RequestParam(required = false) String name,
                                       @RequestParam(required = false) BigDecimal price,
                                       @RequestParam(required = false) Long gameCompanyId){
        List<Game> games = gameService.findGames(name,price,gameCompanyId);
        return ResponseEntity.ok(gameUtil.createGameFindSuccessDTO(games));
    }


    @RequestMapping(value = "/get?{id}" , method = RequestMethod.GET)
    public ResponseEntity<?> findGameById(@PathVariable(value = "id") Long id){
        GameSuccessDTO gameSuccessDTO = new GameSuccessDTO();
        Game game = gameService.findGameById(id);
        if(game == null){
            throw new IllegalArgumentException("Id yanlış girildi.");
        }
        return ResponseEntity.ok(gameUtil.createGameSuccessDTO(game,"İşlem Başarılı."));
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateGame(@RequestBody GameUpdateDTO gameUpdateDTO){

        Game game = gameService.findGameById(gameUpdateDTO.getId());

        if(game == null){
            throw new IllegalArgumentException("Id yanlış girildi");
        }

        GameCompany gameCompany = gameCompanyService.findGameCompanyById(gameUpdateDTO.getId());

        if(gameCompany == null){
            throw new IllegalArgumentException("Oyun şirketi bulunamadı.");
        }
        game.setGameCompany(gameCompany);
        if(gameUpdateDTO.getGameDescription() != null && !(game.getGameDescription().equalsIgnoreCase(gameUpdateDTO.getGameDescription()))){
            game.setGameDescription(gameUpdateDTO.getGameDescription());
        }
        if(gameUpdateDTO.getName() != null && !(game.getName().equalsIgnoreCase(gameUpdateDTO.getName()))){
            game.setName(gameUpdateDTO.getName());
        }
        if(gameUpdateDTO.getPrice() != null){
            game.setPrice(gameUpdateDTO.getPrice());
        }
        if(gameUpdateDTO.getReleaseDate() != null){
            game.setReleaseDate(gameUpdateDTO.getReleaseDate());
        }
        gameService.save(game);

        return ResponseEntity.ok(gameUtil.createGameSuccessDTO(game,"Update İşlemi Başarılı."));
    }

    @RequestMapping(value = "/delete?{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteGame(@PathVariable(value = "id") Long id){
        Game game = gameService.findGameById(id);

        if(game == null){
            throw new IllegalArgumentException("Oyun bulunamadı.");
        }
        gameService.delete(game);

        return ResponseEntity.ok(gameUtil.createGameSuccessDTO(game,"Silme İşlemi Başarılı."));
    }


}
