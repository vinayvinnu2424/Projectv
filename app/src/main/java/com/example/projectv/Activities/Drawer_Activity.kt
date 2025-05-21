package com.example.projectv.Activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.projectv.R
import com.example.projectv.databinding.ActivityDrawerBinding
import com.yarolegovich.slidingrootnav.SlidingRootNav
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder

class Drawer_Activity : AppCompatActivity() {

private lateinit var binding: ActivityDrawerBinding

private var slidingRootNav: SlidingRootNav? = null

    private lateinit var exitDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        slidingRootNav = SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(binding.toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(true)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.header)
                .inject()



    }
}