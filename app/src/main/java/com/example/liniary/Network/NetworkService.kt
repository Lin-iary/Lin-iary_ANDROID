package com.example.liniary.Network

import com.example.liniary.Model.get.GetDiaryListResponse
import com.example.liniary.Model.post.PostDiaryDrawUpResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface NetworkService {

    //일기 작성
    @Multipart
    @POST("/api/diary")
    fun postDiaryDrawUpResponse(
        @Part("content") content: RequestBody,
        @Part photo: MultipartBody.Part?
    ): Call<PostDiaryDrawUpResponse>

    //다이어리 리스트
    @GET("/api/diary")
    fun getDiaryListResponse(
    ): Call<GetDiaryListResponse>
}