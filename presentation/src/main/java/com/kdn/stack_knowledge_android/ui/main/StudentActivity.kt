package com.kdn.stack_knowledge_android.ui.main

import android.view.View
import androidx.navigation.ui.setupWithNavController
import androidx.navigation.fragment.findNavController
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.ActivityStudentBinding
import com.kdn.stack_knowledge_android.ui.base.BaseActivity
import com.kdn.stack_knowledge_android.ui.base.BottomNavigationViewVisibilityListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudentActivity : BaseActivity<ActivityStudentBinding>(R.layout.activity_student),
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
        val nav = binding.bnMainBottomNavi
        navController?.let {
            nav.setupWithNavController(navController)
        }
    }

    override fun setBottomNavigationViewVisibility(isVisible: Boolean) {
        binding.bnMainBottomNavi.visibility = if (isVisible) View.VISIBLE else View.INVISIBLE
    }
}