package com.slayer.valorantguide.screens.home

import androidx.lifecycle.ViewModel
import com.slayer.domain.models.home_category.CategoryModel
import com.slayer.valorantguide.R

class HomeViewModel : ViewModel() {
    val categories = listOf(
        CategoryModel(path = "agents", title = "AGENTS", drawableId = R.drawable.agents),
        CategoryModel(path = "weapons", title = "WEAPONS", drawableId = R.drawable.weapons),
        CategoryModel(path = "ranks", title = "RANKS", drawableId = R.drawable.ranks),
        CategoryModel(path = "sprays", title = "SPRAYS", drawableId = R.drawable.sprays),
        CategoryModel(path = "cards", title = "PLAYER CARDS", drawableId = R.drawable.cards),
        CategoryModel(path = "maps", title = "MAPS", drawableId = R.drawable.maps),
        CategoryModel(path = "buddies", title = "GUN BUDDIES", drawableId = R.drawable.buddies),
    )
}