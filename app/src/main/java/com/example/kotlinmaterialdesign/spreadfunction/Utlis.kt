package com.example.kotlinmaterialdesign.spreadfunction

import android.view.View
import android.widget.Toast
import com.example.kotlinmaterialdesign.App.MyApp
import com.google.android.material.snackbar.Snackbar

/**
 *create_time : 20-12-21 上午9:52
 *author: root
 *description： Utlis
 */
fun String.showToast(duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(MyApp.application, this, duration).show()

fun Int.showToast(duration: Int = Toast.LENGTH_SHORT) =
    Toast.makeText(MyApp.application, this, duration).show()

fun View.snackBar(
    tip: String,
    actionText: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    block: (() -> Unit)? = null
) {
    val sandbar = Snackbar.make(this, tip, duration)
    if (actionText != null && block != null) {
        sandbar.setAction(actionText) {
            block()
        }
    }
    sandbar.show()
}

fun View.snackBar(
    resID: Int,
    actionText: String?,
    duration: Int = Snackbar.LENGTH_SHORT,
    block: (() -> Unit)? = null
) {
    val sandbar = Snackbar.make(this, resID, duration)
    if (actionText != null && block != null) {
        sandbar.setAction(actionText) {
            block()
        }
    }
    sandbar.show()
}

