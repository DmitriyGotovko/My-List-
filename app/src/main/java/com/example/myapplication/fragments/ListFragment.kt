package com.example.myapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.*
import com.example.myapplication.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list), MainView {

    private lateinit var binding: FragmentListBinding

    private var controller = MainController()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        controller.onViewReady(this)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayList(UserRepository.users)

        binding.apply {
            buttonAdd.setOnClickListener {
                controller.onAddRandomClicked() }
            buttonEditSecond.setOnClickListener {
                controller.onEditSecondClicked() }
            buttonRemoveAll.setOnClickListener {
                controller.onRemoveAllClicked() }
            buttonRemoveLast.setOnClickListener {
                controller.onRemoveLastClicked() }
        }
    }

    override fun displayList(users: List<User>) {
        val newAdapter = RecyclerAdapter(layoutInflater, users)
        binding.recyclerView.adapter = newAdapter
    }
}