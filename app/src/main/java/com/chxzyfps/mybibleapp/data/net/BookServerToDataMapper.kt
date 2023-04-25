package com.chxzyfps.mybibleapp.data.net

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.data.BookData

interface BookServerToDataMapper : Abstract.Mapper {

    fun map(id: Int, name: String) : BookData

}