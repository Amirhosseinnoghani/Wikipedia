package com.example.wikipedia.data

data class ItemPost(

    val imgUrl: String,
    val txtTitle: String,
    val txtSubtitle: String,
    val txtDetail: String,
    // for trend data =>
    val isTrend: Boolean,
    val insight: String

)
