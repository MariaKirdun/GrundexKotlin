package com.manya.grundexkotlin.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Message
import android.util.AttributeSet
import android.widget.AutoCompleteTextView


class DelayAutoCompleteTextView(context: Context, attrs: AttributeSet) : AutoCompleteTextView(context, attrs) {

    private var mAutoCompleteDelay = DEFAULT_AUTOCOMPLETE_DELAY

    private val mHandler = @SuppressLint("HandlerLeak")
    object : Handler() {
        override fun handleMessage(msg: Message) {
            super@DelayAutoCompleteTextView.performFiltering(msg.obj as CharSequence, msg.arg1)
        }
    }

    override fun performFiltering(text: CharSequence, keyCode: Int) {
        mHandler.removeMessages(MESSAGE_TEXT_CHANGED)
        mHandler.sendMessageDelayed(mHandler.obtainMessage(MESSAGE_TEXT_CHANGED, text), mAutoCompleteDelay.toLong())
    }

    companion object {

        private const val MESSAGE_TEXT_CHANGED = 100
        private const val DEFAULT_AUTOCOMPLETE_DELAY = 750
    }
}