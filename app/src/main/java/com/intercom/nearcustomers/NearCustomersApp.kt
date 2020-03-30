package com.intercom.nearcustomers

import android.app.Application
import com.intercom.nearcustomers.di.components.AppComponent
import com.intercom.nearcustomers.di.components.DaggerAppComponent
import com.intercom.nearcustomers.di.modules.AppModule

class NearCustomersApp : Application() {

    companion object {
        lateinit var app: Application
    }

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        app = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()
    }

    fun getAppComponent() : AppComponent {
        return appComponent
    }
}