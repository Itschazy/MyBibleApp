package com.chxzyfps.mybibleapp.core

import android.app.Application
import com.chxzyfps.mybibleapp.data.net.BooksService
import retrofit2.Retrofit

class BibleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
        val service = retrofit.create(BooksService::class.java)
    }

    private companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }
}