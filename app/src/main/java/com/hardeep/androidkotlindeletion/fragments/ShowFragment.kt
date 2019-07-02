package com.hardeep.androidkotlindeletion.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hardeep.androidkotlindeletion.R
import com.hardeep.androidkotlindeletion.adapters.ShowAdapter
import com.hardeep.androidkotlindeletion.database.DatabaseColumns
import com.hardeep.androidkotlindeletion.database.DatabaseQueries

import com.hardeep.androidkotlindeletion.model.ShowContent
import com.hardeep.androidkotlindeletion.model.ShowContent.ShowItem


class ShowFragment : Fragment() {

    // TODO: Customize parameters
    private var columnCount = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_show_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                val db = DatabaseQueries(activity!!.baseContext)
                val cursor = db.getUsers()
                if (cursor.moveToFirst())
                {
                    ShowContent.ITEMS.clear()
                    do{
                        val item = ShowItem(cursor.getString(cursor.getColumnIndex(DatabaseColumns.USER_NAME)),
                            cursor.getString(cursor.getColumnIndex(DatabaseColumns.USER_EMAIL)),
                            cursor.getString(cursor.getColumnIndex(DatabaseColumns.USER_PASS)))

                        ShowContent.ITEMS.add(item)
                    }
                    while (cursor.moveToNext())
                }
                val fragment = activity!!.supportFragmentManager
                // Pass context to adapter class
                adapter = ShowAdapter(ShowContent.ITEMS,activity!!.baseContext,fragment)
            }
        }
        return view
    }

}
