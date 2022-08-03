package com.oyuneticaret;

import com.oyuneticaret.model.Game;
import com.oyuneticaret.model.GameCompany;
import com.oyuneticaret.service.GameService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class GameServiceTest {

    @Autowired
    GameService gameService;

    @Test
    public void testSave(){

        Game game = new Game();
        GameCompany gameCompany = new GameCompany();
        game.setGameCompany(gameCompany);
        game.setReleaseDate(new Date());
        game.setPrice(new BigDecimal("22.3"));
        game.setName("TestGame");
        game.setGameDescription("TestDesc");

        gameService.save(game);

        List<Game> games = gameService.findGames("TestGame",null,null);
        System.out.println(games.size());
        assertNotEquals(games.size(),0);
    }

    @Test
    public void testUpdate(){
        Game game = new Game();
        GameCompany gameCompany = new GameCompany();
        game.setGameCompany(gameCompany);
        game.setReleaseDate(new Date());
        game.setPrice(new BigDecimal("22.3"));
        game.setName("TestGame");
        game.setGameDescription("TestDesc");

        gameService.save(game);

        game.setName("GameTest");

        gameService.save(game);

        List<Game> nameTest = gameService.findGames("GameTest",null,null);
        assertNotEquals(nameTest.size(),0);

        game.setPrice(new BigDecimal("24.5"));
        gameService.save(game);
        List<Game> priceTest = gameService.findGames(null,new BigDecimal("24.5"),null);
        assertNotEquals(priceTest.size(),0);
    }

}
