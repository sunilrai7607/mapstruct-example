package com.example.explore.mapper;

import com.example.explore.entity.FriendsEntity;
import com.example.explore.model.FriendRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FriendEntityMapper {

    default FriendsEntity map(FriendRequest friendRequest, FriendsEntity friendsEntity) {
        friendsEntity.setEmailId(friendRequest.getEmailId());
        friendsEntity.setLastName(friendRequest.getLastName());
        friendsEntity.setFirstName(friendRequest.getFirstName());
        return friendsEntity;
    }


    @Mapping(target = "firstName", source = "friendRequest.firstName")
    @Mapping(target = "lastName", source = "friendRequest.lastName")
    @Mapping(target = "emailId", source = "friendRequest.emailId")
    @Mapping(target = "address1", source = "friendRequest.address1")
    @Mapping(target = "address2", source = "friendRequest.address2")
    @Mapping(target = "zip", source = "friendRequest.zip")
    @Mapping(target = "state", source = "friendRequest.state")
    FriendsEntity transform(FriendRequest friendRequest);
}
