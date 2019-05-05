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
        @Part("user_id") user_id: RequestBody,
        @Part("user_password") user_password: RequestBody,
        @Part("user_name") user_name: RequestBody,
        @Part("user_phone") user_phone: RequestBody,
        @Part user_img: MultipartBody.Part?
    ): Call<PostDiaryDrawUpResponse>
}