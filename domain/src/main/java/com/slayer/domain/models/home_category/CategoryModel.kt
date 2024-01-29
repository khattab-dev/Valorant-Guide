package com.slayer.domain.models.home_category

import androidx.annotation.DrawableRes

data class CategoryModel(
    val path : String,
    val title : String,
    @DrawableRes val drawableId : Int
)
