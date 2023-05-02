package com.chxzyfps.mybibleapp.data.net

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.core.Book
import com.google.gson.annotations.SerializedName

data class BookCloud(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String
) : Abstract.Object<Book, BookCloudMapper>() {
    override fun map(mapper: BookCloudMapper): Book {
        return mapper.map(id, name)
    }

}


/* {"id":1,"name":"Genesis","testament":"OT","genre":{"id":1,"name":"Law"}} */