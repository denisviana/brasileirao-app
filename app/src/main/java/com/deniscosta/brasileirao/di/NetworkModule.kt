package com.deniscosta.brasileirao.di

import android.os.Build.HOST
import com.deniscosta.brasileirao.data.api.RestApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Denis Costa on 08/08/20.
 * denisvcosta@gmail.com
 */


val networkModule = module {
    single { createOkHttpClient() }
    single { provideRetrofit(get(), "https://us-central1-brasileirao-api.cloudfunctions.net/", get()) }
    single { provideRestApiService(get()) }
    factory { provideMoshi() }
    factory { provideMoshiConverterFactory(get()) }
}


fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    return OkHttpClient.Builder()
        .connectTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}
fun provideRestApiService(retrofit: Retrofit): RestApi {
    return retrofit.create<RestApi>(RestApi::class.java)
}

fun provideRetrofit(okHttpClient: OkHttpClient, url: String, convertFactory: Converter.Factory) : Retrofit{
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(convertFactory)
        .build()
}

fun provideMoshi(): Moshi {
    return Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
}

fun provideMoshiConverterFactory(moshi: Moshi): Converter.Factory {
    return MoshiConverterFactory.create(moshi)
        .withNullSerialization()
}