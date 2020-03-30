package com.intercom.nearcustomers.di.modules

import android.app.Application
import android.content.Context
import android.content.res.AssetManager
import com.intercom.nearcustomers.NearCustomersApp
import com.intercom.nearcustomers.utils.ImplRangeFilter
import com.intercom.nearcustomers.utils.RangeFilter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    DataProviderModule::class,
    RepositoryModule::class,
    ViewModelModule::class,
    SchedulerModule::class
])
class AppModule {
    @Singleton
    @Provides
    fun provideAssetsManager(context: Context) : AssetManager {
        return context.assets
    }

    @Singleton
    @Provides
    fun provideApplicationContext() : Context {
        return NearCustomersApp.app
    }

    @Provides
    @Singleton
    fun provideRangeFilter() : RangeFilter {
        return ImplRangeFilter()
    }
}