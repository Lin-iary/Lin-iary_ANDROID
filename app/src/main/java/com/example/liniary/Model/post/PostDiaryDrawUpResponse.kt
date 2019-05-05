package com.example.liniary.Model.post

data class PostDiaryDrawUpResponse (
    val status: Int,
    val success: Boolean,
    val message : String,
    val data : ArrayList<String>
// 필요없는 데이터(null)은 굳이 안써도 됨
)