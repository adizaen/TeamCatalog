package com.example.katalog.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPI {
    public static String BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";

    @GET("lookup_all_teams.php?id=4331")
    Call<List<Team>> getTeam();
}
