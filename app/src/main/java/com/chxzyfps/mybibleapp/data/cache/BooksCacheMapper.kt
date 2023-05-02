package com.chxzyfps.mybibleapp.data.cache

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.core.Book

interface BooksCacheMapper : Abstract.Mapper {

    fun map(books: List<BookDb>): List<Book>

    class Base(private val mapper: BookCacheMapper) : BooksCacheMapper {
        override fun map(books: List<BookDb>): List<Book> {
            return books.map { bookDb ->
                bookDb.map(mapper)
            }
        }
    }
}