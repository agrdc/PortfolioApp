package br.com.portfolioapp.ui.viewmodel.onboarding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.com.EmptyActivity
import br.com.SingleTimeObserver
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.robolectric.Robolectric.buildActivity

@RunWith(AndroidJUnit4::class)
class RegisterViewModelTest : KoinTest {
    private lateinit var registerViewModel: RegisterViewModel

    @Before
    fun setup() {
        val activity: EmptyActivity = buildActivity(EmptyActivity::class.java).get()
        registerViewModel = ViewModelProvider(activity)[RegisterViewModel::class.java]
    }

    @Test
    fun validateNameFieldTest_emptyField() {
        val emptyField = ""
        registerViewModel.validateField(emptyField)
        registerViewModel.validationErrorLiveData.observeOnce {
            //Test error is not null
            Assert.assertNotNull(it)
            //Test error is not empty
            Assert.assertNotEquals("", it)
            //Test button is not enabled
            Assert.assertFalse(registerViewModel.handleButtonEnabled(it))
        }
    }

    @Test
    fun validateNameFieldTest_validField() {
        val validField = "Jorge"
        registerViewModel.validateField(validField)
        registerViewModel.validationErrorLiveData.observeOnce {
            //Test error is null
            Assert.assertNull(it)
            //Test button is enabled
            Assert.assertTrue(registerViewModel.handleButtonEnabled(it))
        }
    }
}

private fun <T> MutableLiveData<T>.observeOnce(onChangeHandler: (T) -> Unit) {
    val observer = SingleTimeObserver(handler = onChangeHandler)
    observe(observer, observer)
}
