package com.gcect.gcectapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.R.id.visionMissionViewFragment
import com.gcect.gcectapp.model.NavSubItem
import com.gcect.gcectapp.viewmodels.MainActivityViewModel
import com.gcect.gcectapp.viewmodels.PdfViewerViewModel

class NavSubRecyclerAdapter(
    private val context: Context,
    private val navController: NavController,
    private val imgHamburger: ImageView,
    private val drawerLayout: DrawerLayout,
    private val mainViewModel: MainActivityViewModel,
    private val pdfLoaderViewModel: PdfViewerViewModel
) : RecyclerView.Adapter<NavSubRecyclerAdapter.NavSubRecyclerViewHolder>() {
    private val list = ArrayList<NavSubItem?>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavSubRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.nav_sub_recycler_item, parent, false)

        return NavSubRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NavSubRecyclerViewHolder, position: Int) {
        var isClicked = true
        if (list[position] != null) {
            holder.navSubRecyclerTitle.text = list[position]!!.title
            holder.navSubRecyclerIcon.setImageResource(list[position]!!.icon)
            recyclerViewSetup(holder.navSubSubRecyclerView, position)
            holder.llSubRecycler.setOnClickListener {
                if (isClicked) {
                    holder.navSubSubRecyclerView.visibility = View.VISIBLE
                    if (list[position]?.navSubSubItemList!!.size > 1)
                        holder.navSubRecyclerIcon.setImageResource(R.drawable.open_hand_icon)
                    isClicked = false
                } else {
                    holder.navSubSubRecyclerView.visibility = View.GONE
                    if (list[position]?.navSubSubItemList!!.size > 1)
                        holder.navSubRecyclerIcon.setImageResource(R.drawable.close_hand_icon)
                    isClicked = true
                }
                /**
                 * Handling the nav drawer item clicks when there has no SubSubItemList
                 */
                if (list[position]!!.navSubSubItemList[0] == null) {
                    when (list[position]!!.title) {
                        "Vision & Mission" -> {
                            setWhiteHamburgerIcon()
                            navigate(visionMissionViewFragment)
                        }
                        "The Institute" -> {
                            setWhiteHamburgerIcon()
                            navigate(R.id.theInstituteViewFragment)
                        }
                        "History" -> {
                            setWhiteHamburgerIcon()
                            navigate(R.id.historyViewFragment)
                        }
                        "Research & Development" -> {
                            setBlueHamburgerIcon()
                            navigate(R.id.researchDevelopmentFragment)
                        }
                        "Scientific Voyage" -> {
                            setBlueHamburgerIcon()
                            navigate(R.id.scientificVoyageFragment)
                        }
                        "Workshop Seminar" -> {
                            setBlueHamburgerIcon()
                            navigate(R.id.workshopSeminarFragment)
                        }
                        "CSI Student Chapter" -> {
                            setBlueHamburgerIcon()
                            navigate(R.id.CSIFragment)
                        }
                        "Students' Welfare Associations" -> {
                            setBlueHamburgerIcon()
                            navigate(R.id.welfareFragment)
                        }
                        "NSS" -> {
                            setWhiteHamburgerIcon()
                            navigate(R.id.NSSFragment)
                        }
                        "Placement Cell" -> {
                            setBlueHamburgerIcon()
                            navigate(R.id.placementCellFragment)
                        }
                        "Placement Overview" -> {
                            setBlueHamburgerIcon()
                            navigate(R.id.placementOverViewFragment)
                        }

                        "Consultancy" -> {
                            setBlueHamburgerIcon()
                            navigate(R.id.consultancy_Fragment)
                        }

                        "Collaboration" -> {
                            setBlueHamburgerIcon()
                            navigate(R.id.collaboration_Fragment)
                        }
                    }
                }

            }
        } else {
            holder.llSubRecycler.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class NavSubRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val navSubRecyclerTitle: TextView = itemView.findViewById(R.id.nav_sub_recycler_title)
        val navSubRecyclerIcon: ImageView = itemView.findViewById(R.id.nav_sub_recycler_icon)
        val navSubSubRecyclerView =
            itemView.findViewById<RecyclerView>(R.id.nav_sub_sub_recycler_view)
        val llSubRecycler = itemView.findViewById<LinearLayout>(R.id.llSubRecycler)

    }

    fun recyclerViewSetup(recyclerView: RecyclerView, position: Int) {
        // Setting the layout manager
        recyclerView.layoutManager = LinearLayoutManager(context)
        // This will pass the ArrayList to our Adapter
        val adapter = NavSubSubRecyclerAdapter(
            navController,
            imgHamburger,
            drawerLayout,
            mainViewModel,
            pdfLoaderViewModel
        )
        // Setting the Adapter with the recyclerview
        adapter.updateList(list[position]!!.navSubSubItemList)
        recyclerView.adapter = adapter
    }

    fun updateList(newList: List<NavSubItem?>) {
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