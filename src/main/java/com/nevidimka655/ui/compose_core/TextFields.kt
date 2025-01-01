
package com.nevidimka655.ui.compose_core

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign

object TextFieldsDefaults {

    object Icons

    @Composable
    fun textFieldValue(text: String = "", selectAll: Boolean = false) = rememberSaveable(
        stateSaver = TextFieldValue.Saver
    ) {
        mutableStateOf(
            TextFieldValue(
                text = text,
                selection = if (selectAll) TextRange(0, text.length) else TextRange(text.length)
            )
        )
    }

    @Composable
    fun placeholderText(text: String) = @Composable { Text(text = text) }

    @Composable
    fun labelText(text: String) = @Composable { Text(text = text) }

    @Composable
    fun supportingTextLengthCounter(length: Int, maxLength: Int) = @Composable {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "$length/$maxLength",
            textAlign = TextAlign.End
        )
    }

    @Composable
    fun supportingText(text: String) = @Composable {
        Text(text = text)
    }

}