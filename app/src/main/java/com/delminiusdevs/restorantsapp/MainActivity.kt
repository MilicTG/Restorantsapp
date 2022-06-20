package com.delminiusdevs.restorantsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.delminiusdevs.restorantsapp.ui.theme.RestorantsAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestorantsAppTheme {
               RestaurantsScreen()
            }
        }
    }
}


