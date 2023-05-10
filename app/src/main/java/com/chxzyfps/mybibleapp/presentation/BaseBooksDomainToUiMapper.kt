package com.chxzyfps.mybibleapp.presentation

import com.chxzyfps.mybibleapp.core.Book
import com.chxzyfps.mybibleapp.domain.BooksDomainToUiMapper
import com.chxzyfps.mybibleapp.domain.ErrorType

class BaseBooksDomainToUiMapper(
    private val communication: BooksCommunication,
    private val resourceProvider: ResourceProvider
) :
    BooksDomainToUiMapper {
    override fun map(books: List<Book>): BooksUi {
        return BooksUi.Success(communication, books)
    }

    override fun map(errorType: ErrorType): BooksUi {
        return BooksUi.Fail(communication, errorType, resourceProvider)
    }
}