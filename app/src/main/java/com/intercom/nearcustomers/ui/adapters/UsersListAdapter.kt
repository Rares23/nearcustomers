package com.intercom.nearcustomers.ui.adapters

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.intercom.nearcustomers.data.models.User
import com.intercom.nearcustomers.ui.views.UserItemView

class UsersListAdapter(private val context: Context) : RecyclerView.Adapter<UsersListAdapter.UserViewHolder>(){

    private var users: ArrayList<User> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: UserItemView = UserItemView(context)
        val layoutParams: FrameLayout.LayoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )

        view.layoutParams = layoutParams
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.view.setContent(users[position])
    }

    fun setUsers(users: List<User>) {
        this.users.clear()
        this.users.addAll(users)

        notifyDataSetChanged()
    }

    data class UserViewHolder(val view: UserItemView) : RecyclerView.ViewHolder(view)
}