package com.example.stack_knowledge_android.ui.login

import androidx.activity.viewModels
import androidx.compose.ui.unit.dp
import com.example.stack_knowledge_android.R
import com.example.stack_knowledge_android.databinding.ActivityLoginBinding
import com.example.stack_knowledge_android.ui.base.BaseActivity
import com.example.stack_knowledge_android.viewmodel.AuthViewModel
import com.msg.gauthsignin.component.GAuthButton
import com.msg.gauthsignin.component.utils.Types
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val authViewModel by viewModels<AuthViewModel>()
    override fun createView() {
        binding.btnGauthLoginButton.setContent {
            GAuthButton(
                style = Types.Style.DEFAULT,
                actionType = Types.ActionType.SIGNIN,
                colors = Types.Colors.OUTLINE,
                horizontalMargin = 16.dp
            ){

            }
        }
    }

    override fun observeEvent() {
        TODO("Not yet implemented")
    }

}