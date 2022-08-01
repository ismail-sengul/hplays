package com.oyuneticaret.controller;

import com.oyuneticaret.dto.game.*;
import com.oyuneticaret.dto.gamecompany.GameCompanyDTO;
import com.oyuneticaret.model.Game;
import com.oyuneticaret.model.GameCompany;
import com.oyuneticaret.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/game")
public class GameController {

    @Autowired
    GameService gameService;

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody GameCreateDTO gameCreateDTO){
        GameSuccessDTO gameSuccessDTO = new GameSuccessDTO();

        if(gameCreateDTO.getName() == null){
            throw new IllegalArgumentException("Oyun adı boş olamaz.");
        }else if(gameCreateDTO.getPrice() == null){
            throw new IllegalArgumentException("Oyun fiyatı boş olamaz");
        }else{
            Game game = new Game();
            game.setName(gameCreateDTO.getName());
            game.setGameDescription(gameCreateDTO.getGameDescription());
            game.setPrice(gameCreateDTO.getPrice());
            game.setReleaseDate(gameCreateDTO.getReleaseDate());

            GameCompany gameCompany = new GameCompany();
            gameCompany.setFoundationYear(gameCreateDTO.getGameCompany().getFoundationYear());
            gameCompany.setCompanyName(gameCreateDTO.getGameCompany().getCompanyName());
            gameCompany.setCompanyDescription(gameCreateDTO.getGameCompany().getCompanyDescription());
            game.setGameCompany(gameCompany);

            gameService.save(game);

            gameSuccessDTO.setId(game.getId());
            gameSuccessDTO.setGameCompany(gameCreateDTO.getGameCompany());
            gameSuccessDTO.setGameDescription(gameCreateDTO.getGameDescription());
            gameSuccessDTO.setName(gameCreateDTO.getName());
            gameSuccessDTO.setPrice(gameCreateDTO.getPrice());
            gameSuccessDTO.setReleaseDate(gameCreateDTO.getReleaseDate());
            gameSuccessDTO.setMessage("Oyun Ekleme İşlemi Başarılı.");
        }

        return ResponseEntity.ok(gameSuccessDTO);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> findAllGames(){
        GameFindSuccessDTO gameFindSuccessDTO = new GameFindSuccessDTO();

        List<Game> games = gameService.findAllGames();
        List<GameDTO> gameDTOS = new ArrayList<>();

        for (Game game : games){
            GameDTO gameDTO = new GameDTO();

            GameCompanyDTO gameCompanyDTO = new GameCompanyDTO();
            gameCompanyDTO.setFoundationYear(game.getGameCompany().getFoundationYear());
            gameCompanyDTO.setCompanyDescription(game.getGameCompany().getCompanyDescription());
            gameCompanyDTO.setCompanyName(game.getGameCompany().getCompanyName());
            gameCompanyDTO.setId(game.getGameCompany().getId());

            gameDTO.setGameCompany(gameCompanyDTO);
            gameDTO.setId(game.getId());
            gameDTO.setGameDescription(game.getGameDescription());
            gameDTO.setName(game.getName());
            gameDTO.setPrice(game.getPrice());
            gameDTO.setReleaseDate(game.getReleaseDate());

            gameDTOS.add(gameDTO);
        }
        gameFindSuccessDTO.setGames(gameDTOS);
        gameFindSuccessDTO.setMessage("Listeleme işlemi başarılı.");

        return ResponseEntity.ok(gameFindSuccessDTO);
    }

    @RequestMapping(value = "/get" , method = RequestMethod.GET)
    public ResponseEntity<?> findGamesByName(@RequestParam String name){
        GameFindSuccessDTO gameFindSuccessDTO = new GameFindSuccessDTO();

        List<Game> games = gameService.findGamesByName(name);
        List<GameDTO> gameDTOS = new ArrayList<>();

        for (Game game : games){
            GameDTO gameDTO = new GameDTO();

            GameCompanyDTO gameCompanyDTO = new GameCompanyDTO();
            gameCompanyDTO.setFoundationYear(game.getGameCompany().getFoundationYear());
            gameCompanyDTO.setCompanyDescription(game.getGameCompany().getCompanyDescription());
            gameCompanyDTO.setCompanyName(game.getGameCompany().getCompanyName());
            gameCompanyDTO.setId(game.getGameCompany().getId());


            gameDTO.setGameCompany(gameCompanyDTO);
            gameDTO.setId(game.getId());
            gameDTO.setGameDescription(game.getGameDescription());
            gameDTO.setName(game.getName());
            gameDTO.setPrice(game.getPrice());
            gameDTO.setReleaseDate(game.getReleaseDate());

            gameDTOS.add(gameDTO);
        }
        gameFindSuccessDTO.setGames(gameDTOS);
        gameFindSuccessDTO.setMessage("Listeleme işlemi başarılı.");
        return ResponseEntity.ok(gameFindSuccessDTO);
    }

    @RequestMapping(value = "/list?{id}" , method = RequestMethod.GET)
    public ResponseEntity<?> findGameById(@PathVariable(value = "id") Long id){
        GameSuccessDTO gameSuccessDTO = new GameSuccessDTO();
        Game game = gameService.findGameById(id);

        if(game == null){
            throw new IllegalArgumentException("Id yanlış girildi.");
        }else{
            gameSuccessDTO.setId(game.getId());
            gameSuccessDTO.setName(game.getName());
            gameSuccessDTO.setPrice(game.getPrice());
            gameSuccessDTO.setReleaseDate(game.getReleaseDate());
            gameSuccessDTO.setGameDescription(game.getGameDescription());

            GameCompanyDTO gameCompanyDTO = new GameCompanyDTO();
            gameCompanyDTO.setFoundationYear(game.getGameCompany().getFoundationYear());
            gameCompanyDTO.setCompanyDescription(game.getGameCompany().getCompanyDescription());
            gameCompanyDTO.setCompanyName(game.getGameCompany().getCompanyName());
            gameCompanyDTO.setId(game.getGameCompany().getId());

            gameSuccessDTO.setGameCompany(gameCompanyDTO);
            gameSuccessDTO.setMessage("İşlem başarılı.");
        }
        return ResponseEntity.ok(gameSuccessDTO);
    }

    @RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public ResponseEntity<?> updateGame(@RequestBody GameUpdateDTO gameUpdateDTO){
        GameSuccessDTO gameSuccessDTO = new GameSuccessDTO();

        Game game = gameService.findGameById(gameUpdateDTO.getId());

        if(game == null){
            throw new IllegalArgumentException("Id yanlış girildi");
        }else{

            if(gameUpdateDTO.getGameCompany() != null){
                GameCompany gameCompany = new GameCompany();
                gameCompany.setFoundationYear(gameUpdateDTO.getGameCompany().getFoundationYear());
                gameCompany.setCompanyDescription(gameUpdateDTO.getGameCompany().getCompanyDescription());
                gameCompany.setCompanyName(gameUpdateDTO.getGameCompany().getCompanyName());
                gameCompany.setId(gameUpdateDTO.getGameCompany().getId());

                game.setGameCompany(gameCompany);
            }
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

            GameCompanyDTO gameCompanyDTO = new GameCompanyDTO();
            gameCompanyDTO.setFoundationYear(game.getGameCompany().getFoundationYear());
            gameCompanyDTO.setCompanyDescription(game.getGameCompany().getCompanyDescription());
            gameCompanyDTO.setCompanyName(game.getGameCompany().getCompanyName());
            gameCompanyDTO.setId(game.getGameCompany().getId());

            gameSuccessDTO.setGameCompany(gameCompanyDTO);

            gameSuccessDTO.setGameDescription(game.getGameDescription());
            gameSuccessDTO.setId(game.getId());
            gameSuccessDTO.setReleaseDate(game.getReleaseDate());
            gameSuccessDTO.setPrice(game.getPrice());
            gameSuccessDTO.setName(game.getName());
            gameSuccessDTO.setMessage("Update işlemi başarılı.");
        }

        return ResponseEntity.ok(gameSuccessDTO);

    }

    @RequestMapping(value = "/delete" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteGame(@RequestParam Long id){
        GameSuccessDTO gameSuccessDTO = new GameSuccessDTO();
        Game game = gameService.findGameById(id);

        gameService.delete(game);

        GameCompanyDTO gameCompanyDTO = new GameCompanyDTO();
        gameCompanyDTO.setFoundationYear(game.getGameCompany().getFoundationYear());
        gameCompanyDTO.setCompanyDescription(game.getGameCompany().getCompanyDescription());
        gameCompanyDTO.setCompanyName(game.getGameCompany().getCompanyName());
        gameCompanyDTO.setId(game.getGameCompany().getId());

        gameSuccessDTO.setGameCompany(gameCompanyDTO);
        gameSuccessDTO.setName(game.getName());
        gameSuccessDTO.setPrice(game.getPrice());
        gameSuccessDTO.setReleaseDate(game.getReleaseDate());
        gameSuccessDTO.setGameDescription(game.getGameDescription());
        gameSuccessDTO.setId(game.getId());
        gameSuccessDTO.setMessage("Silme İşlemi Başarılı.");

        return ResponseEntity.ok(gameSuccessDTO);
    }


}
