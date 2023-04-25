package com.chxzyfps.mybibleapp.data

interface BooksRepository {

    suspend fun fetchBooks(): BookData

    class Base(private val cacheDataSource: BooksCloudDataSource) : BooksRepository {
        override suspend fun fetchBooks(): BookData {
            return try {
                BookData.Success(cacheDataSource.fetchBooks())
            } catch (e: Exception) {
                BookData.Fail(e)
            }
        }
    }

}