package com.intercom.nearcustomers.di.modules

import android.content.res.AssetManager
import com.intercom.nearcustomers.data.providers.AssetsUserDataProvider
import com.intercom.nearcustomers.data.providers.UsersDataProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataProviderModule {
    @Provides
    @Singleton
    fun provideUsersDataProvider(assetManager: AssetManager) : UsersDataProvider{
        return AssetsUserDataProvider(assetManager)
    }
}