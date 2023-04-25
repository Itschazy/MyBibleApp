package com.chxzyfps.mybibleapp.data

import com.chxzyfps.mybibleapp.data.net.BookServerModel
import com.chxzyfps.mybibleapp.data.net.BooksService

interface BooksCloudDataSource {

    suspend fun fetchBooks(): List<BookServerModel>

    class Base(private val service: BooksService) : BooksCloudDataSource {
        override suspend fun fetchBooks(): List<BookServerModel> {
            return service.fetchBooks()
        }

    }

}