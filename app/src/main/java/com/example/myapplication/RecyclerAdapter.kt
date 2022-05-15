package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemBinding

class RecyclerAdapter(
    private val layoutInflater: LayoutInflater,
    private val users: List<User>
) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = layoutInflater.inflate(R.layout.list_item, parent, false)
        val viewHolder = MyViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = users[position]

        ListItemBinding.bind(holder.itemView).apply {
            userFullNameTextView.text = item.firstName + " " + item.lastName
            userAddressTextView.text = item.address
        }
    }

    override fun getItemCount(): Int = users.size

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}