package com.chxzyfps.mybibleapp.data

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.core.Book
import com.chxzyfps.mybibleapp.domain.BookDomain

sealed class BooksData : Abstract.Object<BookDomain, BooksDataToDomainMapper>() {
    class Success(private val books: List<Book>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain {
            return mapper.map(books)
        }

    }

    class Fail(private val e: Exception) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain {
            return mapper.map(e)
        }

    }
//    class Success(private val books: List<BookServerModel>) : BookData

}