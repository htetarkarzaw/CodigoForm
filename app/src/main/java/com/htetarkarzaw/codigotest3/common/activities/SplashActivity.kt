package com.htetarkarzaw.codigotest3.common.activities

import android.content.Context
import android.content.Intent
import com.htetarkarzaw.codigotest3.common.base.BaseActivity
import com.htetarkarzaw.codigotest3.databinding.ActivitySplashActvitiyBinding

class SplashActivity :
    BaseActivity<ActivitySplashActvitiyBinding>(ActivitySplashActvitiyBinding::inflate) {
    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SplashActivity::class.java)
        }
    }

    override fun initUi() {
        binding.btnCreateNewAccount.setOnClickListener {
            startActivity(RegisterActivity.newIntent(this))
        }
    }

    override fun observe() {
//        TODO("Not yet implemented")
    }
}