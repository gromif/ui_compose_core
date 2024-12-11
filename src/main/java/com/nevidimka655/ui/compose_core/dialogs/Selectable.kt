package com.nevidimka655.ui.compose_core.dialogs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.res.stringResource
import com.nevidimka655.ui.compose_core.Compose
import com.nevidimka655.ui.compose_core.RadioOneLineListItem

@Composable
fun DialogsCore.Selectable.radio(
    onDismissRequest: () -> Unit = {},
    onSelected: (Int) -> Unit,
    title: String,
    items: List<String>,
    selectedItemIndex: Int
): MutableState<Boolean> {
    val state = Compose.state()
    if (state.value) Dialog(
        title = DialogDefaults.titleCentered(title = title),
        confirmButton = DialogDefaults.textButton(
            title = stringResource(id = android.R.string.cancel),
            onClick = {
                state.value = false
                onDismissRequest()
            }
        ),
        dismissButton = null,
        onDismissRequest = {
            state.value = false
            onDismissRequest()
        },
        content = DialogDefaults.contentRootScrollable(
            verticalArrangement = Arrangement.Top
        ) {
            items.forEachIndexed { index, s ->
                RadioOneLineListItem(
                    isSelected = index == selectedItemIndex,
                    titleText = s
                ) {
                    state.value = false
                    onSelected(index)
                }
            }
        }
    )
    return state
}