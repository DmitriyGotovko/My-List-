package com.example.myapplication.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
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

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayList(UserRepository.users)
    }

    override fun displayList(users: List<User>) {
        val newAdapter = RecyclerAdapter(layoutInflater, users)
        binding.recyclerView.adapter = newAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_list, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_item_menu -> controller.onAddRandomClicked()
            R.id.remove_all_menu -> controller.onRemoveAllClicked()
            R.id.remove_last_menu -> controller.onRemoveLastClicked()
            R.id.edit_second_menu -> controller.onEditSecondClicked()
        }
        return super.onOptionsItemSelected(item)
    }
}