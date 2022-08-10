package com.oyuneticaret.utils;

import com.oyuneticaret.dto.game.GameDTO;
import com.oyuneticaret.dto.user.*;
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

    public UserGameSuccessDTO createUserGameSuccessDTO(Game game, User user, String message){
        UserGameSuccessDTO userGameSuccessDTO = new UserGameSuccessDTO();

        userGameSuccessDTO.setGame(gameUtil.convertGameDTO(game));
        userGameSuccessDTO.setUser(convertUserDTO(user));
        userGameSuccessDTO.setMessage(message);

        return userGameSuccessDTO;
    }

    public UserGamesSuccessDTO createBasketFindSuccessDTO(User user){
        UserGamesSuccessDTO userGamesSuccessDTO = new UserGamesSuccessDTO();
        List<GameDTO> gameDTOS = new ArrayList<>();
        UserDTO userDTO = convertUserDTO(user);
        for (Game basketGame : user.getBasket()){
            gameDTOS.add(gameUtil.convertGameDTO(basketGame));
        }
        userGamesSuccessDTO.setGames(gameDTOS);
        userGamesSuccessDTO.setUser(userDTO);
        userGamesSuccessDTO.setMessage("Sepet Listeleme İşlemi Başarılı");

        return userGamesSuccessDTO;
    }

    public UserGamesSuccessDTO createWishlistFindSuccessDTO(User user){
        UserGamesSuccessDTO userGamesSuccessDTO = new UserGamesSuccessDTO();
        List<GameDTO> gameDTOS = new ArrayList<>();
        UserDTO userDTO = convertUserDTO(user);
        for (Game wishlistGame : user.getWishlist()){
            gameDTOS.add(gameUtil.convertGameDTO(wishlistGame));
        }
        userGamesSuccessDTO.setGames(gameDTOS);
        userGamesSuccessDTO.setUser(userDTO);
        userGamesSuccessDTO.setMessage("İstek Listesi Listeleme İşlemi Başarılı");

        return userGamesSuccessDTO;
    }

    public UserFriendSuccessDTO createUserFriendSuccessDTO(User mainUser,User friendUser,String message){
        UserFriendSuccessDTO userFriendSuccessDTO = new UserFriendSuccessDTO();

        userFriendSuccessDTO.setFriendUser(convertUserDTO(friendUser));
        userFriendSuccessDTO.setMainUser(convertUserDTO(mainUser));
        userFriendSuccessDTO.setMessage(message);

        return userFriendSuccessDTO;
    }

    public UserFriendFindSuccessDTO createUserFriendFindSuccessDTO(User user){
        UserFriendFindSuccessDTO userFriendFindSuccessDTO = new UserFriendFindSuccessDTO();
        List<UserDTO> userDTOS = new ArrayList<>();

        for (User friend : user.getFriends()){
            userDTOS.add(convertUserDTO(friend));
        }
        userFriendFindSuccessDTO.setUser(convertUserDTO(user));
        userFriendFindSuccessDTO.setFriends(userDTOS);
        userFriendFindSuccessDTO.setMessage("Listeleme İşlemi Başarılı.");

        return userFriendFindSuccessDTO;
    }
}
