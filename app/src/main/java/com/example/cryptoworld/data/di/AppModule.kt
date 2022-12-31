package com.example.cryptoworld.data.di

import androidx.compose.ui.unit.Constraints
import com.example.cryptoworld.common.Constants
import com.example.cryptoworld.data.remote.CoinPapricaApi
import com.example.cryptoworld.data.repository.CoinRepositoryImpl
import com.example.cryptoworld.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
//SingletonComponent is used to make all dependencies in module live long as application
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    //Singleton is used for single instance throughout lifetime of app
    fun providePaprikaApi(): CoinPapricaApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPapricaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPapricaApi) :CoinRepository{
        return CoinRepositoryImpl(api)
    }
}