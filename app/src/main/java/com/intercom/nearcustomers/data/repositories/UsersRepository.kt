package com.intercom.nearcustomers.data.repositories

import com.intercom.nearcustomers.data.models.User
import io.reactivex.Observable

interface UsersRepository {
    fun getUsers(range: Int) : Observable<List<User>>
}