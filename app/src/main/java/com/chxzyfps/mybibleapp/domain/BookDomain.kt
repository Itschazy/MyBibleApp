package com.chxzyfps.mybibleapp.domain

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.data.net.BookServerModel
import com.chxzyfps.mybibleapp.domain.presentation.BookUi

sealed class BookDomain : Abstract.Object<BookUi, Abstract.Mapper.Empty>(){

    class Success() : BookDomain() {
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }
    }

    class Fail(errorType: Int) : BookDomain() {
        override fun map(mapper: Abstract.Mapper.Empty): BookUi {
            TODO("Not yet implemented")
        }

    }

}
