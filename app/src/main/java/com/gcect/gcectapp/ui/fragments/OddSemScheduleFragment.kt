package com.gcect.gcectapp.ui.fragments

import android.Manifest
import android.app.ProgressDialog
import android.os.Bundle
import android.os.Environment
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import com.gcect.gcectapp.R
import com.gcect.gcectapp.adapters.DownloadViewAdapter
import com.gcect.gcectapp.adapters.OnDownloadBtnClickListener
import com.gcect.gcectapp.databinding.ExaminationScheduleListPageBinding
import com.gcect.gcectapp.viewmodels.*
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener

class OddSemScheduleFragment(private val navController: NavController) : Fragment(),OnDownloadBtnClickListener {
    private lateinit var binding: ExaminationScheduleListPageBinding
    private val viewModel22: SemScheduleViewModel22 by activityViewModels()
    private val viewModel21: SemScheduleViewModel21 by activityViewModels()
    private val viewModel20: SemScheduleViewModel20 by activityViewModels()
    private lateinit var sharedViewModel: MainActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        PRDownloader.initialize(requireActivity().applicationContext)
        binding = DataBindingUtil.inflate(inflater,R.layout.examination_schedule_list_page, container, false)
        sharedViewModel = ViewModelProvider(
            requireActivity(),
            MainActivityViewModelFactory()
        ).get(MainActivityViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = when(sharedViewModel.examScheduleYear){
            22 -> viewModel22.oddSemList
            21 -> viewModel21.oddSemList
            20 -> viewModel20.oddSemList
            else -> null
        }
        if(list!!.isEmpty()){
            binding.txtDataFoundIndicator.visibility = View.VISIBLE
            binding.rvExamScheduleList.visibility = View.GONE
        } else {
            binding.txtDataFoundIndicator.visibility = View.GONE
            binding.rvExamScheduleList.visibility = View.VISIBLE
            val adapter = DownloadViewAdapter(
                R.id.examScheduleFragment,
                list,
                navController,
                true,
                viewModel22,
                viewModel21,
                viewModel20,
                sharedViewModel,
                this
            )
            binding.rvExamScheduleList.layoutManager = LinearLayoutManager(requireContext())
            binding.rvExamScheduleList.adapter = adapter
        }
    }

    private fun checkDownloadPermission(url:String){
        Dexter.withContext(requireActivity())
            .withPermissions(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport) {
                    if(report.areAllPermissionsGranted()){
                        downloadPdf(url)
                    } else {
                        Toast.makeText(requireContext(),"Please allow all permission to Download",
                            Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: List<PermissionRequest?>?,
                    token: PermissionToken?
                ) { /* ... */
                }
            }).check()
    }

    private fun downloadPdf(url: String) {
        val pd = ProgressDialog(requireContext())
        pd.setMessage("DownLoading...")
        pd.setCancelable(false)
        pd.show()
        val file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        PRDownloader.download(url, file.path, URLUtil.guessFileName(url,null,null))
            .build()
            .setOnStartOrResumeListener { }
            .setOnPauseListener { }
            .setOnCancelListener { }
            .setOnProgressListener {
                val percentage = it.currentBytes*100/it.totalBytes
                pd.setMessage("DownLoad : $percentage")
            }
            .start(object : OnDownloadListener {
                override fun onDownloadComplete() {
                    pd.cancel()
                    Toast.makeText(requireContext(),"Download Complete", Toast.LENGTH_SHORT).show()
                }
                override fun onError(error: com.downloader.Error?) {
                    pd.cancel()
                }
            })
    }

    override fun onDownloadBtnPressed(url: String) {
         checkDownloadPermission(url)
    }
}