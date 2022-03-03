package com.gcect.gcectapp.viewmodels

import androidx.lifecycle.ViewModel

class PdfViewerViewModel : ViewModel() {
    private lateinit var _pdfUrl: String
    val pdfUrl
        get() = _pdfUrl

    private var _currentDestinationId = -1
    val currentDestinationId
        get() = _currentDestinationId

    fun setPdfUrl(url: String) {
        _pdfUrl = url
    }

    fun setCurrentDestinationId(id:Int){
        _currentDestinationId = id
    }
}