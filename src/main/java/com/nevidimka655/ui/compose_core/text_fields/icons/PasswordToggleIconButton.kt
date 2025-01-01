package com.nevidimka655.ui.compose_core.text_fields.icons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import com.nevidimka655.ui.compose_core.TextFieldsDefaults

@Composable
fun TextFieldsDefaults.Icons.PasswordToggleIconButton(
    visible: Boolean,
    onChangeVisibility: (Boolean) -> Unit
) = IconButton(onClick = { onChangeVisibility(!visible) }) {
    Icon(
        imageVector = if (!visible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
        contentDescription = null
    )
}