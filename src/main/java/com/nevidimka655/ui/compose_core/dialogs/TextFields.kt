package com.nevidimka655.ui.compose_core.dialogs

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import com.nevidimka655.ui.compose_core.Compose
import com.nevidimka655.ui.compose_core.TextFieldsDefaults

@Composable
fun Dialogs.TextFields.default(
    state: MutableState<Boolean> = Compose.state(),
    title: String,
    params: Dialogs.TextFields.Params,
    onResult: (String) -> Unit
): MutableState<Boolean> {
    if (!state.value) return state

    var textValue by TextFieldsDefaults.textFieldValue(
        text = params.text,
        selectAll = params.selectAllText
    )
    DialogWithNewButtonBar(
        title = title,
        onDismissRequest = { state.value = false },
        onConfirmRequest = {
            state.value = false
            onResult(textValue.text.trim())
        },
        isConfirmButtonEnabled = textValue.text.isNotBlank()
    ) {
        val focusRequester = FocusRequester()
        OutlinedTextField(
            modifier = Modifier.focusRequester(focusRequester),
            value = textValue,
            onValueChange = {
                if (it.text.length <= params.maxLength) textValue = it
            },
            supportingText = when {
                !params.supportingText.isNullOrBlank() -> TextFieldsDefaults.supportingText(
                    text = params.supportingText
                )
                params.maxLength != Int.MAX_VALUE -> TextFieldsDefaults.supportingTextLengthCounter(
                    length = textValue.text.length,
                    maxLength = params.maxLength
                )
                else -> null
            },
            singleLine = params.singleLine,
            label = params.label?.let { TextFieldsDefaults.labelText(text = it) },
            keyboardOptions = params.keyboardOptions
        )

        SideEffect { focusRequester.requestFocus() }
    }
    return state
}