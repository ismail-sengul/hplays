package com.oyuneticaret.service;

import com.oyuneticaret.model.CommunityGroup;

import java.util.List;

public interface CommunityGroupService {
    void save(CommunityGroup communityGroup);
    List<CommunityGroup> findCommunityGroups(Long creatorId, String groupName, String groupDescription);
    CommunityGroup findCommunityGroupById(Long id);
    void delete(CommunityGroup communityGroup);
}
