package eu.deysouvik.test

import ViewModel.CollaborationViewmodel
import ViewModel.PatentViewmodel
import adapters.CollaborationRecyclerAdapter
import adapters.PatentRecyclerAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gcect.gcectapp.R
import com.gcect.gcectapp.databinding.FragmentCollaborationBinding


class Collaboration_Fragment : Fragment() {

    lateinit var binding:FragmentCollaborationBinding
    private val collaborationViewmodel: CollaborationViewmodel by viewModels()
    private val patentViewmodel: PatentViewmodel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_collaboration_, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CollaborationrecyclerViewSetup(binding.rvCollaboration)
        PatentrecyclerViewSetup(binding.rvPatents)
    }


    private fun CollaborationrecyclerViewSetup(recyclerView: RecyclerView){
        // Setting the layout manager
        recyclerView.layoutManager = LinearLayoutManager(context)
        // This will pass the ArrayList to our Adapter
        val adapter = CollaborationRecyclerAdapter(requireContext(),collaborationViewmodel.listOfCollaborationDetail)
        recyclerView.adapter = adapter
    }

    private fun PatentrecyclerViewSetup(recyclerView: RecyclerView){
        // Setting the layout manager
        recyclerView.layoutManager = LinearLayoutManager(context)
        // This will pass the ArrayList to our Adapter
        val adapter = PatentRecyclerAdapter(requireContext(),patentViewmodel.listOfPatentDetail)
        recyclerView.adapter = adapter
    }

}