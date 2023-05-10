package com.chxzyfps.mybibleapp.domain

import com.chxzyfps.mybibleapp.data.BooksDataToDomainMapper
import com.chxzyfps.mybibleapp.data.BooksRepository
import com.chxzyfps.mybibleapp.presentation.BooksUi

interface BooksInteractor {

    suspend fun fetchBooks(): BookDomain

    class Base(private val booksRepository: BooksRepository, private val mapper: BooksDataToDomainMapper) : BooksInteractor {
        override suspend fun fetchBooks(): BookDomain {
            return booksRepository.fetchBooks().map(mapper)
        }
    }
}