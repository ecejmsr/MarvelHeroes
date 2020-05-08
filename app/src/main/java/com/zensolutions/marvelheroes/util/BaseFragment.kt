package com.zensolutions.marvelheroes.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseFragment : Fragment() {
    /*
    *  Resource ID of resource layout to be inflated
    * */
    protected  abstract val layoutResourceID: Int

    /*
    * Overriding onCreateView to inflate resource layout file
    * */
    final override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutResourceID, container, false)
    }


    @Suppress("UNCHECKED_CAST")
    inline fun <reified V : ViewModel> Fragment.createViewModel(crossinline instance: () -> V): V {
        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return instance() as T
            }
        }
        return ViewModelProvider(this, factory).get(V::class.java)
    }
}
