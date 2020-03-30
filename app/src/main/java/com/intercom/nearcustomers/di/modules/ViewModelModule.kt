package com.intercom.nearcustomers.di.modules

import com.intercom.nearcustomers.data.repositories.UsersRepository
import com.intercom.nearcustomers.view_models.UsersListViewModel
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import javax.inject.Named
import javax.inject.Singleton

@Module
class ViewModelModule {
    @Provides
    @Singleton
    fun provideUsersListViewMode(usersRepository: UsersRepository,
                                 @Named(SchedulerModule.IO_SCHEDULER) ioScheduler: Scheduler,
                                 @Named(SchedulerModule.UI_SCHEDULER) uiScheduler: Scheduler) : UsersListViewModel {
        return UsersListViewModel(usersRepository, ioScheduler, uiScheduler)
    }
}