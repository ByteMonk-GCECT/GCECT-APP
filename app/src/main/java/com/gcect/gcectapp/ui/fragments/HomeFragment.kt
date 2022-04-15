package com.gcect.gcectapp.ui.fragments

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.app.NotificationCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.downloader.OnDownloadListener
import com.downloader.PRDownloader
import com.gcect.gcectapp.R
import com.gcect.gcectapp.adapters.*
import com.gcect.gcectapp.databinding.FragmentHomeBinding
import com.gcect.gcectapp.ui.activity.MainActivity
import com.gcect.gcectapp.viewmodels.HomeFragmentViewModel
import com.gcect.gcectapp.viewmodels.PdfViewerViewModel
import com.gcect.gcectapp.viewmodels.PdfViewerViewModelFactory
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.button.MaterialButton
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations


class HomeFragment : Fragment(), OnHomeNoticeItemClickListener, OnBottomSheetItemClickListener, OnHomeRedNoticeItemClickListener{
    private lateinit var binding: FragmentHomeBinding
    private lateinit var pdfLoaderViewModel: PdfViewerViewModel
    //#1 Defining a BottomSheetBehavior instance
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    /**
     * 1 -> for upper blue notice
     * 2 -> for red notice
     * 3 -> for bottom sheet notice
     */
    private var noticeType = 0
    private val viewModel: HomeFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        PRDownloader.initialize(requireActivity().applicationContext)
        pdfLoaderViewModel = ViewModelProvider(
            requireActivity(),
            PdfViewerViewModelFactory()
        ).get(PdfViewerViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.homeFragment = this
        //#2 Initializing the BottomSheetBehavior
        val bottomSheetLayout = binding.layoutBottomSheet
        val bottomSheetView: View =
            LayoutInflater.from(context)
                .inflate(
                    R.layout.home_page_bottom_sheet,
                    null
                )
        bottomSheetBehavior =
            BottomSheetBehavior.from(bottomSheetLayout as LinearLayout)

        /**
         *  for auto image sliding
         */
        val sliderView = binding.imageSlider
        val sliderAdapter = HomeAutoSliderAdapter(requireActivity(), viewModel.autoSliderImgList)
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM)
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
        sliderView.startAutoCycle()

        /**
         * for notice list showing
         */
        val noticeAdapter = HomeNoticeRecyclerAdapter(viewModel.noticeItemList, this)
        binding.rvNotice.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvNotice.adapter = noticeAdapter

        /**
         * for gate ranker list showing
         */
        val gateRankerAdapter =
            HomeGateRankerRecyclerAdapter(requireContext(), viewModel.gateRankerList)
        binding.rvGateRanker.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvGateRanker.adapter = gateRankerAdapter

        /**
         * for general notice list showing
         */
        val generalNoticeAdapter =
            HomeBottomSheetRecyclerAdapter(viewModel.bottomSheetItemList, this)
        val rvGeneralNotice =
            binding.layoutBottomSheet.rootView.findViewById<RecyclerView>(R.id.rvGeneralNotice)
        rvGeneralNotice.layoutManager = LinearLayoutManager(requireContext())
        rvGeneralNotice.adapter = generalNoticeAdapter

        /**
         * for red notice list showing
         */

        val redNoticeAdapter =
            RedColouredHomeNoticeRecyclerAdapter(viewModel.redNoticeItemList, this)
        binding.rvRedNotice.layoutManager =
            GridLayoutManager(requireContext(), 2)
        binding.rvRedNotice.adapter = redNoticeAdapter

    }

    fun onGeneralNoticeClicked() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
    }

    private fun showDialog(pos:Int, title:String){
        val customLayout = layoutInflater
            .inflate(
                R.layout.pdf_download_view_option_layout, null
            )
        val txtDialogTitle = customLayout.findViewById<TextView>(R.id.txtDialogTitle)
        txtDialogTitle.text = title
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(customLayout)
        val dialog = builder.create()
        dialog.setCancelable(true)
        dialog.show()

        customLayout.findViewById<MaterialButton>(R.id.btnDownload).setOnClickListener {
            onDownloadClick(pos,dialog)
            dialog.cancel()
        }
        customLayout.findViewById<MaterialButton>(R.id.btnView).setOnClickListener {
            onViewClick(pos)
            dialog.cancel()
        }
    }

    private fun onViewClick(pos: Int) {
        pdfLoaderViewModel.setCurrentDestinationId(R.id.homeFragment)

        when(noticeType) {
           1 -> pdfLoaderViewModel.setPdfUrl(viewModel.noticeItemList[pos].pdfUrl)
           2 -> pdfLoaderViewModel.setPdfUrl(viewModel.redNoticeItemList[pos].pdfUrl)
           3 -> pdfLoaderViewModel.setPdfUrl(viewModel.bottomSheetItemList[pos].pdfUrl)
        }

        findNavController().navigate(R.id.pdfViewerFragment)
    }

    private fun onDownloadClick(pos:Int,dialog: AlertDialog) {
        dialog.cancel()
        when(noticeType) {
            1 -> checkDownloadPermission(viewModel.noticeItemList[pos].pdfUrl)
            2 -> checkDownloadPermission(viewModel.redNoticeItemList[pos].pdfUrl)
            3 -> checkDownloadPermission(viewModel.bottomSheetItemList[pos].pdfUrl)
        }
    }

    override fun onNoticeBtnClick(pos:Int,title:String) {
        noticeType = 1
        showDialog(pos,title)
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
                        Toast.makeText(requireContext(),getString(R.string.allow_download_permission_message),
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
        pd.setMessage(getString(R.string.downloading))
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
                pd.setMessage(getString(R.string.download_percentage_completed,percentage))
                showNotification(percentage)
            }
            .start(object : OnDownloadListener {
                override fun onDownloadComplete() {
                    pd.cancel()
                    Toast.makeText(requireContext(),getString(R.string.download_complete), Toast.LENGTH_SHORT).show()
                }
                override fun onError(error: com.downloader.Error?) {
                    pd.cancel()
                }
            })

    }

    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = getString(R.string.notification_channel_id)
            val mChannel = NotificationChannel(
                channelId,
                getString(R.string.notification_channel_name),
                NotificationManager.IMPORTANCE_DEFAULT
            )
            mChannel.description = getString(R.string.notification_channel_desc)

            val notificationManager =
                requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }
    }

    fun showNotification(progress: Long){
        createNotificationChannel()
        val channelId = getString(R.string.notification_channel_id)
        val intent = Intent(context, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this.context, 0, intent, 0);
        val builder = NotificationCompat.Builder(
            requireContext(),
            channelId
        ) // Create notification with channel Id
            .setSmallIcon(R.drawable.about_us_icon)
            .setContentTitle(getString(R.string.NotificationTitle))
            .setContentText(getString(R.string.NotificationContent))
            .setPriority(NotificationCompat.PRIORITY_MAX)
        builder.setContentIntent(pendingIntent).setAutoCancel(true)

        val mNotificationManager = requireContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(progress.toInt()!=100) {
            builder.setProgress(100, progress.toInt(), false)
            mNotificationManager.notify(123, builder.build())
        } else {
            builder.setProgress(0, 0, false)
            builder.setContentText("Download Complete")
            mNotificationManager.notify(123, builder.build())
        }

    }

    override fun onBottomSheetItemClick(pos: Int, title:String) {
        noticeType = 3
        showDialog(pos,title)
    }

    override fun onRedNoticeBtnClick(pos: Int, title:String) {
        noticeType = 2
        Log.d("redBtnPos",pos.toString())
        if(title == "FOURTH GRADUATE DAY – NOVEMBER 07, 2021 FULL VIDEO"){
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(viewModel.graduateDayVideoUrl)
            startActivity(i)
        }
        else {
            showDialog(pos,title)
        }
    }
}
