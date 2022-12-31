package com.example.cryptoworld.presentation.coin_detail

import com.example.cryptoworld.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean=false,
    val coin:CoinDetail? = null,
    val error:String=""
)
