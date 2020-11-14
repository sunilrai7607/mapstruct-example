package com.example.explore.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class FriendResponse implements Serializable {

    private Long Id;
    private String message;
}
