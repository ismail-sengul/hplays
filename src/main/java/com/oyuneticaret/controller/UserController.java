package com.oyuneticaret.controller;

import com.oyuneticaret.dto.game.GameDTO;
import com.oyuneticaret.dto.user.*;
import com.oyuneticaret.model.Game;
import com.oyuneticaret.model.User;
import com.oyuneticaret.service.GameService;
import com.oyuneticaret.service.UserService;
import com.oyuneticaret.utils.GameUtil;
import com.oyuneticaret.utils.UserUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GameService gameService;

    private UserUtil userUtil = new UserUtil();

    private GameUtil gameUtil = new GameUtil();

    @RequestMapping(value = "/save" , method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody UserCreateDTO userCreateDTO){

        if(userCreateDTO.getLastName() == null){
            throw new IllegalArgumentException("Soyadı Boş Bırakılamaz.");
        }else if(userCreateDTO.getFirstName() == null){
            throw new IllegalArgumentException("Ad Boş Bırakılamaz");
        }else if(userCreateDTO.getEmail() == null){
            throw new IllegalArgumentException("Email Boş bırakılamaz");
        }else if(userCreateDTO.getNickname() == null){
            throw new IllegalArgumentException("Kullanıcı Adı boş bırakılamaz.");
        }

        User user = new User();
        user.setLastName(userCreateDTO.getLastName());
        user.setBirthOfDate(userCreateDTO.getBirthOfDate());
        user.setEmail(userCreateDTO.getEmail());
        user.setFirstName(userCreateDTO.getFirstName());
        user.setNickname(userCreateDTO.getNickname());
        user.setAddress(userCreateDTO.getAddress());

        userService.save(user);

        return ResponseEntity.ok(userUtil.createUserSuccessDTO(user,"Ekleme İşlemi Başarılı."));
    }

    @RequestMapping(value = "/list" , method = RequestMethod.GET)
    public ResponseEntity<?> findGames(@RequestParam(required = false) String lastName,
                                       @RequestParam(required = false) String firstName,
                                       @RequestParam(required = false) String nickname){
        UserFindSuccessDTO userFindSuccessDTO = new UserFindSuccessDTO();
        List<User> users = userService.findUsers(firstName,lastName,nickname);
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user: users){
            userDTOS.add(userUtil.convertUserDTO(user));
        }
        userFindSuccessDTO.setUsers(userDTOS);
        userFindSuccessDTO.setMessage("Listeleme İşlemi Başarılı.");

        return ResponseEntity.ok(userFindSuccessDTO);
    }

    @RequestMapping(value = "/get?{id}" , method = RequestMethod.GET)
    public ResponseEntity<?> findGameById(@PathVariable(value = "/id") Long id){
        User user = userService.findUserById(id);

        if(user == null){
            throw new IllegalArgumentException("Kullanıcı bulunamadı.");
        }

        return ResponseEntity.ok(userUtil.createUserSuccessDTO(user,"İşlem Başarılı."));
    }

    @RequestMapping(value = "/update" ,method = RequestMethod.PUT)
    public ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO){
        User user = userService.findUserById(userDTO.getId());

        if(userDTO.getAddress() != null){
            user.setAddress(userDTO.getAddress());
        }
        if(userDTO.getBirthOfDate() != null){
            user.setBirthOfDate(userDTO.getBirthOfDate());
        }
        if(userDTO.getFirstName() != null){
            user.setFirstName(userDTO.getFirstName());
        }
        if(userDTO.getLastName() != null){
            user.setLastName(userDTO.getLastName());
        }
        if(userDTO.getEmail() != null){
            user.setEmail(userDTO.getEmail());
        }
        if(userDTO.getNickname() != null){
            user.setNickname(userDTO.getNickname());
        }

        userService.save(user);

        return ResponseEntity.ok(userUtil.createUserSuccessDTO(user,"Güncelleme işlemi başarılı."));
    }

    @RequestMapping(value = "/delete" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@RequestParam Long id){
        User user = userService.findUserById(id);

        if(user == null){
            throw new IllegalArgumentException("Kullanıcı Bulunamadı.");
        }
        userService.delete(user);

        return ResponseEntity.ok(userUtil.createUserSuccessDTO(user,"Silme İşlemi Başarılı."));
    }

    //Basket Endpoints

    @RequestMapping(value = "/basket/add", method = RequestMethod.POST)
    public ResponseEntity<?> addGameToBasket(@RequestBody GameBasketDTO gameBasketDTO){
        User user = userService.findUserById(gameBasketDTO.getUserId());

        if(user == null){
            throw new IllegalArgumentException("Kullanıcı bulunamadı.");
        }
        Game game = gameService.findGameById(gameBasketDTO.getGameId());

        if(game == null){
            throw new IllegalArgumentException("Oyun bulunamadı.");
        }

        Set<Game> gameBasket = user.getBasket();
        gameBasket.add(game);
        user.setBasket(gameBasket);
        userService.save(user);

        return ResponseEntity.ok(userUtil.createUserGameSuccessDTO(game,user,"Sepete Ekleme İşlemi Başarılı."));
    }

    @RequestMapping(value = "/basket/list" , method = RequestMethod.GET)
    public ResponseEntity<?> listGamesInBasket(@RequestParam Long userId){
        User user = userService.findUserById(userId);

        if(user == null){
            throw new IllegalArgumentException("Kullanıcı Bulunamadı.");
        }

        return ResponseEntity.ok(userUtil.createBasketFindSuccessDTO(user));
    }

    @RequestMapping(value = "/basket/delete?{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAllGamesInBasket(@PathVariable(value = "userId") Long userId){
        User user = userService.findUserById(userId);

        if(user == null){
            throw new IllegalArgumentException("Kullanıcı Bulunamadı.");
        }

        Set<Game> basketGames = user.getBasket();
        basketGames.clear();
        user.setBasket(basketGames);
        userService.save(user);

        return ResponseEntity.ok(userUtil.createUserSuccessDTO(user,"Sepetteki oyunları silme işlemi başarılı."));

    }
    @RequestMapping(value = "/basket/deletegame", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteGameInBasket(@RequestParam Long userId,
                                                @RequestParam Long gameId){
        User user = userService.findUserById(userId);

        if(user == null){
            throw new IllegalArgumentException("Kullanıcı Bulunamadı.");
        }
        Game game = gameService.findGameById(gameId);
        if(game == null){
            throw new IllegalArgumentException("Oyun Bulunamadı.");
        }

        Set<Game> basketGames = user.getBasket();
        basketGames.remove(game);
        user.setBasket(basketGames);
        userService.save(user);

        return ResponseEntity.ok(userUtil.createUserGameSuccessDTO(game,user,"Sepetteki oyunu silme işlemi başarılı."));
    }

    //Wishlist Endpoints

    @RequestMapping(value = "/wishlist/add", method = RequestMethod.POST)
    public ResponseEntity<?> addGameToWishlist(@RequestBody GameBasketDTO gameBasketDTO){
        User user = userService.findUserById(gameBasketDTO.getUserId());

        if(user == null){
            throw new IllegalArgumentException("Kullanıcı bulunamadı.");
        }
        Game game = gameService.findGameById(gameBasketDTO.getGameId());

        if(game == null){
            throw new IllegalArgumentException("Oyun bulunamadı.");
        }

        Set<Game> gameWishlist = user.getWishlist();
        gameWishlist.add(game);

        user.setWishlist(gameWishlist);
        userService.save(user);

        return ResponseEntity.ok(userUtil.createUserGameSuccessDTO(game,user,"İstek Listesine Ekleme İşlemi Başarılı."));
    }


    @RequestMapping(value = "/wishlist/list" , method = RequestMethod.GET)
    public ResponseEntity<?> listGamesInWishlist(@RequestParam Long userId){
        User user = userService.findUserById(userId);

        if(user == null){
            throw new IllegalArgumentException("Kullanıcı Bulunamadı.");
        }

        return ResponseEntity.ok(userUtil.createWishlistFindSuccessDTO(user));
    }

    @RequestMapping(value = "/wishlist/delete?{userId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAllGamesInWishlist(@PathVariable(value = "userId") Long userId){
        User user = userService.findUserById(userId);

        if(user == null){
            throw new IllegalArgumentException("Kullanıcı Bulunamadı.");
        }

        Set<Game> wishlistGame = user.getWishlist();
        wishlistGame.clear();
        user.setWishlist(wishlistGame);
        userService.save(user);

        return ResponseEntity.ok(userUtil.createUserSuccessDTO(user,"İstek listesindeki oyunları silme işlemi başarılı."));

    }
    @RequestMapping(value = "/wishlist/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteGameInWishlist(@RequestParam Long userId,
                                                @RequestParam Long gameId){
        User user = userService.findUserById(userId);

        if(user == null){
            throw new IllegalArgumentException("Kullanıcı Bulunamadı.");
        }

        Game game = gameService.findGameById(gameId);
        if(game == null){
            throw new IllegalArgumentException("Oyun Bulunamadı.");
        }

        Set<Game> wishlistGames = user.getWishlist();
        wishlistGames.remove(game);
        user.setWishlist(wishlistGames);
        userService.save(user);

        return ResponseEntity.ok(userUtil.createUserGameSuccessDTO(game,user,"Oyunu istek listesinden silme işlemi başarılı."));
    }

    //Friends Endpoint
    @RequestMapping(value = "/friend/add" , method = RequestMethod.POST)
    public ResponseEntity<?> addFriend(@RequestBody UserFriendCreateDTO userFriendCreateDTO){
        User mainUser = userService.findUserById(userFriendCreateDTO.getUserId());

        if(mainUser == null){
            throw new IllegalArgumentException("Arkadaşlık ekleme isteği alan kullanıcı bulunamadı");
        }
        User friendUser = userService.findUserById(userFriendCreateDTO.getFriendId());
        if(friendUser == null){
            throw new IllegalArgumentException("Arkadaşlık isteği atan kullanıcı bulunamadı");
        }
        Set<User> mainUserFriends = mainUser.getFriends();
        mainUserFriends.add(friendUser);
        mainUser.setFriends(mainUserFriends);
        userService.save(mainUser);

        Set<User> friendsOfTheRequestingUser = friendUser.getFriends();
        friendsOfTheRequestingUser.add(mainUser);
        friendUser.setFriends(friendsOfTheRequestingUser);
        userService.save(friendUser);

        return ResponseEntity.ok(userUtil.createUserFriendSuccessDTO(mainUser,friendUser,"Ekleme İşlemi Başarılı."));
    }

    @RequestMapping(value = "/friend/list" , method = RequestMethod.GET)
    public ResponseEntity<?> findAllFriends(@RequestParam Long userId){
        User user = userService.findUserById(userId);

        if(user == null){
            throw new IllegalArgumentException("Kullanıcı bulunamadı");
        }

        return ResponseEntity.ok(userUtil.createUserFriendFindSuccessDTO(user));
    }

    @RequestMapping(value = "/friend/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteFriend(@RequestParam Long mainUserId,
                                          @RequestParam Long friendId){
        User mainUser = userService.findUserById(mainUserId);

        if(mainUser == null){
            throw new IllegalArgumentException("Arkadaşlık ekleme isteği alan kullanıcı bulunamadı");
        }
        User friendUser = userService.findUserById(friendId);
        if(friendUser == null){
            throw new IllegalArgumentException("Arkadaşlık isteği atan kullanıcı bulunamadı");
        }
        Set<User> mainUserFriends = mainUser.getFriends();
        mainUserFriends.remove(friendUser);
        mainUser.setFriends(mainUserFriends);
        userService.save(mainUser);

        Set<User> friendsOfTheRequestingUser = friendUser.getFriends();
        friendsOfTheRequestingUser.remove(mainUser);
        friendUser.setFriends(friendsOfTheRequestingUser);
        userService.save(friendUser);

        return ResponseEntity.ok(userUtil.createUserFriendSuccessDTO(mainUser,friendUser,"Silme İşlemi Başarılı."));
    }
}
