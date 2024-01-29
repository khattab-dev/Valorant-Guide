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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.slayer.domain.models.home_category.CategoryModel
import com.slayer.valorantguide.R
import com.slayer.valorantguide.ui.theme.md_theme_dark_secondaryContainer

@Composable
fun HomeScreen(navHostController: NavHostController) {
    val vm: HomeViewModel = viewModel()

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
        items(vm.categories) { category ->
            CategoryCard(category, navHostController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryCard(category: CategoryModel, navHostController: NavHostController) {
    val lifecycleOwner = rememberUpdatedState(LocalLifecycleOwner.current)

    var canNavigate by remember {
        mutableStateOf(true)
    }

    DisposableEffect(lifecycleOwner.value) {
        val lifecycle = lifecycleOwner.value.lifecycle
        val observer = LifecycleEventObserver { owner, event ->
            canNavigate = when (event) {
                Lifecycle.Event.ON_RESUME -> true
                else -> false
            }
        }

        lifecycle.addObserver(observer)
        onDispose {
            lifecycle.removeObserver(observer)
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        border = BorderStroke(2.dp, md_theme_dark_secondaryContainer),
        onClick = { if (canNavigate) navHostController.navigate(category.path) }
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
                    modifier = Modifier
                        .size(100.dp)
                        .padding(16.dp)
                )
            }
        }
    }
}