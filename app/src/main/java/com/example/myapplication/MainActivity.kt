package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.github.javafaker.Faker

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var listContainer: LinearLayout

    private val controller = MainController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listContainer = findViewById(R.id.listContainer)

        controller.onViewReady(this)
    }

    override fun displayList(users: List<User>) {
        listContainer.removeAllViews()

        users.forEach() {
            val itemView = createItemView(listContainer)
            listContainer.addView(itemView)

            val fullName = it.firstName + "" + it.lastName
            fillItemView(itemView, fullName, it.address)
        }
    }

    private fun createItemView(listContainer: LinearLayout): View {
        return layoutInflater.inflate(R.layout.list_item, listContainer, false)
    }

    private fun fillItemView(itemView: View, fullName: String?, fullAddress: String?) {
        val userFullNameTextView = itemView.findViewById<TextView>(R.id.userFullNameTextView)
        val userAddressTextView = itemView.findViewById<TextView>(R.id.userAddressTextView)

        userFullNameTextView.text = fullName
        userAddressTextView.text = fullAddress
    }

    fun addListItem(view: View?) = controller.onAddRandomClicked()

    fun removeLast(view: View) = controller.onRemoveLastClicked()

    fun removeAll(view: View) = controller.onRemoveAllClicked()

    fun editSecond(view: View) = controller.onEditSecondClicked()
}