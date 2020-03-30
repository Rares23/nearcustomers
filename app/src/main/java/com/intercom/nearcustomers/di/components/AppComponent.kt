package com.intercom.nearcustomers.di.components

import com.intercom.nearcustomers.di.modules.AppModule
import com.intercom.nearcustomers.ui.activities.UsersListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(usersListActivity: UsersListActivity)
}