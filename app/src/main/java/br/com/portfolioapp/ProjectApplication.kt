package br.com.portfolioapp

import android.app.Application
import br.com.portfolioapp.helper.KoinHelper

class ProjectApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        KoinHelper.setupKoin(this@ProjectApplication)
    }
}