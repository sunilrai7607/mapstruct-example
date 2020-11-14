package com.example.explore.mapper;

import com.example.explore.entity.FriendsEntity;
import com.example.explore.model.FriendsDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public abstract class FriendsMapper {


    public abstract FriendsDto toDto(FriendsEntity friendsEntity);

    public abstract FriendsEntity toEntity(FriendsDto friendsDto);


}
