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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.model.NavBaseItem
import com.gcect.gcectapp.viewmodels.MainActivityViewModel
import com.gcect.gcectapp.viewmodels.PdfViewerViewModel

class NavBaseRecyclerAdapter(
    private val context: Context,
    private val navController: NavController,
    private val imgHamburger: ImageView,
    private val drawerLayout: DrawerLayout,
    private val mainViewModel: MainActivityViewModel,
    private val pdfLoaderViewModel: PdfViewerViewModel
) :
    RecyclerView.Adapter<NavBaseRecyclerAdapter.NavBaseRecyclerViewHolder>() {

    private val list = ArrayList<NavBaseItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NavBaseRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.nav_base_recycler_item, parent, false)

        return NavBaseRecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: NavBaseRecyclerViewHolder, position: Int) {
        var isClicked = true
        holder.navBaseRecyclerTitle.text = list[position].title
        holder.navBaseRecyclerIcon.setImageResource(list[position].icon)
        recyclerViewSetup(holder.navSubRecyclerView, position)
        holder.llBaseRecycler.setOnClickListener {
            if (isClicked) {
                holder.navSubRecyclerView.visibility = View.VISIBLE
                isClicked = false
            } else {
                holder.navSubRecyclerView.visibility = View.GONE
                isClicked = true
            }

            /**
             * Handling the nav drawer item clicks when there has no subItemList
             */
            if (list[position].navSubItemList[0] == null) {
                when (list[position].title) {
                    "Home" -> {
                        setWhiteHamburgerIcon()
                        navigate(R.id.homeFragment)
                    }
                    "Contact Us" -> {
                        setBlueHamburgerIcon()
                        navigate(R.id.contactUsFragment)
                    }
                    "Take Note" -> {
                        setWhiteHamburgerIcon()
                        navigate(R.id.noteShowFragment)
                    }
                }
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class NavBaseRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val navBaseRecyclerTitle: TextView = itemView.findViewById(R.id.nav_base_recycler_title)
        val navBaseRecyclerIcon: ImageView = itemView.findViewById(R.id.nav_base_recycler_icon)
        val navSubRecyclerView: RecyclerView =
            itemView.findViewById<RecyclerView>(R.id.nav_sub_recycler_view)
        val llBaseRecycler = itemView.findViewById<LinearLayout>(R.id.llBaseRecycler)
    }

    private fun recyclerViewSetup(recyclerView: RecyclerView, pos: Int) {
        // Setting the layout manager
        recyclerView.layoutManager = LinearLayoutManager(context)
        // Setting the Adapter with the recyclerview
        val adapter: NavSubRecyclerAdapter =
            NavSubRecyclerAdapter(context, navController, imgHamburger, drawerLayout,mainViewModel,pdfLoaderViewModel)
        recyclerView.adapter = adapter
        adapter.updateList(list[pos].navSubItemList)
    }

    fun updateList(newList: List<NavBaseItem>) {
        list.clear()
        list.addAll(newList)
    }

    /**
     * For handling navigation
     */
    private fun navigate(clickedId: Int) {
        val id = navController.currentDestination?.id
        id?.let { navController.popBackStack(it, true) }
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
