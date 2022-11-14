package com.sidrakotlin.internetdata.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET



private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com"

//initialize moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//retrofit

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//interface for getphotos method
interface ApiService{
   @GET("photos")
    suspend fun getPhotos():List<Photos>
}

//singleton object
object PhotosApi{
    val retrofitService : ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}