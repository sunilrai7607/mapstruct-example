package com.example.explore.service.impl;

import com.example.explore.entity.FriendsEntity;
import com.example.explore.exception.ResourceNotFoundException;
import com.example.explore.mapper.FriendDtoMapper;
import com.example.explore.mapper.FriendEntityMapper;
import com.example.explore.mapper.FriendResponseMapper;
import com.example.explore.model.FriendRequest;
import com.example.explore.model.FriendResponse;
import com.example.explore.repository.FriendsRepository;
import com.example.explore.service.FriendsService;
import com.example.explore.model.FriendsDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FriendsServiceImpl implements FriendsService {


    private final FriendsRepository friendsRepository;
    private final FriendEntityMapper friendEntityMapper;
    private final FriendResponseMapper friendResponseMapper;


    @Autowired
    public FriendsServiceImpl(FriendsRepository friendsRepository, FriendEntityMapper friendEntityMapper, FriendResponseMapper friendResponseMapper) {

        this.friendsRepository = friendsRepository;
        this.friendEntityMapper = friendEntityMapper;
        this.friendResponseMapper = friendResponseMapper;
    }


    @Override
    public List<FriendsDto> findAll() {
        return friendsRepository
                .findAll()
                .stream()
                .map(FriendDtoMapper.INSTANCE::map)
                .collect(Collectors.toList());
    }

    /**
     * Method to find friend by Id
     *
     * @param id
     * @return
     */
    @Override
    public FriendsDto findById(Long id) {
        return FriendDtoMapper.INSTANCE
                .map(friendsRepository.findById(id)
                        .orElseThrow(
                                () -> new ResourceNotFoundException("Friend not found for this id :: " + id)
                        )
                );
    }

    /**
     * Method to create friend
     * Method to create friend
     *
     * @param friendRequest
     * @return
     */
    @Override
    public FriendResponse createFriend(FriendRequest friendRequest) {
        FriendsEntity temp = friendEntityMapper.transform(friendRequest);
        log.info("FriendEntity : {} ", temp);
        return friendResponseMapper.updateMap(friendsRepository.save(friendEntityMapper.transform(friendRequest)));
    }

    /**
     * Method to update the friend
     *
     * @param id
     * @param friendRequest
     * @return
     */
    @Override
    public FriendResponse updateFriend(Long id, FriendRequest friendRequest) {
        FriendsEntity friendsEntity = friendsRepository
                .save(friendEntityMapper
                        .map(
                                friendRequest,
                                friendsRepository.findById(id)
                                        .orElseThrow(() -> new ResourceNotFoundException("Friend not found for this id :: " + id)
                                        )
                        )
                );
        log.info("Updated Friends object {} ", friendsEntity);
        return friendResponseMapper.updateMap(friendsEntity);
    }

    /**
     * Method to delete friend
     *
     * @param id
     * @return
     */
    @Override
    public FriendResponse deleteFriend(Long id) {
        FriendsEntity friendEntity = friendsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Friend not found for this id :: " + id));
        friendsRepository.delete(friendEntity);
        return friendResponseMapper.deleteMap(friendEntity);
    }
}
