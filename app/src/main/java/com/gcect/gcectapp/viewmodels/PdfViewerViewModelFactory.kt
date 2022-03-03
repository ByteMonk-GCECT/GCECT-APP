package com.gcect.gcectapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PdfViewerViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(PdfViewerViewModel::class.java)) {
            PdfViewerViewModel() as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}