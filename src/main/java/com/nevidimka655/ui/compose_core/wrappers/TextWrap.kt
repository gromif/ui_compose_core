package com.nevidimka655.ui.compose_core.wrappers

import android.content.Context
import androidx.annotation.StringRes

sealed class TextWrap {
    abstract fun resolve(context: Context): String

    data class Resource(@StringRes val id: Int) : TextWrap() {
        override fun resolve(context: Context): String {
            return context.getString(id)
        }
    }

    data class Text(val text: String) : TextWrap() {
        override fun resolve(context: Context): String {
            return text
        }
    }
}