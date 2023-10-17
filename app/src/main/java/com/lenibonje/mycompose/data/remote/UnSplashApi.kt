package com.lenibonje.mycompose.data.remote

import com.lenibonje.mycompose.BuildConfig
import com.lenibonje.mycompose.model.SearchResult
import com.lenibonje.mycompose.model.UnSplashImage
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnSplashApi {

    @Headers("Authorization", "Client-ID ${BuildConfig.ACCESS_KEY}")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
    ): List<UnSplashImage>

    @Headers("Authorization", "Client-ID ${BuildConfig.ACCESS_KEY}")
    @GET("search/photos")
    suspend fun searchImages(
        @Query("query") query: String,
        @Query("per_page") perPage: Int,
    ): SearchResult

}
