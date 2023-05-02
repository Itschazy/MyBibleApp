package com.chxzyfps.mybibleapp.data.cache

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.core.Book

interface BookCacheMapper : Abstract.Mapper {

    fun map(bookDb: BookDb): Book

    class Base : BookCacheMapper {
        override fun map(bookDb: BookDb): Book {
            return Book(bookDb.id, bookDb.name)
        }
    }

}