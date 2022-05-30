package com.gcect.gcectapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.NavSubSubItem
import com.gcect.gcectapp.utils.Constants
import com.gcect.gcectapp.viewmodels.MainActivityViewModel
import com.gcect.gcectapp.viewmodels.PdfViewerViewModel

class NavSubSubRecyclerAdapter(
    private val navController: NavController,
    private val imgHamburger: ImageView,
    private val drawerLayout: DrawerLayout,
    private val mainViewModel: MainActivityViewModel,
    private val pdfLoaderViewModel: PdfViewerViewModel
) : RecyclerView.Adapter<NavSubSubRecyclerAdapter.NavSubSubRecyclerViewHolder>() {

    private val list = ArrayList<NavSubSubItem?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavSubSubRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.nav_sub_sub_recycler_item, parent, false)

        return NavSubSubRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NavSubSubRecyclerViewHolder, position: Int) {
        if (list[position] != null) {
            holder.navSubSubRecyclerTitle.text = list[position]!!.title
            holder.navSubSubRecyclerIcon.setImageResource(list[position]!!.icon)
            holder.llSubSub.visibility = View.VISIBLE
            holder.llSubSub.setOnClickListener {
                /**
                 * Handling the SubSubItemList item clicks
                 */
                when (list[position]!!.title) {
                    "Department of Ceramic Technology" -> {
                        setBlueHamburgerIcon()
                        navigate(R.id.departmentCTFragment)
                    }
                    "Department of Computer Science & Engg." -> {
                        setBlueHamburgerIcon()
                        navigate(R.id.departmentCSFragment)
                    }
                    "Department of Information Technology" -> {
                        setBlueHamburgerIcon()
                        navigate(R.id.departmentITFragment)
                    }
                    "2021-2022" -> {
                        setBlueHamburgerIcon()
                        mainViewModel.setExamScheduleYear(22)
                        navigate(R.id.examScheduleFragment)
                    }
                    "2020-2021" -> {
                        setBlueHamburgerIcon()
                        mainViewModel.setExamScheduleYear(21)
                        navigate(R.id.examScheduleFragment)
                    }
                    "2019-2020" -> {
                        setBlueHamburgerIcon()
                        mainViewModel.setExamScheduleYear(20)
                        navigate(R.id.examScheduleFragment)
                    }
                    "UG Batch 2016-20, 2017-21 & PG Batch  2018-20, 2019-21" -> {
                        setBlueHamburgerIcon()
                        pdfLoaderViewModel.apply {
                            setPdfUrl(Constants.csiPdfUrl)
                            setCurrentDestinationId(navController.currentDestination!!.id)
                        }
                        navigate(R.id.pdfViewerFragment)
                    }
                    "UG Batch 2015-19" -> {
                        setBlueHamburgerIcon()
                        pdfLoaderViewModel.apply {
                            setPdfUrl(Constants.csiPdfUrl)
                            setCurrentDestinationId(navController.currentDestination!!.id)
                        }
                        navigate(R.id.pdfViewerFragment)
                    }
                    "UG Batch 2014-18 & PG Batch 2016-18" -> {
                        setBlueHamburgerIcon()
                        pdfLoaderViewModel.apply {
                            setPdfUrl(Constants.csiPdfUrl)
                            setCurrentDestinationId(navController.currentDestination!!.id)
                        }
                        navigate(R.id.pdfViewerFragment)
                    }
                    "UG Batch 2012-16, 2013-17 & PG Batch 2012-14, 2013-15, 2014-16, 2015-17" -> {
                        setBlueHamburgerIcon()
                        pdfLoaderViewModel.apply {
                            setPdfUrl(Constants.csiPdfUrl)
                            setCurrentDestinationId(navController.currentDestination!!.id)
                        }
                        navigate(R.id.pdfViewerFragment)
                    }
                    "Administrative & Supporting Staffs" -> {
                        setWhiteHamburgerIcon()
                        navigate(R.id.administrationFragment)
                    }
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class NavSubSubRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val navSubSubRecyclerTitle: TextView =
            itemView.findViewById(R.id.nav_sub_sub_recycler_title)
        val navSubSubRecyclerIcon: ImageView = itemView.findViewById(R.id.nav_sub_sub_recycler_icon)
        val llSubSub: LinearLayout = itemView.findViewById(R.id.llSubSub)
    }

    fun updateList(newList: List<NavSubSubItem?>) {
        list.clear()
        list.addAll(newList)
    }

    /**
     * For handling navigation
     */
    private fun navigate(clickedId: Int) {
        val id = navController.currentDestination?.id
        navController.popBackStack(id!!, true)
        navController.navigate(clickedId)
    }

    /**
     * For setting the white hamburger icon and closing the drawer
     */
    private fun setWhiteHamburgerIcon() {
        imgHamburger.setImageResource(R.drawable.hamburger_icon_white)
        drawerLayout.closeDrawer(GravityCompat.START)
    }

    /**
     * For setting the blue hamburger icon and closing the drawer
     */
    private fun setBlueHamburgerIcon() {
        imgHamburger.setImageResource(R.drawable.hamburger_icon_blue)
        drawerLayout.closeDrawer(GravityCompat.START)
    }
}