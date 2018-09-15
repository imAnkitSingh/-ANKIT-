package com.internshala.demoapp.ApiClient

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.Executors

//import sun.util.logging.LoggingSupport.setLevel


class ApiClient {
   // var retrofit: Retrofit? = null

    object Staticated {

        fun getClient(): Retrofit {

            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()


          var   retrofit = Retrofit.Builder()
                    .baseUrl("https://achyutasamanta.com")
                   // .callbackExecutor(Executors.newSingleThreadExecutor())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build()



            return (retrofit as Retrofit)
        }

    }


}