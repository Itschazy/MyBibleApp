package com.chxzyfps.mybibleapp.core

import android.app.Application
import com.chxzyfps.mybibleapp.data.BooksRepository
import com.chxzyfps.mybibleapp.domain.BaseBooksDataToDomainMapper
import com.chxzyfps.mybibleapp.domain.BooksInteractor

class BibleApp : Application() {

    override fun onCreate() {
        super.onCreate()

        val booksRepository: BooksRepository = TODO("merge")
        val booksInteractor = BooksInteractor.Base(booksRepository, BaseBooksDataToDomainMapper())
    }
}