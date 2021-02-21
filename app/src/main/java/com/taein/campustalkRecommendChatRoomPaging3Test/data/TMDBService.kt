package com.taein.paging3test.data

import com.taein.campustalkRecommendChatRoomPaging3Test.data.model.RecommendedChatRoomPaging
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TMDBService {

    /**
     * 추천 채팅방 보기
     * @param token
     * @return
     */
    @GET("v3/campus_talk/home/recommendation")
    fun getRecommendedChatRoom(
        @Header("X-Token") token: String,
        @Query("page") page: Int,
        @Query("count") count: Int,
        @Query("private_univ") privateUniv: Int
    ): Single<RecommendedChatRoomPaging>

    companion object {
        private const val CAMPUSTALK_URL = "http://52.79.106.253:8080/api/"

        fun create(): TMDBService {
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BASIC

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(CAMPUSTALK_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(TMDBService::class.java)
        }
    }
}