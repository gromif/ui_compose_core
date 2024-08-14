package com.nevidimka655.ui.compose_core.wrappers

import androidx.annotation.StringRes

class TextWrap {
    @StringRes
    var id: Int? = null
        private set
    var text: String? = null
        private set

    constructor(@StringRes id: Int) {
        this.id = id
    }

    constructor(text: String) {
        this.text = text
    }
}