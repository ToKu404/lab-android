package com.example.loopj;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SingleDataResponse {
    @SerializedName("data")
    private UserResponse data;

    public UserResponse getData() {
        return data;
    }
}