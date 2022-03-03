package br.com.portfolioapp.helper

import android.app.Application
import br.com.portfolioapp.domain.usecase.ValidateTextUsecase
import br.com.portfolioapp.ui.viewmodel.onboarding.RegisterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module
import org.koin.dsl.module
import timber.log.Timber

class KoinHelper {
    companion object {
        fun setupKoin(app: Application) {
            try {
                startKoin {
                    androidContext(app)
                    androidLogger(Level.ERROR)
                    getKoinModuleList().map {
                        modules(it)
                    }
                }
            } catch (e: Exception) {
                Timber.e(e)
            }
        }

        private fun getKoinModuleList(): ArrayList<Module> {
            return arrayListOf<Module>().apply {
                this.add(getKoinRegisterModule())
            }
        }

        fun getKoinRegisterModule(): Module {
            return module {
                factory { ValidateTextUsecase() }
                viewModel { RegisterViewModel(get()) }
            }
        }
    }
}