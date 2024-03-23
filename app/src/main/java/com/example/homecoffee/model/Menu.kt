package com.example.homecoffee.model

import com.example.homecoffee.R

data class Menu(
    val image: Int,
    val title: String,
    val price: String
)

val dummyMenu = listOf(
    Menu(R.drawable.menu1, "Tiramisu Coffee Milk", "Rp 28.000"),
    Menu(R.drawable.menu2, "Pumpkin Spice Latte", "Rp 18.000"),
    Menu(R.drawable.menu3, "Light Capuccino", "Rp 15.000"),
    Menu(R.drawable.menu4, "Choco Creamy Latte", "Rp 20.000")
)