package com.oyuneticaret;

import com.oyuneticaret.model.Game;
import com.oyuneticaret.model.GameCompany;
import com.oyuneticaret.service.GameService;
import org.hibernate.SessionFactory;
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

    @Autowired
    SessionFactory sessionFactory;


    @Test
    public void testSave(){

        Game saveGame = new Game();
        GameCompany gameCompany = new GameCompany();
        saveGame.setGameCompany(gameCompany);
        saveGame.setReleaseDate(new Date());
        saveGame.setPrice(new BigDecimal("22.3"));
        saveGame.setName("TestGame");
        saveGame.setGameDescription("TestDesc");

        gameService.save(saveGame);
        Game game = sessionFactory.getCurrentSession().get(Game.class,saveGame.getId());
        assertNotEquals(game,null);
    }

    @Test
    public void testUpdate(){
        Game saveGame = new Game();
        GameCompany gameCompany = new GameCompany();
        saveGame.setGameCompany(gameCompany);
        saveGame.setReleaseDate(new Date());
        saveGame.setPrice(new BigDecimal("22.3"));
        saveGame.setName("TestGame");
        saveGame.setGameDescription("TestDesc");

        gameService.save(saveGame);

        saveGame.setName("GameTest");

        gameService.save(saveGame);

        List<Game> nameTest = gameService.findGames("GameTest",null,null);
        assertNotEquals(nameTest.size(),0);

        saveGame.setPrice(new BigDecimal("24.5"));
        gameService.save(saveGame);
        List<Game> priceTest = gameService.findGames(null,new BigDecimal("24.5"),null);
        assertNotEquals(priceTest.size(),0);
    }

    @Test
    public void testDelete(){
        Game saveGame = new Game();
        GameCompany gameCompany = new GameCompany();
        saveGame.setGameCompany(gameCompany);
        saveGame.setReleaseDate(new Date());
        saveGame.setPrice(new BigDecimal("22.3"));
        saveGame.setName("TestGame");
        saveGame.setGameDescription("TestDesc");

        gameService.save(saveGame);

        Game game = sessionFactory.getCurrentSession().get(Game.class,saveGame.getId());
        assertNotEquals(game,null);

         gameService.delete(game);
         Game deletedGame = sessionFactory.getCurrentSession().get(Game.class,game.getId());
         assertEquals(deletedGame,null);
    }

}
