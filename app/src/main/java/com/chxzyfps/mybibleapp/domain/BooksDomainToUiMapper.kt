package com.chxzyfps.mybibleapp.domain

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.core.Book
import com.chxzyfps.mybibleapp.presentation.BooksUi

interface BooksDomainToUiMapper : Abstract.Mapper {
    fun map(books: List<Book>) : BooksUi

    fun map(errorType: ErrorType) : BooksUi
}