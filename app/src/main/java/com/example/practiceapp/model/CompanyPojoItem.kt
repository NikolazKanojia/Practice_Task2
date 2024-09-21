package com.example.repcard_task_2.model

data class CompanyPojoItem(
    val id: Int,
    val image: String,
    val items: List<TeamPojo>,
    val title: String,
    val type: String,
    var ischecked:Boolean
)