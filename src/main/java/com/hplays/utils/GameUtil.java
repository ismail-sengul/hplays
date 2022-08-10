package com.hplays.utils;

import com.hplays.dto.game.*;
import com.hplays.dto.gamecompany.GameCompanyDTO;
import com.hplays.dto.type.TypeDTO;
import com.hplays.model.Game;
import com.hplays.model.GameCompany;
import com.hplays.model.Types;

import java.util.ArrayList;
import java.util.List;

public class GameUtil {

    TypeUtil typeUtil = new TypeUtil();

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

    public GameTypeSuccessDTO createGameTypeSuccessDTO(Game game, Types type,String message){
        GameTypeSuccessDTO gameTypeSuccessDTO = new GameTypeSuccessDTO();

        gameTypeSuccessDTO.setGame(convertGameDTO(game));
        gameTypeSuccessDTO.setType(typeUtil.convertTypeDTO(type));
        gameTypeSuccessDTO.setMessage(message);

        return gameTypeSuccessDTO;
    }

    public GameTypeFindSuccessDTO createGameTypeFindSuccessDTO(Game game){
        GameTypeFindSuccessDTO gameTypeFindSuccessDTO = new GameTypeFindSuccessDTO();

        List<TypeDTO> typeDTOS = new ArrayList<>();
        for (Types type : game.getTypes()){
            typeDTOS.add(typeUtil.convertTypeDTO(type));
        }
        gameTypeFindSuccessDTO.setGame(convertGameDTO(game));
        gameTypeFindSuccessDTO.setTypes(typeDTOS);
        gameTypeFindSuccessDTO.setMessage("Listeleme İşlemi Başarılı.");


        return gameTypeFindSuccessDTO;
    }

}