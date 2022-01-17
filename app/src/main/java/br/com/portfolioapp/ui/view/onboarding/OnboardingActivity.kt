package br.com.portfolioapp.ui.view.onboarding

import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import br.com.portfolioapp.R
import br.com.portfolioapp.databinding.ActivityOnboardingBinding
import br.com.portfolioapp.ui.view.BaseActivity

class OnboardingActivity : BaseActivity<ActivityOnboardingBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        bindView(R.layout.activity_onboarding)
    }
}