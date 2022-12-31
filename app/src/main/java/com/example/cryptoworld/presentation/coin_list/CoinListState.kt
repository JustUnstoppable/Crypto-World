package com.example.cryptoworld.presentation.coin_list

import com.example.cryptoworld.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean=false,
    val coins: List<Coin> = emptyList(),
    val error: String=""
)
