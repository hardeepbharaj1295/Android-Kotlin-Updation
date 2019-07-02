package com.hardeep.androidkotlindeletion.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.hardeep.androidkotlindeletion.R
import com.hardeep.androidkotlindeletion.database.DatabaseQueries

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class UpdateFragment : Fragment() {

    lateinit var name:EditText
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_update, container, false)

        name = v.findViewById(R.id.name)
        val button:Button = v.findViewById(R.id.update)



        val data = arguments
        Log.e("Data",data!!.getString("name"))

        name.setText(data!!.getString("name").toString())
        Toast.makeText(activity!!.baseContext,data.getString("name"),Toast.LENGTH_LONG).show()

        button.setOnClickListener {
            val db = DatabaseQueries(activity!!.baseContext)
            val result = db.updateUser(name.text.toString(),data.getString("email"))
            if (result>0)
            {
                Toast.makeText(activity!!.baseContext,"Success",Toast.LENGTH_LONG).show()
            }
            else
            {
                
            }
        }
        return v
    }

}
