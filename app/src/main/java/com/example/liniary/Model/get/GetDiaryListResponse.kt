package com.example.liniary.Model.get

data class GetDiaryListResponse (
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: ArrayList<GetDiaryListResponseData>
)

data class GetDiaryListResponseData(
    val content: String,
    val url: String,
    val idx: String,
    val write_date: String,
    val consult_idx: String,
    val state: Int,
    val conselor_content: String,
    val conselor_name: String,
    val conselor_organization: String
)
