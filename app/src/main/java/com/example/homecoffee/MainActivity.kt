package com.example.homecoffee

import CategoryItem
import HomeSection
import MenuItem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.homecoffee.model.BottomBarItem
import com.example.homecoffee.model.Menu
import com.example.homecoffee.model.dummyBestMenu
import com.example.homecoffee.model.dummyCategory
import com.example.homecoffee.model.dummyMenu
import com.example.homecoffee.ui.components.Search
import com.example.homecoffee.ui.theme.HomeCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeCoffeeTheme {
                HomeCoffeeApp()
            }
        }
    }
}

@Composable
fun HomeCoffeeApp() {
    Scaffold(
        bottomBar = { BottomBar() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            Banner()
            HomeSection(
                title = stringResource(R.string.section_category),
                content = { CategoryRow() }
            )
            HomeSection(
                title = stringResource(R.string.section_favorite_menu),
                content = { MenuRow(dummyMenu) }
            )
            HomeSection(
                title = stringResource(R.string.section_best_seller_menu),
                content = { MenuRow(dummyBestMenu) }
            )
        }
    }
}

@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "banner",
            contentScale = ContentScale.Crop,
            modifier = Modifier.height(160.dp)
            )
        Search()
    }
}
@Composable
fun CategoryRow(modifier: Modifier = Modifier) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(dummyCategory, key = {it.textCategory}) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(listMenu, key = {it.title}) {menu ->
            MenuItem(menu)
        }
    }
}

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        val navigationItems = listOf(
            BottomBarItem(
                title = stringResource(R.string.menu_home),
                icon = Icons.Default.Home
            ),
            BottomBarItem(
                title = stringResource(R.string.menu_favorite),
                icon = Icons.Default.Favorite
            ),
            BottomBarItem(
                title = stringResource(R.string.menu_profile),
                icon = Icons.Default.AccountCircle
            ),
        )
        navigationItems.map {
            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                },
                label = {
                    Text(it.title)
                },
                selected = it.title == navigationItems[0].title,
                onClick = {}
            )
        }
    }
}
@Preview(showBackground = true, device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun HomeCofeeAppPreview() {
    HomeCoffeeTheme {
        HomeCoffeeApp()
    }
}