package com.chxzyfps.mybibleapp.data

import com.chxzyfps.mybibleapp.data.net.BookCloud
import com.chxzyfps.mybibleapp.data.net.BooksService

interface BooksCloudDataSource {

    suspend fun fetchBooks(): List<BookCloud>

    class Base(private val service: BooksService) : BooksCloudDataSource {
        override suspend fun fetchBooks(): List<BookCloud> {
            return service.fetchBooks()
        }

    }

}