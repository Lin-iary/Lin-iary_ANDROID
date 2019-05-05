package com.example.liniary.Network

import com.example.liniary.Model.post.PostDiaryDrawUpResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    @Multipart
    @POST("/api/diary")
    fun postDiaryDrawUpResponse(
        @Part("content") content: RequestBody,
        @Part photo: MultipartBody.Part?
    ): Call<PostDiaryDrawUpResponse>
}