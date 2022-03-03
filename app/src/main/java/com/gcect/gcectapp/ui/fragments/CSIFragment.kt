package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.gcect.gcectapp.R
import com.gcect.gcectapp.databinding.PdfViewerWithoutDownloadBinding
import com.gcect.gcectapp.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection

class CSIFragment : Fragment() {
    private lateinit var binding: PdfViewerWithoutDownloadBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.pdf_viewer_without_download, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtPageTitle.text = "CSI Student Chapter"
        binding.pdfLoadingProgress.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.Main).launch {
            retrivePDFFromUrl(Constants.csiPdfUrl)
        }
    }

    /**
     * downloading pdf file from the link and passing the inputstream
     * to the showPdfFromStream()
     */
    private suspend fun retrivePDFFromUrl(url: String) {
        val result = withContext(Dispatchers.IO) {
            // we are using inputstream
            // for getting out PDF.
            var inputStream: InputStream? = null
            try {
                val url = URL(url)
                // below is the step where we are
                // creating our connection.
                val urlConnection: HttpURLConnection = url.openConnection() as HttpsURLConnection
                if (urlConnection.responseCode == 200) {
                    // response is success.
                    // we are getting input stream from url
                    // and storing it in our variable.
                    inputStream = BufferedInputStream(urlConnection.inputStream)
                }
            } catch (e: IOException) {
                // this is the method
                // to handle errors.
                e.printStackTrace()
            }
            inputStream
        }

        showPdfFromStream(result)
        binding.pdfLoadingProgress.visibility = View.GONE
    }

    /**
     * Showing the pdf to the pdf viewer
     */
    private fun showPdfFromStream(inputStream: InputStream?) {
        binding.pdfView.fromStream(inputStream)
            .password(null)
            .defaultPage(0)
            .enableSwipe(true)
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .onPageError { page, _ ->
                Toast.makeText(
                    context,
                    "Error at page: $page", Toast.LENGTH_LONG
                ).show()
            }
            .load()
    }
}