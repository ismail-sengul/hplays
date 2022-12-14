package com.hplays;


import com.hplays.dao.TypeDao;
import com.hplays.model.Types;
import com.hplays.service.TypeService;
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
    TypeDao typeDao;

    @Autowired
    TypeService typeService;


    @Test
    public void testSave(){

        Types saveType = new Types();
        saveType.setName("TestName");

        typeService.save(saveType);

        Types type = typeDao.listTypesById(saveType.getId());

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

        Types type = typeDao.listTypesById(saveType.getId());

        assertNotEquals(type,null);

        typeService.delete(type);

        Types deletedType = typeDao.listTypesById(saveType.getId());
        assertEquals(deletedType,null);
    }



}
