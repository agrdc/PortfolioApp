package br.com.portfolioapp

import android.app.Application
import br.com.portfolioapp.domain.usecase.ValidateTextUsecase
import br.com.portfolioapp.ui.viewmodel.onboarding.RegisterViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class ProjectApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() {
        val registerModule = module {
            factory { ValidateTextUsecase() }
            viewModel { RegisterViewModel(get(), get())}
        }
        startKoin {
            androidContext(this@ProjectApplication)
            androidLogger(Level.ERROR)
            modules(registerModule)
        }
    }
}