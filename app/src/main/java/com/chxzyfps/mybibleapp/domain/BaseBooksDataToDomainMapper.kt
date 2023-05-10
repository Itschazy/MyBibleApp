package com.chxzyfps.mybibleapp.domain

import com.chxzyfps.mybibleapp.core.Book
import com.chxzyfps.mybibleapp.data.BooksDataToDomainMapper

class BaseBooksDataToDomainMapper : BooksDataToDomainMapper {
    override fun map(books: List<Book>): BookDomain {
        return BookDomain.Success(books)
    }

    override fun map(e: Exception): BookDomain {
        return BookDomain.Fail(e)
    }
}