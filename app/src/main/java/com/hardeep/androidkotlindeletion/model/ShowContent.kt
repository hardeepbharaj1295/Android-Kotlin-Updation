package com.hardeep.androidkotlindeletion.model

import java.util.ArrayList

object ShowContent {

    val ITEMS: ArrayList<ShowItem> = ArrayList()

    data class ShowItem(val name: String, val email: String, val password: String) {
        override fun toString(): String = email
    }
}
