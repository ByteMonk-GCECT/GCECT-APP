package com.gcect.gcectapp.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isGone
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.adapters.FacultyAdapter
import com.gcect.gcectapp.databinding.FragmentDepartmentCTBinding
import com.gcect.gcectapp.model.FacultyModel

class DepartmentITFragment : Fragment() {

    private lateinit var facultyMembersRecyclerView: RecyclerView
    private lateinit var departmentH1: TextView
    private lateinit var departmentH2: TextView
    private lateinit var paraFirst: TextView
    private lateinit var headFirst: TextView
    private lateinit var paraSecond: TextView
    private lateinit var headSecond: TextView
    private lateinit var paraThree: TextView
    private lateinit var facultyList: ArrayList<FacultyModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_department_c_t, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        facultyMembersRecyclerView = view.findViewById(R.id.faculty_members_rv)
        departmentH1 = view.findViewById(R.id.departmentH1)
        departmentH2 = view.findViewById(R.id.departmentH2)
        paraFirst = view.findViewById(R.id.p1)
        headFirst = view.findViewById(R.id.h1)
        paraSecond = view.findViewById(R.id.p2)
        headSecond = view.findViewById(R.id.h2)
        paraThree = view.findViewById(R.id.p3)

        departmentH1.text = "INFORMATION \n TECHNOLOGY"
        departmentH2.visibility = View.GONE
        paraFirst.visibility = View.GONE
        headFirst.text = "B.TECH"
        paraSecond.text = getString(R.string.it_p1)
        headSecond.text = "M.Tech"
        paraThree.text = getString(R.string.it_p2)

        facultyMembersRecyclerView.layoutManager =
            GridLayoutManager(requireContext(), 2)
        facultyList = ArrayList()
        facultyList = setFacultysData()
        facultyMembersRecyclerView.adapter = FacultyAdapter(
            requireContext(),
            facultyList as MutableList<FacultyModel>
        )
    }

    private fun setFacultysData() : ArrayList<FacultyModel>{
        var arrayList:ArrayList<FacultyModel> = ArrayList()

        arrayList.add(FacultyModel("Dr. Kalpana Saha(Roy)", "Asst. Professor \\n &amp; Head of the \\nDepartment", R.drawable.faculty_round_image_test))
        arrayList.add(FacultyModel("Dr. Kalpana Saha(Roy)", "Asst. Professor \\n &amp; Head of the \\nDepartment", R.drawable.faculty_round_image_test))
        arrayList.add(FacultyModel("Dr. Kalpana Saha(Roy)", "Asst. Professor \\n &amp; Head of the \\nDepartment", R.drawable.faculty_round_image_test))
        arrayList.add(FacultyModel("Dr. Kalpana Saha(Roy)", "Asst. Professor \\n &amp; Head of the \\nDepartment", R.drawable.faculty_round_image_test))

        return arrayList
    }

}