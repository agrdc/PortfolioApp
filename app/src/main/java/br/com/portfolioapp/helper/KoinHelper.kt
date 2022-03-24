package br.com.portfolioapp.helper

import android.app.Application
import br.com.portfolioapp.R
import br.com.portfolioapp.data.datasource.UserLocalDataSource
import br.com.portfolioapp.data.db.UserDatabaseManager
import br.com.portfolioapp.data.repository.UserRepository
import br.com.portfolioapp.domain.usecase.SaveUserUsecase
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
                factory { ValidateTextUsecase(androidContext().getString(R.string.validation_empty_error)) }
                factory { SaveUserUsecase(get()) }
                factory { UserRepository(get()) }
                factory { UserLocalDataSource(get()) }
                single { UserDatabaseManager(androidContext()) }
                viewModel { RegisterViewModel(get()) }
            }
        }
    }
}