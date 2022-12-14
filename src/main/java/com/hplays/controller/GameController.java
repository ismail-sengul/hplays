package com.hplays.controller;

import com.hplays.dto.game.*;
import com.hplays.model.Game;
import com.hplays.model.GameCompany;
import com.hplays.model.Types;
import com.hplays.service.GameCompanyService;
import com.hplays.service.GameService;
import com.hplays.service.TypeService;
import com.hplays.utils.GameUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameCompanyService gameCompanyService;

    @Autowired
    private TypeService typeService;

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

    @RequestMapping(value = "/type/add" , method = RequestMethod.POST)
    public ResponseEntity<?> addType(@RequestBody GameTypeCreateDTO gameTypeCreateDTO){

        Game game = gameService.findGameById(gameTypeCreateDTO.getGameId());
        if(game == null){
            throw new IllegalArgumentException("Oyun Bulunamadı.");
        }

        Types type = typeService.listTypesById(gameTypeCreateDTO.getTypeId());
        if(type == null){
            throw new IllegalArgumentException("Oyun tipi bulunamadı.");
        }

        Set<Types> gameTypes = game.getTypes();
        gameTypes.add(type);
        game.setTypes(gameTypes);
        gameService.save(game);

        return ResponseEntity.ok(gameUtil.createGameTypeSuccessDTO(game,type,"Ekleme İşlemi Başarılı."));
    }
    @RequestMapping(value = "/type/list" , method = RequestMethod.GET)
    public ResponseEntity<?> findTypes(@RequestParam Long gameId){
        Game game = gameService.findGameById(gameId);

        if(game == null){
            throw new IllegalArgumentException("Oyun Bulunamadı");
        }

        return ResponseEntity.ok(gameUtil.createGameTypeFindSuccessDTO(game));
    }

    @RequestMapping(value = "/type/delete" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteType(@RequestParam Long gameId,
                                        @RequestParam Long typeId){

        Game game = gameService.findGameById(gameId);
        if(game == null){
            throw new IllegalArgumentException("Oyun Bulunamadı.");
        }

        Types type = typeService.listTypesById(typeId);
        if(type == null){
            throw new IllegalArgumentException("Oyun tipi bulunamadı.");
        }

        Set<Types> gameTypes = game.getTypes();
        gameTypes.remove(type);
        game.setTypes(gameTypes);
        gameService.save(game);

        return ResponseEntity.ok(gameUtil.createGameTypeSuccessDTO(game,type,"Silme İşlemi Başarılı."));
    }

}
