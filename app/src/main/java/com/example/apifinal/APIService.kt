package com.example.apifinal

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface APIService {
    @GET
    suspend fun getSpaceXLaunch(@Url url: String): Response<List<SpaceX>>
}
