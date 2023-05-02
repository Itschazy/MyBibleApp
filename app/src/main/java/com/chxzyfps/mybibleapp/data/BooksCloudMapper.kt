package com.chxzyfps.mybibleapp.data

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.core.Book
import com.chxzyfps.mybibleapp.data.net.BookCloud
import com.chxzyfps.mybibleapp.data.net.BookCloudMapper

interface BooksCloudMapper : Abstract.Mapper {

    fun map(cloudList: List<BookCloud>): List<Book>

    class Base(private val bookMapper: BookCloudMapper) : BooksCloudMapper {
        override fun map(cloudList: List<BookCloud>): List<Book> {
            return cloudList.map { bookCloud ->
                bookCloud.map(bookMapper)
            }
        }
    }
}