package br.com.portfolioapp

import android.content.Context
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.portfolioapp.ui.view.onboarding.fragment.OnboardingFragment
import org.junit.Before

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseFragmentInstrumentedTest {
    protected lateinit var scenario: FragmentScenario<OnboardingFragment>
    protected lateinit var context: Context

    @Before
    fun setup() {
        scenario = launchFragmentInContainer()
        context = ApplicationProvider.getApplicationContext()
    }
}