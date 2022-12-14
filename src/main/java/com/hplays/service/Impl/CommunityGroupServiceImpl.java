package com.hplays.service.Impl;

import com.hplays.dao.CommunityGroupDao;
import com.hplays.model.CommunityGroup;
import com.hplays.service.CommunityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommunityGroupServiceImpl implements CommunityGroupService {

    @Autowired
    CommunityGroupDao communityGroupDao;

    @Override
    @Transactional
    public void save(CommunityGroup communityGroup) {
        communityGroupDao.save(communityGroup);
    }

    @Override
    public List<CommunityGroup> findCommunityGroups(Long creatorId, String groupName, String groupDescription) {
        return communityGroupDao.findCommunityGroups(creatorId,groupName,groupDescription);
    }

    @Override
    public CommunityGroup findCommunityGroupById(Long id) {
        return communityGroupDao.findCommunityGroupById(id);
    }

    @Override
    @Transactional
    public void delete(CommunityGroup communityGroup) {
        communityGroupDao.delete(communityGroup);
    }
}
