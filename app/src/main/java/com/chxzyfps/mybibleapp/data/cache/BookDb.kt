package com.chxzyfps.mybibleapp.data.cache

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.core.Book
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class BookDb : RealmObject(), Abstract.Mapable<Book, BookCacheMapper> {
    @PrimaryKey
    var id: Int = -1
    var name: String = ""

    override fun map(mapper: BookCacheMapper): Book {
        return Book(id, name)
    }
}