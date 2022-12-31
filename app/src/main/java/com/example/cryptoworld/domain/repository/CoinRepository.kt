package com.example.cryptoworld.domain.repository

import com.example.cryptoworld.data.remote.dto.CoinDetailDto
import com.example.cryptoworld.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String):CoinDetailDto
}