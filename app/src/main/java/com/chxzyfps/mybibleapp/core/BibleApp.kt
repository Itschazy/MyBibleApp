package com.chxzyfps.mybibleapp.core

import android.app.Application
import com.chxzyfps.mybibleapp.domain.BooksInteractor
import com.chxzyfps.mybibleapp.presentation.BaseBooksDomainToUiMapper
import com.chxzyfps.mybibleapp.presentation.BooksCommunication
import com.chxzyfps.mybibleapp.presentation.MainViewModel
import com.chxzyfps.mybibleapp.presentation.ResourceProvider

class BibleApp : Application() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()

        val booksInteractor: BooksInteractor = TODO()

        mainViewModel = MainViewModel(
            booksInteractor,
            BaseBooksDomainToUiMapper(BooksCommunication.Base(), ResourceProvider.Base(this))
        )

    }
}