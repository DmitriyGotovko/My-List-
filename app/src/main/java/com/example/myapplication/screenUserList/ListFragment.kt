package com.example.myapplication.screenUserList

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.*
import com.example.myapplication.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var binding: FragmentListBinding

    private lateinit var listViewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        listViewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayList(UserRepository.users)

//        listViewModel.users.observe(viewLifecycleOwner) {
//        }
    }

    private fun displayList(users: List<User>) {
        val newAdapter = ListRecyclerAdapter(layoutInflater, users)
        binding.recyclerView.adapter = newAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_list, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item_menu -> listViewModel.onAddRandomClicked()
            R.id.remove_all_menu -> listViewModel.onRemoveAllClicked()
            R.id.remove_last_menu -> listViewModel.onRemoveLastClicked()
            R.id.edit_second_menu -> listViewModel.onEditSecondClicked()
        }
        return super.onOptionsItemSelected(item)
    }
}