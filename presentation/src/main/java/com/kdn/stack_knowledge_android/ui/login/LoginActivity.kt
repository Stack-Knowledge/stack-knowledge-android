package com.kdn.stack_knowledge_android.ui.login

import android.util.DisplayMetrics
import android.view.Display
import android.view.View
import androidx.activity.viewModels
import androidx.compose.ui.unit.dp
import com.kdn.stack_knowledge_android.ui.base.BaseActivity
import com.kdn.stack_knowledge_android.viewmodel.AuthViewModel
import com.kdn.stack_knowledge_android.R
import com.kdn.stack_knowledge_android.databinding.ActivityLoginBinding
import com.msg.gauthsignin.GAuthSigninWebView
import com.msg.gauthsignin.component.GAuthButton
import com.msg.gauthsignin.component.utils.Types
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val authViewModel by viewModels<AuthViewModel>()
    override fun createView() {

    }

    override fun observeEvent() {
        TODO("Not yet implemented")
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
                colors = Types.Colors.OUTLINE,
                horizontalMargin = (dpWidth / 2 - 120).dp
            ){
                binding.btnGauthLoginButton.visibility = View.VISIBLE
            }
        }
    }

    private fun setGAuthWebViewComponent() {
        binding.vGauthWebView.setContent {
            GAuthSigninWebView(clientId = ., redirectUri = , callBack = )
        }
    }
}