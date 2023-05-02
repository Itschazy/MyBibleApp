package com.chxzyfps.mybibleapp.data

import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.domain.BookDomain

sealed class BooksData : Abstract.Object<BookDomain, BooksDataToDomainMapper>(){

}