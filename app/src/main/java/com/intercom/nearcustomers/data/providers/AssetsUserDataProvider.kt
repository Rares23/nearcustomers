package com.intercom.nearcustomers.data.providers

import android.content.res.AssetManager
import com.google.gson.Gson
import com.intercom.nearcustomers.data.models.User
import io.reactivex.Observable
import java.io.IOException
import java.io.InputStream
import javax.inject.Inject

class AssetsUserDataProvider @Inject constructor(private val assetManager: AssetManager) : UsersDataProvider {
    override fun loadUsers(): Observable<List<User>> {
        return Observable.just(readUsersJson())
    }

    private fun readUsersJson() : List<User> {
        val inputStream = assetManager.open("users.json")
        val jsonData: String = inputStreamToString(inputStream)
        val users: Array<User> = Gson().fromJson(jsonData, Array<User>::class.java)
        return users.toList()
    }

    private fun inputStreamToString(inputStream: InputStream): String {
        try {
            val bytes = ByteArray(inputStream.available())
            inputStream.read(bytes, 0, bytes.size)
            return String(bytes)
        } catch (e: IOException) {
            return "Something went wrong on the file read"
        }
    }
}