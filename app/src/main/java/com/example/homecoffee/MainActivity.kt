package com.example.homecoffee

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column {
        Banner()
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

@Preview(showBackground = true, device = Devices.PIXEL_4, showSystemUi = true)
@Composable
fun HomeCofeeAppPreview() {
    HomeCoffeeApp()
}