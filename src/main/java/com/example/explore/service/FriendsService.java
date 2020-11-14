package com.example.explore.service;

import com.example.explore.model.FriendRequest;
import com.example.explore.model.FriendResponse;
import com.example.explore.transformation.FriendsDto;

import java.util.List;

public interface FriendsService {

    /**
     * Method to findAll friends
     *
     * @return
     */
    List<FriendsDto> findAll();

    /**
     * Method to find friend by Id
     *
     * @param id
     * @return
     */
    FriendsDto findById(Long id);

    /**
     * Method to create friend
     * Method to create friend
     *
     * @param friendRequest
     * @return
     */
    FriendResponse createFriend(FriendRequest friendRequest);

    /**
     * Method to update the friend
     *
     * @param id
     * @param friendRequest
     * @return
     */
    FriendResponse updateFriend(Long id, FriendRequest friendRequest);

    /**
     * Method to delete friend
     *
     * @param id
     * @return
     */
    FriendResponse deleteFriend(Long id);
}
