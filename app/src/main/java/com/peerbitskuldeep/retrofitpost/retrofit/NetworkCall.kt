package com.peerbitskuldeep.retrofitpost.retrofit

import com.peerbitskuldeep.retrofitpost.constants.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkCall {

    companion object
    {

        private val interceptor = HttpLoggingInterceptor()

        private val client = OkHttpClient.Builder()
            .connectTimeout(50,TimeUnit.SECONDS)
            .readTimeout(50, TimeUnit.SECONDS)
            .writeTimeout(50,TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

        val instance: ApiInterface
        get() {

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiInterface::class.java)

        }

    }

}