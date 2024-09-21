package com.example.repcard_task_2.model

data class TeamPojo(
    val id: Int,
    val items: List<MemebersPojo>,
    val title: String,
    val type: String,
    var ischeckedteam:Boolean
)