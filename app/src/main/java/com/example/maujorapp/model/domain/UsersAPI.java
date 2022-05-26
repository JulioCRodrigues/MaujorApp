package com.example.maujorapp.model.domain;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UsersAPI {

    @GET("users.json")
    Call<List<Users>> getData();
}
