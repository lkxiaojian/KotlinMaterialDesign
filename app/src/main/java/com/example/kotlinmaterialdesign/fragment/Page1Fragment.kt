package com.example.kotlinmaterialdesign.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlinmaterialdesign.R
import com.example.kotlinmaterialdesign.spreadfunction.showToast
import com.example.kotlinmaterialdesign.spreadfunction.snackBar
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_page1.*


class Page1Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_page1, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fab.setOnClickListener {
            fab.snackBar("tip","Undo"){
                "toast".showToast()
            }
        }
    }

}