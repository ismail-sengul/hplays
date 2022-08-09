package com.oyuneticaret.utils;

import com.oyuneticaret.dto.user.GameBasketSuccessDTO;
import com.oyuneticaret.dto.game.GameDTO;
import com.oyuneticaret.dto.game.GameFindSuccessDTO;
import com.oyuneticaret.dto.game.GameSuccessDTO;
import com.oyuneticaret.dto.gamecompany.GameCompanyDTO;
import com.oyuneticaret.model.Game;
import com.oyuneticaret.model.GameCompany;
import com.oyuneticaret.model.User;

import java.util.ArrayList;
import java.util.List;

public class GameUtil {

    public GameCompanyDTO convertGameCompanyDTO(GameCompany gameCompany){
        GameCompanyDTO gameCompanyDTO = new GameCompanyDTO();
        gameCompanyDTO.setFoundationYear(gameCompany.getFoundationYear());
        gameCompanyDTO.setCompanyDescription(gameCompany.getCompanyDescription());
        gameCompanyDTO.setCompanyName(gameCompany.getCompanyName());
        gameCompanyDTO.setId(gameCompany.getId());
        return gameCompanyDTO;
    }

    public GameDTO convertGameDTO(Game game){
        GameDTO gameDTO = new GameDTO();
        gameDTO.setGameCompany(convertGameCompanyDTO(game.getGameCompany()));
        gameDTO.setId(game.getId());
        gameDTO.setGameDescription(game.getGameDescription());
        gameDTO.setName(game.getName());
        gameDTO.setPrice(game.getPrice());
        gameDTO.setReleaseDate(game.getReleaseDate());

        return gameDTO;
    }

    public GameSuccessDTO createGameSuccessDTO(Game game,String message){
        GameSuccessDTO gameSuccessDTO = new GameSuccessDTO();
        gameSuccessDTO.setId(game.getId());
        gameSuccessDTO.setName(game.getName());
        gameSuccessDTO.setPrice(game.getPrice());
        gameSuccessDTO.setReleaseDate(game.getReleaseDate());
        gameSuccessDTO.setGameDescription(game.getGameDescription());
        gameSuccessDTO.setGameCompany(convertGameCompanyDTO(game.getGameCompany()));
        gameSuccessDTO.setMessage(message);
        return gameSuccessDTO;
    }

    public GameFindSuccessDTO createGameFindSuccessDTO(List<Game> games){
        GameFindSuccessDTO gameFindSuccessDTO = new GameFindSuccessDTO();
        List<GameDTO> gameDTOS = new ArrayList<>();

        for (Game game : games){
            gameDTOS.add(convertGameDTO(game));
        }
        gameFindSuccessDTO.setGames(gameDTOS);
        gameFindSuccessDTO.setMessage("Listeleme işlemi başarılı.");
        return gameFindSuccessDTO;
    }


}