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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
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

}
@Preview(showBackground = true, device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun HomeCofeeAppPreview() {
    HomeCoffeeApp()
}