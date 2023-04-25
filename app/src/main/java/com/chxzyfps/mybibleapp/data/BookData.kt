package com.chxzyfps.mybibleapp.data

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.data.net.BookServerModel
import com.chxzyfps.mybibleapp.domain.BookDomain

sealed class BookData : Abstract.Object<BookDomain, BooksDataToDomainMapper>(){
    class Success(private val books: List<BookServerModel>) : BookData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain {
            return mapper.map(books)
        }

    }

    class Fail(private val e: Exception) : BookData() {
        override fun map(mapper: BooksDataToDomainMapper): BookDomain {
            return mapper.map(e)
        }

    }
//    class Success(private val books: List<BookServerModel>) : BookData

}