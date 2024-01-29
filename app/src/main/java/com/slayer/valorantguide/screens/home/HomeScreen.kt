package com.slayer.valorantguide.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.slayer.domain.models.home_category.CategoryModel
import com.slayer.valorantguide.R

@Composable
fun HomeScreen(navHostController: NavHostController) {
    val vm : HomeViewModel = viewModel()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentPadding = PaddingValues(
            top = 16.dp,
            bottom = 16.dp,
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(vm.categories) {category ->
            CategoryCard(category,navHostController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(category: CategoryModel, navHostController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        border = BorderStroke(2.dp, Color.Red),
        onClick = {navHostController.navigate(category.path)}
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp)
        ) {
            Text(text = category.title)
            Box(contentAlignment = Alignment.Center) {
                AsyncImage(
                    model = R.drawable.category_bg,
                    contentDescription = null,
                    modifier = Modifier.fillMaxHeight(),
                )
                AsyncImage(
                    model = category.drawableId,
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(100.dp).padding(16.dp)
                )
            }
        }
    }
}