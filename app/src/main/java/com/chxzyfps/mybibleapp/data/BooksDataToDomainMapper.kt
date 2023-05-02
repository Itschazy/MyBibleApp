package com.chxzyfps.mybibleapp.data

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.core.Book
import com.chxzyfps.mybibleapp.domain.BookDomain

interface BooksDataToDomainMapper : Abstract.Mapper {

    fun map(books: List<Book>): BookDomain

    fun map(e: Exception): BookDomain

}