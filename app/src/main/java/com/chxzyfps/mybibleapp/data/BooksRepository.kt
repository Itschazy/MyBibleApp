package com.chxzyfps.mybibleapp.data

import com.chxzyfps.mybibleapp.data.cache.BooksCacheDataSource
import com.chxzyfps.mybibleapp.data.cache.BooksCacheMapper

interface BooksRepository {

    suspend fun fetchBooks(): BooksData

    class Base(
        private val cloudDataSource: BooksCloudDataSource,
        private val cacheDataSource: BooksCacheDataSource,
        private val booksCloudMapper: BooksCloudMapper,
        private val booksCacheMapper: BooksCacheMapper
    ) : BooksRepository {
        override suspend fun fetchBooks(): BooksData {

            return try {
                val booksCacheList = cacheDataSource.fetchBooks()
                if (booksCacheList.isEmpty()) {
                    val booksCloudList = cloudDataSource.fetchBooks()
                    val books = booksCloudMapper.map(booksCloudList)
                    BooksData.Success(booksCloudMapper.map(booksCloudList))
                    BooksData.Success(books)
                } else {
                    BooksData.Success(booksCacheMapper.map(booksCacheList))
                }
            } catch (e: Exception) {
                BooksData.Fail(e)
            }
        }
    }

}