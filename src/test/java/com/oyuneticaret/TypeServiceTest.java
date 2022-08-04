package com.oyuneticaret;


import com.oyuneticaret.model.Types;
import com.oyuneticaret.service.TypeService;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class TypeServiceTest {

    @Autowired
    TypeService typeService;

    @Autowired
    SessionFactory sessionFactory;


    @Test
    public void testSave(){

        Types saveType = new Types();
        saveType.setName("TestName");

        typeService.save(saveType);

        Types type = sessionFactory.getCurrentSession().get(Types.class,saveType.getId());

        assertNotEquals(type,null);
    }

    @Test
    public void testUpdate(){

        Types saveType = new Types();
        saveType.setName("TestName");

        typeService.save(saveType);

        List<Types> types = typeService.listTypesByName("TestName");

        assertNotEquals(types.size(),0);

        saveType.setName("NameTest");
        types = typeService.listTypesByName("NameTest");
        assertNotEquals(types.size(),0);
    }


    @Test
    public void testDelete(){

        Types saveType = new Types();
        saveType.setName("TestName");

        typeService.save(saveType);

        Types type = sessionFactory.getCurrentSession().get(Types.class,saveType.getId());

        assertNotEquals(type,null);

        typeService.delete(type);

        Types deletedType = sessionFactory.getCurrentSession().get(Types.class,type.getId());
        assertEquals(deletedType,null);
    }



}
