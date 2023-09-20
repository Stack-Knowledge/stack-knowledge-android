package com.kdn.stack_knowledge_android.ui.login

import android.content.Intent
import android.util.DisplayMetrics
import android.util.Log
import android.view.Display
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.kdn.stack_knowledge_android.BuildConfig
import com.kdn.stack_knowledge_android.ui.base.BaseActivity
import com.kdn.stack_knowledge_android.viewmodel.AuthViewModel
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.ActivityLoginBinding
import com.kdn.stack_knowledge_android.ui.main.MainActivity
import com.kdn.stack_knowledge_android.utils.Event
import com.msg.gauthsignin.GAuthSigninWebView
import com.msg.gauthsignin.component.GAuthButton
import com.msg.gauthsignin.component.utils.Types
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val authViewModel by viewModels<AuthViewModel>()
    private var backButtonWait: Long = 0

    override fun createView() {
        binding.login = this
        setGAuthButtonComponent()
        setGAuthWebViewComponent()
    }

    override fun observeEvent() {
        observeLoginEvent()
    }

    private fun setGAuthButtonComponent() {
        val display: Display = windowManager.defaultDisplay
        val outMetrics = DisplayMetrics()
        display.getMetrics(outMetrics)
        val density = resources.displayMetrics.density
        val dpWidth = outMetrics.widthPixels / density

        binding.btnGauthLoginButton.setContent {
            GAuthButton(
                style = Types.Style.DEFAULT,
                actionType = Types.ActionType.SIGNIN,
                colors = Types.Colors.COLORED,
                horizontalMargin = (dpWidth / 2 - 120).dp
            ){
                binding.vGauthWebView.visibility = View.VISIBLE
            }
        }
    }

    private fun setGAuthWebViewComponent() {
        binding.vGauthWebView.setContent {
            GAuthSigninWebView(
                clientId = BuildConfig.GAUTH_CLIENT_ID,
                redirectUri = BuildConfig.REDIRECT_URI,
                ) {code ->
                binding.vGauthWebView.visibility = View.INVISIBLE

                authViewModel.gAuthLogin(
                    code = code
                )
//                lifecycleScope.launch {
//                    authViewModel.isLoading
//                }
            }
        }
    }

    private fun observeLoginEvent() {
        authViewModel.gAuthLoginRequest.observe(this) { event ->
            when (event) {
                is Event.Success -> {
                    authViewModel.saveTheLoginData(event.data!!)
                }
                else -> {
                    Log.d("login", event.toString())
                }
            }
        }
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.filter { it is OnBackPressedListener }
            .map { it as OnBackPressedListener }
            .forEach { it.onBackPressed(); return }

        if (System.currentTimeMillis() - backButtonWait >= 2000) {
            backButtonWait = System.currentTimeMillis()
            Toast.makeText(this, "뒤로 가기 버튼을 한 번 더 누르면 종료됩니다.", Toast.LENGTH_LONG).show()
        } else {
            super.onBackPressed()
            finishAffinity()
            System.runFinalization()
            exitProcess(0)
        }
    }

    private fun pageController() {
        startActivity(
            Intent(
                this, MainActivity::class.java
            )
        )
        finish()
    }

    interface OnBackPressedListener {
        fun onBackPressed()
    }

}