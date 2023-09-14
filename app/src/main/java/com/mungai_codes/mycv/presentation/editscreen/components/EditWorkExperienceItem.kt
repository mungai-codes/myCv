package com.mungai_codes.mycv.presentation.editscreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.mungai_codes.mycv.domain.model.WorkExperience

@Composable
fun EditWorkExperienceItem(
    workExperience: WorkExperience,
    onWorkExperienceUpdate: (WorkExperience) -> Unit,
    modifier: Modifier = Modifier,
) {
    var editedWorkExperience by remember {
        mutableStateOf(workExperience)
    }
    val focusManager = LocalFocusManager.current

    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(
            modifier = Modifier.padding(8.dp), verticalArrangement = Arrangement.spacedBy(2.dp)
        ) {
            BasicTextField(
                value = editedWorkExperience.organisation,
                onValueChange = {
                    editedWorkExperience = editedWorkExperience.copy(organisation = it)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        onWorkExperienceUpdate(editedWorkExperience)
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                modifier = Modifier
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                BasicTextField(
                    value = editedWorkExperience.from,
                    onValueChange = {
                        editedWorkExperience = editedWorkExperience.copy(from = it)
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            onWorkExperienceUpdate(editedWorkExperience)
                            focusManager.moveFocus(FocusDirection.Right)
                        }
                    ),
                    modifier = Modifier
                )
                BasicTextField(
                    value = editedWorkExperience.to,
                    onValueChange = {
                        editedWorkExperience = editedWorkExperience.copy(to = it)
                    },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = {
                            onWorkExperienceUpdate(editedWorkExperience)
                            focusManager.moveFocus(FocusDirection.Down)
                        }
                    ),
                    modifier = Modifier
                )
            }
            BasicTextField(
                value = editedWorkExperience.role,
                onValueChange = {
                    editedWorkExperience = editedWorkExperience.copy(role = it)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        onWorkExperienceUpdate(editedWorkExperience)
                        focusManager.moveFocus(FocusDirection.Down)
                    }
                ),
                modifier = Modifier
            )
            BasicTextField(
                value = editedWorkExperience.description,
                onValueChange = {
                    editedWorkExperience = editedWorkExperience.copy(description = it)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        onWorkExperienceUpdate(editedWorkExperience)
                        focusManager.clearFocus()
                    }
                ),
                modifier = Modifier
            )

        }
    }

}