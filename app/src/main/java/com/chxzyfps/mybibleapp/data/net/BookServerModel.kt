package com.chxzyfps.mybibleapp.data.net

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.data.BookData
import com.google.gson.annotations.SerializedName

data class BookServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String
) : Abstract.Object<BookData, BookServerToDataMapper>() {
    override fun map(mapper: BookServerToDataMapper): BookData {
        return mapper.map(id, name)
    }

}


/* {"id":1,"name":"Genesis","testament":"OT","genre":{"id":1,"name":"Law"}} */