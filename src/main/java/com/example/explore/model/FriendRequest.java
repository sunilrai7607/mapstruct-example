package com.example.explore.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class FriendRequest implements Serializable {

    private String firstName;
    private String lastName;
    private String emailId;
    private String address1;
    private String address2;
    private String zip;
    private String state;
}
