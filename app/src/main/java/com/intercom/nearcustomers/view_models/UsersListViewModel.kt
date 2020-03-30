package com.intercom.nearcustomers.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.intercom.nearcustomers.data.models.User
import com.intercom.nearcustomers.data.repositories.UsersRepository
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class UsersListViewModel @Inject constructor(
    private val usersRepository: UsersRepository,
    private val ioScheduler: Scheduler,
    private val uiScheduler: Scheduler
): ViewModel() {

    private lateinit var disposable: Disposable

    val usersList: MutableLiveData<List<User>> = MutableLiveData()
    val range: MutableLiveData<Int> = MutableLiveData(100)

    fun loadUsers(range: Int = 100) {
        this.range.value = range

        disposable = usersRepository.getUsers(range)
            .subscribeOn(ioScheduler)
            .observeOn(uiScheduler)
            .subscribe {
                usersList.value = it
            }
    }

    override fun onCleared() {
        super.onCleared()
        if(disposable.isDisposed) {
            disposable.dispose()
        }
    }
}