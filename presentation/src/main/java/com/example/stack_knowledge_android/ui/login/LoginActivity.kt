package com.example.stack_knowledge_android.ui.login

import androidx.activity.viewModels
import com.example.stack_knowledge_android.R
import com.example.stack_knowledge_android.databinding.ActivityLoginBinding
import com.example.stack_knowledge_android.ui.base.BaseActivity
import com.example.stack_knowledge_android.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.sql.Types

@AndroidEntryPoint
class LoginActivity : BaseActivity<ActivityLoginBinding>(R.layout.activity_login) {

    private val viewModel by viewModels<AuthViewModel>()
    override fun createView() {
        binding.btnGauthLoginButton.setContent {
            GAuthButton(
                style = Types.Style.DEFAULT,
                actionType = Types.ActionType.SIGNIN,
                colors = Types.Colors.OUTLINE,
                horizontalPaddingValue = (dpWidth / 2 - 120).dp
            ) {
            }
        }
    }

    override fun observeEvent() {
        TODO("Not yet implemented")
    }

}