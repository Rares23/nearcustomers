package com.intercom.nearcustomers.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.intercom.nearcustomers.R
import com.intercom.nearcustomers.data.models.User
import kotlinx.android.synthetic.main.item_view_user.view.*

class UserItemView : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        View.inflate(context, R.layout.item_view_user, this)
    }

    fun setContent(user: User) {
        textView_name.text = user.name
        textView_id.text = "id: ${user.id}"
    }
}