package com.slayer.domain.models

import androidx.annotation.DrawableRes

data class CategoryModel(
    val path : String,
    val title : String,
    @DrawableRes val drawableId : Int
)
