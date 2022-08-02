package com.miqdad.android.recyclerview.fourth_recyclerview.network

import com.miqdad.android.recyclerview.BuildConfig
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("top-headlines")
    fun getTopHeadlineNews(
        @Query("country") country : String = "ID",
        @Query("apiKey") api_key : String = BuildConfig.API_KEY
    ): Flowable<TopHeadlineResponse>
}