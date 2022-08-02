package com.oyuneticaret.utils;

import com.oyuneticaret.dto.gamecompany.GameCompanyDTO;
import com.oyuneticaret.dto.gamecompany.GameCompanyFindSuccessDTO;
import com.oyuneticaret.dto.gamecompany.GameCompanySuccessDTO;
import com.oyuneticaret.model.Game;
import com.oyuneticaret.model.GameCompany;

import java.util.ArrayList;
import java.util.List;

public class GameCompanyUtil {

    public GameCompanyFindSuccessDTO createGameCompanyFindSuccessDTO(List<GameCompany> gameCompanies){
        GameCompanyFindSuccessDTO gameCompanyFindSuccessDTO = new GameCompanyFindSuccessDTO();
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
        return gameCompanyFindSuccessDTO;
    }

    public GameCompanySuccessDTO createGameCompanySuccessDTO(GameCompany gameCompany,String message){
        GameCompanySuccessDTO successDTO = new GameCompanySuccessDTO();
        successDTO.setId(gameCompany.getId());
        successDTO.setCompanyDescription(gameCompany.getCompanyDescription());
        successDTO.setCompanyName(gameCompany.getCompanyName());
        successDTO.setFoundationYear(gameCompany.getFoundationYear());
        successDTO.setMessage(message);
        return successDTO;
    }
}
