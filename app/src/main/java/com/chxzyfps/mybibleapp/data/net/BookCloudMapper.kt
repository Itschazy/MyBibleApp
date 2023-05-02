package com.chxzyfps.mybibleapp.data.net

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.core.Book
import com.chxzyfps.mybibleapp.data.BooksCloudMapper

interface BookCloudMapper : Abstract.Mapper {

    fun map(id: Int, name: String): Book

    class Base : BookCloudMapper {
        override fun map(id: Int, name: String): Book {
            return Book(id, name)
        }

    }

}