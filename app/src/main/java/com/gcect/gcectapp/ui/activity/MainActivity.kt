package com.gcect.gcectapp.ui.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.downloader.PRDownloader
import com.gcect.gcectapp.R
import com.gcect.gcectapp.adapters.NavBaseRecyclerAdapter
import com.gcect.gcectapp.databinding.ActivityMainBinding
import com.gcect.gcectapp.adapters.HomeAutoSliderAdapter
import com.gcect.gcectapp.viewmodels.*
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView


class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var pdfLoaderViewModel: PdfViewerViewModel
    private lateinit var binding: ActivityMainBinding
    val noteViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(NoteViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        PRDownloader.initialize(applicationContext)
        viewModel = ViewModelProvider(
            this,
            MainActivityViewModelFactory()
        ).get(MainActivityViewModel::class.java)

        pdfLoaderViewModel = ViewModelProvider(
            this,
            PdfViewerViewModelFactory()
        ).get(PdfViewerViewModel::class.java)

        // finding the navController
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.nav_base_recycler_view)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        // This will pass the ArrayList to our Adapter
        val adapter =
            NavBaseRecyclerAdapter(this, navController, binding.imgHamburger, binding.drawerLayout,viewModel,pdfLoaderViewModel)
        adapter.updateList(viewModel.mainList)
        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
        binding.imgHamburger.setOnClickListener(this)
        binding.imgClose.setOnClickListener(this)



    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.imgHamburger -> {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
            R.id.imgClose -> {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            }
        }
    }

}