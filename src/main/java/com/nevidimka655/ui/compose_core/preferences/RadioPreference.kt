package com.nevidimka655.ui.compose_core.preferences

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.nevidimka655.ui.compose_core.Preference
import com.nevidimka655.ui.compose_core.dialogs.DialogsCore
import com.nevidimka655.ui.compose_core.dialogs.radio

@Composable
fun RadioPreference(
    title: String,
    items: List<String>,
    selectedIndex: Int,
    onSelected: (Int) -> Unit,
) {
    var dialogState by DialogsCore.Selectable.radio(
        onSelected = onSelected,
        title = title,
        items = items,
        selectedItemIndex = selectedIndex
    )
    Preference(
        titleText = title,
        summaryText = items[selectedIndex]
    ) { dialogState = true }
}