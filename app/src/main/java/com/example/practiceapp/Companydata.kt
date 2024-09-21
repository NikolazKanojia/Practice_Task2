package com.example.repcard_task_2

data class Companydata(
    val isCheck: Boolean,
    val companyName: String,
    val isEnable: Boolean
)
data class Officedata(
    val isCheckOffice: Boolean,
    val OfficeName: String,
    val isEnableOffice: Boolean
)

data class Memberdata(
    val isCheck_member: Boolean,
    val profile_Img: String,
    val membername: String,
    val job: String
)