package com.example.cryptoworld.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptoworld.presentation.coin_detail.CoinDetailScreen
import com.example.cryptoworld.presentation.coin_list.CoinListScreen
import com.example.cryptoworld.presentation.theme.CryptoWorldTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoWorldTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   val navController= rememberNavController()
                    NavHost(
                        navController =navController ,
                        startDestination = Screen.CoinListScreen.route
                    ){
                        composable(
                            route = Screen.CoinListScreen.route
                        ){
                             CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinDetailScreen.route +"/{coinId}"
                        ){
                            CoinDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

