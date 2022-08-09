package com.oyuneticaret.utils;

import com.oyuneticaret.dto.game.GameDTO;
import com.oyuneticaret.dto.user.GameBasketFindSuccess;
import com.oyuneticaret.dto.user.GameBasketSuccessDTO;
import com.oyuneticaret.dto.user.UserDTO;
import com.oyuneticaret.dto.user.UserSuccessDTO;
import com.oyuneticaret.model.Game;
import com.oyuneticaret.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    GameUtil gameUtil = new GameUtil();

    public UserSuccessDTO createUserSuccessDTO(User user,String message){
        UserSuccessDTO userSuccessDTO = new UserSuccessDTO();
        userSuccessDTO.setId(user.getId());
        userSuccessDTO.setFirstName(user.getFirstName());
        userSuccessDTO.setLastName(user.getLastName());
        userSuccessDTO.setAddress(user.getAddress());
        userSuccessDTO.setNickname(user.getNickname());
        userSuccessDTO.setBirthOfDate(user.getBirthOfDate());
        userSuccessDTO.setEmail(user.getEmail());
        userSuccessDTO.setMessage(message);

        return userSuccessDTO;
    }
    public UserDTO convertUserDTO(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setLastName(user.getLastName());
        userDTO.setBirthOfDate(user.getBirthOfDate());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setNickname(user.getNickname());
        userDTO.setAddress(user.getAddress());
        return userDTO;
    }

    public GameBasketSuccessDTO createGameBasketSuccessDTO(Game game, User user, String message){
        GameBasketSuccessDTO gameBasketSuccessDTO = new GameBasketSuccessDTO();

        gameBasketSuccessDTO.setGame(gameUtil.convertGameDTO(game));
        gameBasketSuccessDTO.setUser(convertUserDTO(user));
        gameBasketSuccessDTO.setMessage(message);

        return gameBasketSuccessDTO;
    }

    public GameBasketFindSuccess createGameBasketFindSuccess(User user){
        GameBasketFindSuccess gameBasketFindSuccess = new GameBasketFindSuccess();
        List<GameDTO> gameDTOS = new ArrayList<>();
        UserDTO userDTO = convertUserDTO(user);
        for (Game basketGame : user.getBasket()){
            gameDTOS.add(gameUtil.convertGameDTO(basketGame));
        }
        gameBasketFindSuccess.setGames(gameDTOS);
        gameBasketFindSuccess.setUser(userDTO);
        gameBasketFindSuccess.setMessage("Listeleme İşlemi Başarılı.");

        return gameBasketFindSuccess;
    }
}
