package com.example.repcard_task_2.model

data class MemebersPojo(
    val id: Int,
    val image: String,
    val title: String,
    val type: String,
    var ismemberchecked:Boolean,
    var count:Int
)