package com.intercom.nearcustomers.di.modules

import com.intercom.nearcustomers.data.providers.UsersDataProvider
import com.intercom.nearcustomers.data.repositories.ImplUsersRepository
import com.intercom.nearcustomers.data.repositories.UsersRepository
import com.intercom.nearcustomers.utils.ImplRangeFilter
import com.intercom.nearcustomers.utils.RangeFilter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideUsersRepository(usersDataProvider: UsersDataProvider, rangeFilter: RangeFilter) : UsersRepository {
        return ImplUsersRepository(usersDataProvider, rangeFilter)
    }
}