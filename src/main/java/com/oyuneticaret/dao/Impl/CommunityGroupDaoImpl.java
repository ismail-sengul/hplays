package com.oyuneticaret.dao.Impl;

import com.oyuneticaret.dao.CommunityGroupDao;
import com.oyuneticaret.model.CommunityGroup;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommunityGroupDaoImpl implements CommunityGroupDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(CommunityGroup communityGroup) {
        getCurrentSession().save(communityGroup);
    }

    @Override
    public List<CommunityGroup> findCommunityGroups(Long creatorId, String groupName, String groupDescription) {
        StringBuilder query = new StringBuilder("SELECT * FROM COMMUNITY_GROUP AS C WHERE 1=1");

        if(creatorId != null){
            query.append(" AND C.CREATOR_ID = "+creatorId);
        }
        if(groupName != null){
            query.append(" AND C.GROUP_NAME LIKE %"+groupName+"%");
        }
        if(groupDescription != null){
            query.append(" AND C.GROUP_DESCRIPTION LIKE %"+groupDescription+"%");
        }

        return getCurrentSession().createNativeQuery(query.toString()).addEntity(CommunityGroup.class).getResultList();
    }

    @Override
    public CommunityGroup findCommunityGroupById(Long id) {
        return getCurrentSession().get(CommunityGroup.class,id);
    }

    @Override
    public void delete(CommunityGroup communityGroup) {
        getCurrentSession().delete(communityGroup);
    }
}
