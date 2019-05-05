package com.example.liniary.Network

import android.support.annotation.NonNull
import com.example.liniary.Model.PostDiaryDrawUpResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {

    @Multipart
    @POST("/api/upload")
    fun postJoin(
        @Part("content") content: String,
        @Part photo: MultipartBody.Part?
    ): Call<PostDiaryDrawUpResponse>
}