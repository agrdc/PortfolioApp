package br.com.portfolioapp.ui.view.onboarding.fragment

import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import br.com.portfolioapp.BaseFragmentInstrumentedTest
import br.com.portfolioapp.R
import org.junit.Assert
import org.junit.Test

class OnboardingFragmentInstrumentedTest : BaseFragmentInstrumentedTest() {
    @Test
    fun btnLetsGoClick_Navigation_Test() {
        val testNavigationHostController = TestNavHostController(context)
        scenario.moveToState(Lifecycle.State.STARTED)
        scenario.onFragment {
            testNavigationHostController.setGraph(R.navigation.navigation_graph)
            Navigation.setViewNavController(it.requireView(), testNavigationHostController)
        }

        onView(withId(R.id.btn_lets_go))
            .perform(ViewActions.click())
        Assert.assertEquals(
            testNavigationHostController.currentDestination?.id,
            R.id.registerFragment
        )
    }

    @Test
    fun btnLestGo_Text_Test() {
        scenario.moveToState(Lifecycle.State.STARTED)

        onView(withId(R.id.btn_lets_go))
            .check(matches(withText(context.getString(R.string.lets_go))))
    }
}