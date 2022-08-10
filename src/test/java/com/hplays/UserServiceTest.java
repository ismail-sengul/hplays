package com.hplays;

import com.hplays.model.User;
import com.hplays.service.UserService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    SessionFactory sessionFactory;

    @Test
    public void testSave(){
        User saveUser = new User();
        saveUser.setNickname("Nickname");
        saveUser.setEmail("test@test.com");
        saveUser.setLastName("TestLName");
        saveUser.setFirstName("TestFName");
        saveUser.setBirthOfDate(new Date());
        saveUser.setAddress("Address");

        userService.save(saveUser);
        User user = sessionFactory.getCurrentSession().get(User.class,saveUser.getId());
        assertNotEquals(user,null);
    }

    @Test
    public void testUpdate(){
        User saveUser = new User();
        saveUser.setNickname("Nickname");
        saveUser.setEmail("test@test.com");
        saveUser.setLastName("TestLName");
        saveUser.setFirstName("TestFName");
        saveUser.setBirthOfDate(new Date());
        saveUser.setAddress("Address");

        userService.save(saveUser);
        List<User> users = userService.findUsers("TestFName","TestLName","Nickname");
        assertNotEquals(users.size(),0);

        saveUser.setNickname("TestNickname");
        saveUser.setEmail("test@test.com");
        saveUser.setLastName("LNameTest");
        saveUser.setFirstName("FNameTest");

        userService.save(saveUser);

        users = userService.findUsers("FNameTest","LNameTest","TestNickname");
        assertNotEquals(users.size(),0);
    }

    @Test
    public void testDelete(){
        User saveUser = new User();
        saveUser.setNickname("Nickname");
        saveUser.setEmail("test@test.com");
        saveUser.setLastName("TestLName");
        saveUser.setFirstName("TestFName");
        saveUser.setBirthOfDate(new Date());
        saveUser.setAddress("Address");

        userService.save(saveUser);
        User user = sessionFactory.getCurrentSession().get(User.class,saveUser.getId());
        assertNotEquals(user,null);

        userService.delete(user);
        User deletedUser = sessionFactory.getCurrentSession().get(User.class,user.getId());
        assertEquals(deletedUser,null);

    }
}
