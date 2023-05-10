package com.chxzyfps.mybibleapp.presentation

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chxzyfps.mybibleapp.core.Abstract
import com.chxzyfps.mybibleapp.core.Book
import com.chxzyfps.mybibleapp.domain.BooksDomainToUiMapper
import com.chxzyfps.mybibleapp.domain.BooksInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val booksInteractor: BooksInteractor,
    private val booksDomainToUiMapper: BooksDomainToUiMapper,
    private val communication: BooksCommunication
) : ViewModel() {

    fun fetchBooks() = viewModelScope.launch(Dispatchers.IO) {

        val result = booksInteractor.fetchBooks().map(booksDomainToUiMapper)
        with(Dispatchers.Main) {
            result.map(Abstract.Mapper.Empty())
        }
    }

    fun observe(owner: LifecycleOwner, observer: Observer<List<Book>>) {
        communication.observeSuccess(owner, observer)
    }

}