package com.intercom.nearcustomers.data.repositories

import com.intercom.nearcustomers.data.models.User
import com.intercom.nearcustomers.data.providers.UsersDataProvider
import com.intercom.nearcustomers.utils.RangeFilter
import io.reactivex.Observable
import javax.inject.Inject

class ImplUsersRepository @Inject constructor(
    private val usersDataProvider: UsersDataProvider,
    private val rangeFilter: RangeFilter) : UsersRepository {

    private val centerLat: Double = 53.339428
    private val centerLng: Double = -6.257664

    override fun getUsers(range: Int): Observable<List<User>> {
        return usersDataProvider.loadUsers()
            .map {
                val filteredUsersList: ArrayList<User> = ArrayList()

                it.forEach {user ->
                    if(rangeFilter.isInRange(
                            range = range,
                            firstLat = centerLat,
                            secondLat = user.lat,
                            firstLng = centerLng,
                            secondLng = user.lng
                        )) {
                        filteredUsersList.add(user)
                    }
                }

                return@map filteredUsersList
            }.map {
                it.sortBy {user ->
                    user.id
                }

                return@map it
            }
    }
}