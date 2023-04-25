package com.chxzyfps.mybibleapp.data

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.data.net.BookServerModel
import com.chxzyfps.mybibleapp.data.net.BooksService
import com.chxzyfps.mybibleapp.domain.BookDomain
import retrofit2.HttpException
import java.net.UnknownHostException

interface BooksDataToDomainMapper : Abstract.Mapper {

    fun map(books: List<BookServerModel>): BookDomain

    fun map(e: Exception): BookDomain

    class Base : BooksDataToDomainMapper {
        override fun map(books: List<BookServerModel>): BookDomain {
            return BookDomain.Success()
        }

        override fun map(e: Exception): BookDomain {
            val errorType = when(e) {
                is UnknownHostException -> 0
                is HttpException -> 1
                else -> 2
            }
            return BookDomain.Fail(errorType)
        }

    }

}