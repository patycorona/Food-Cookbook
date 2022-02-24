package com.example.foodcookbook.views.component

import android.view.View

fun View.setLayoutHeight(height: Float) {
    val layoutParams = this.layoutParams
    layoutParams.height = height.toInt()
    this.layoutParams = layoutParams
}
