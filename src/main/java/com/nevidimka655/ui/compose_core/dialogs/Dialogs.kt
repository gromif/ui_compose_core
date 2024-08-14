package com.nevidimka655.ui.compose_core.dialogs

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import com.nevidimka655.ui.compose_core.Compose

object Dialogs {

    object Components

    object TextFields {

        data class Params(
            val text: String = "",
            val supportingText: String? = null,
            val selectAllText: Boolean = false,
            val label: String? = null,
            val maxLength: Int = Int.MAX_VALUE,
            val singleLine: Boolean = false,
            val keyboardOptions: KeyboardOptions = KeyboardOptions.Default
        )

    }

    object Selectable

    @Composable
    fun simple(
        title: String?,
        text: String,
        confirmText: String = stringResource(id = android.R.string.ok),
        dismissText: String? = stringResource(id = android.R.string.cancel),
        dismissOnButtonClick: Boolean = true,
        dismissOnOutsideClick: Boolean = true,
        onDismissRequest: (() -> Unit)? = null,
        onDismissClick: (() -> Unit)? = null,
        onConfirmClick: () -> Unit = {}
    ): MutableState<Boolean> {
        val state = Compose.state()
        if (state.value) Dialog(
            title = title?.let { DialogDefaults.title(title = it) },
            content = DialogDefaults.contentText(text = text),
            confirmButton = DialogDefaults.textButton(title = confirmText) {
                if (dismissOnButtonClick) state.value = false
                onConfirmClick()
            },
            dismissButton = dismissText?.let {
                DialogDefaults.textButton(title = it) {
                    if (dismissOnButtonClick) state.value = false
                    onDismissClick?.invoke()
                }
            },
            onDismissRequest = {
                if (dismissOnOutsideClick) state.value = false
                onDismissRequest?.invoke()
            },
            dismissOnBackPress = dismissOnOutsideClick,
            dismissOnClickOutside = dismissOnOutsideClick
        )
        return state
    }

}