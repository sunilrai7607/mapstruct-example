package com.example.explore.mapper;

import com.example.explore.entity.FriendsEntity;
import com.example.explore.transformation.FriendsDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class FriendDtoMapper implements BaseMapper<FriendsEntity, FriendsDto> {

    public static final FriendDtoMapper INSTANCE = Mappers.getMapper(FriendDtoMapper.class);

    @Mapping(target = "id", source = "input.id")
    @Mapping(target = "firstName", source = "input.firstName")
    @Mapping(target = "lastName", source = "input.lastName")
    @Mapping(target = "emailId", source = "input.emailId")
    //@Mapping(target = "address1", source = "input.address1")
    //@Mapping(target = "address2", source = "input.address2")
    //@Mapping(target = "zip", source = "input.zip")
    //@Mapping(target = "state", source = "input.state")
    public abstract FriendsDto map(FriendsEntity input);
}
