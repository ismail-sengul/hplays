package com.oyuneticaret.dao;

import com.oyuneticaret.model.CommunityGroup;

import java.util.List;

public interface CommunityGroupDao {
    void save(CommunityGroup communityGroup);
    List<CommunityGroup> findCommunityGroups(Long creatorId,String groupName,String groupDescription);
    CommunityGroup findCommunityGroupById(Long id);
    void delete(CommunityGroup communityGroup);
}
