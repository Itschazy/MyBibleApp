package com.chxzyfps.mybibleapp.core

import android.app.Application
import com.chxzyfps.mybibleapp.data.BooksCloudDataSource
import com.chxzyfps.mybibleapp.data.BooksCloudMapper
import com.chxzyfps.mybibleapp.data.BooksRepository
import com.chxzyfps.mybibleapp.data.cache.BookCacheMapper
import com.chxzyfps.mybibleapp.data.cache.BooksCacheDataSource
import com.chxzyfps.mybibleapp.data.cache.BooksCacheMapper
import com.chxzyfps.mybibleapp.data.cache.RealmProvider
import com.chxzyfps.mybibleapp.data.net.BookCloudMapper
import com.chxzyfps.mybibleapp.data.net.BooksService
import retrofit2.Retrofit

class BibleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
        val service = retrofit.create(BooksService::class.java)

        val cloudDataSource = BooksCloudDataSource.Base(service)
        val cacheDataSource = BooksCacheDataSource.Base(RealmProvider.Base())
        val booksCloudMapper = BooksCloudMapper.Base(BookCloudMapper.Base())
        val booksCacheMapper = BooksCacheMapper.Base(BookCacheMapper.Base())

        val booksRepository = BooksRepository.Base(
            cloudDataSource,
            cacheDataSource,
            booksCloudMapper,
            booksCacheMapper
        )
    }

    private companion object {
        const val BASE_URL = "https://bible-go-api.rkeplin.com/v1/"
    }
}