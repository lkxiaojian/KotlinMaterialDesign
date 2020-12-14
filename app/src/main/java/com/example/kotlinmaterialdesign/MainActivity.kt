package com.example.kotlinmaterialdesign

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.kotlinmaterialdesign.fragment.Page1Fragment
import com.example.kotlinmaterialdesign.fragment.Page2Fragment
import com.example.kotlinmaterialdesign.fragment.Page3Fragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.im_badge.*

class MainActivity : AppCompatActivity() {
    private val fragmet1 = lazy { Page1Fragment() }
    private val fragmet2 = lazy { Page2Fragment() }
    private val fragmet3 = lazy { Page3Fragment() }
    private lateinit var mCurrFragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //这里可以抽取个方法 如  navigation.childCount 得到底部有几个菜单栏 再进行遍历
        val menuView = bottom_navigation.getChildAt(0) as BottomNavigationMenuView
        val itemPage1 = menuView.findViewById<BottomNavigationItemView>(R.id.page_1)
        val badge: View = LayoutInflater.from(this).inflate(R.layout.im_badge, menuView, false)
        //为图片添加提示可以设置数量
        itemPage1.addView(badge)
        atv_num.text = "1"
        //md 版本1.2.1 长按下面的菜单兰 会出现吐司  这里拦截长按监听
        itemPage1.setOnLongClickListener { true }
        //如果没有提示就把textview 隐藏了

//      textView1.visibility = View.GONE

        mCurrFragment = fragmet1.value

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_content, mCurrFragment, R.string.text_label_1.toString()).commit()

// BottomNavigationView 切换监听
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.page_1 -> {
                    val value = fragmet1.value
                    switchContent(mCurrFragment, value, R.string.text_label_1.toString())
                    mCurrFragment = value
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_2 -> {
                    val value = fragmet2.value
                    switchContent(mCurrFragment, value, R.string.text_label_2.toString())
                    mCurrFragment = value
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.page_3 -> {
                    val value = fragmet3.value
                    switchContent(mCurrFragment, value, R.string.text_label_3.toString())
                    mCurrFragment = value
                    return@setOnNavigationItemSelectedListener true
                }
            }

            false
        }

    }


    private fun switchContent(from: Fragment?, to: Fragment?, tag: String?) {
        if (from == null || to == null) {
            return
        }
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        if (!to.isAdded) {
            transaction.hide(from).add(R.id.frame_content, to, tag).commit()
        } else {
            transaction.hide(from).show(to).commit()
        }
    }
}