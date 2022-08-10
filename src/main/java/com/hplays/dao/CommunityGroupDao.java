package com.hplays.dao;

import com.hplays.model.CommunityGroup;

import java.util.List;

public interface CommunityGroupDao {
    void save(CommunityGroup communityGroup);
    List<CommunityGroup> findCommunityGroups(Long creatorId,String groupName,String groupDescription);
    CommunityGroup findCommunityGroupById(Long id);
    void delete(CommunityGroup communityGroup);
}
