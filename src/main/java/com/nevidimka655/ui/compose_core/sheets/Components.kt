package com.nevidimka655.ui.compose_core.sheets

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

object Sheets {

    object Components

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun state() = rememberModalBottomSheetState(skipPartiallyExpanded = true)

}

@Preview(showBackground = true)
@Composable
fun Sheets.Components.Title(text: String = "Create New") = Text(
    modifier = Modifier.fillMaxWidth(),
    text = text,
    style = MaterialTheme.typography.titleLarge,
    textAlign = TextAlign.Center
)