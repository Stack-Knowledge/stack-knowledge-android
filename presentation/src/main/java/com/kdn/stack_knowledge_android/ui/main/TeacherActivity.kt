package com.kdn.stack_knowledge_android.ui.main

import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.ActivityTeacherBinding
import com.kdn.stack_knowledge_android.ui.base.BaseActivity
import com.kdn.stack_knowledge_android.ui.base.BottomNavigationViewVisibilityListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeacherActivity : BaseActivity<ActivityTeacherBinding>(R.layout.activity_teacher),
    BottomNavigationViewVisibilityListener {
    override fun createView() {
        initBottomNav()
    }

    override fun observeEvent() {
    }

    private fun initBottomNav() {
        val navController =
            supportFragmentManager.findFragmentById(R.id.fcv_fragment_container)
                ?.findNavController()
        val nav = binding.bnTeacherBottomNavi
        navController?.let {
            nav.setupWithNavController(navController)
        }
    }

    override fun setBottomNavigationViewVisibility(isVisible: Boolean) {
        binding.bnTeacherBottomNavi.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
    }
}