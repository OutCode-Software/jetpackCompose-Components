package com.outcode.jetpackcomponents.ui.iconDropDown

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp


/**
 * Created by Niken Maharjan on 2023/2/21.
 */
@Composable
fun IconDropDown(
    dropDownList: List<String>,
    hint: String,
    shouldShowIcon: Boolean,
    imageVector: ImageVector? = null,
    shouldShowDropDownIcon: Boolean,
    dropDownImageVector: ImageVector? = null,
    onValueSelected: (String) -> Unit
) {
    var selectedDropDownValue by remember { mutableStateOf("") }
    var isCustomDropDownExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            OutlinedTextField(
                value = selectedDropDownValue,
                onValueChange = { },
                placeholder = { Text(text = hint) },
                enabled = false,
                modifier = Modifier
                    .padding(16.dp, 32.dp, 32.dp, 0.dp)
                    .clickable {
                        isCustomDropDownExpanded = true
                    }
                    .fillMaxWidth(0.8f),
                textStyle = TextStyle(color = Color.Black),
                trailingIcon =
                {
                    if (shouldShowIcon) {
                        imageVector?.let { Icon(imageVector = it, contentDescription = "") }
                    }
                }
            )

            DropdownMenu(
                expanded = isCustomDropDownExpanded,
                onDismissRequest = { isCustomDropDownExpanded = false },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
            ) {
                dropDownList.forEachIndexed { index, selectedValue ->
                    DropdownMenuItem(onClick = {
                        selectedDropDownValue = selectedValue
                        onValueSelected(selectedValue)
                        isCustomDropDownExpanded = false
                    }) {
                        Modifier.fillMaxWidth()
                        Text(selectedValue)
                        if (shouldShowDropDownIcon) {
                            Row(
                                horizontalArrangement = Arrangement.End,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                dropDownImageVector?.let {
                                    Icon(
                                        imageVector = it,
                                        contentDescription = null
                                    )
                                }
                            }
                        }

                    }
                    if (index != dropDownList.lastIndex)
                        Divider(Modifier.background(Color.Black))
                }
            }
        }
    }

}