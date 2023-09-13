package com.mungai_codes.mycv.presentation.editscreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.mungai_codes.mycv.domain.model.Education

@Composable
fun EditEducationItem(
    education: Education,
    onEducationUpdated: (Education) -> Unit,
    modifier: Modifier = Modifier
) {
    var editedEducation by remember {
        mutableStateOf(education)
    }

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        BasicTextField(
            value = editedEducation.institution,
            onValueChange = { editedEducation = editedEducation.copy(institution = it) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    onEducationUpdated(editedEducation)
                }
            ),
            modifier = Modifier
        )
        BasicTextField(
            value = editedEducation.from,
            onValueChange = { editedEducation = editedEducation.copy(from = it) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    onEducationUpdated(editedEducation)
                }
            ),
            modifier = Modifier
        )
        BasicTextField(
            value = editedEducation.to,
            onValueChange = { editedEducation = editedEducation.copy(to = it) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    onEducationUpdated(editedEducation)
                }
            ),
            modifier = Modifier
        )
        BasicTextField(
            value = editedEducation.qualification,
            onValueChange = { editedEducation = editedEducation.copy(qualification = it) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    onEducationUpdated(editedEducation)
                }
            ),
            modifier = Modifier
        )
        BasicTextField(
            value = editedEducation.grade,
            onValueChange = { editedEducation = editedEducation.copy(grade = it) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onEducationUpdated(editedEducation)
                }
            ),
            modifier = Modifier
        )
    }
}