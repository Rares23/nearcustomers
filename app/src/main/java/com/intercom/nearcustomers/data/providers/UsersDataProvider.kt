package com.intercom.nearcustomers.data.providers

import com.intercom.nearcustomers.data.models.User
import io.reactivex.Observable

interface UsersDataProvider {
    fun loadUsers() : Observable<List<User>>
}