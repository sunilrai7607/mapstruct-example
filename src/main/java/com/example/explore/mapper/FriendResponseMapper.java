package com.example.explore.mapper;

import com.example.explore.entity.FriendsEntity;
import com.example.explore.model.FriendResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FriendResponseMapper {

    default FriendResponse updateMap(FriendsEntity friendsEntity) {
        FriendResponse friendResponse = new FriendResponse();
        friendResponse.setId(friendsEntity.getId());
        friendResponse.setMessage("Successfully Updated");
        return friendResponse;
    }

    default FriendResponse deleteMap(FriendsEntity friendsEntity) {
        FriendResponse friendResponse = new FriendResponse();
        friendResponse.setId(friendsEntity.getId());
        friendResponse.setMessage("Deleted Successfully");
        return friendResponse;
    }
}
