package com.example.kotlinmaterialdesign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        //这里可以抽取个方法 如  navigation.childCount 得到底部有几个菜单栏 再进行遍历
        val menuView = navigation.getChildAt(0) as BottomNavigationMenuView
        val itemPage1 = menuView.findViewById<BottomNavigationItemView>(R.id.page_1)
        val badge: View = LayoutInflater.from(this).inflate(R.layout.im_badge, menuView, false)
        //为图片添加提示可以设置数量
        itemPage1.addView(badge)
        val textView1 = badge.findViewById<AppCompatTextView>(R.id.atv_num)
        textView1.text = "1"
        //md 版本1.2.1 长按下面的菜单兰 会出现吐司  这里拦截长按监听
        itemPage1.setOnLongClickListener { true }
        //如果没有提示就把textview 隐藏了
//        textView1.visibility = View.GONE

    }
}