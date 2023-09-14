package com.mungai_codes.mycv.presentation.editscreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
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
import com.mungai_codes.mycv.domain.model.Skill

@Composable
fun EditSkillItem(
    skill: Skill,
    onSkillUpdated: (Skill) -> Unit,
    modifier: Modifier = Modifier
) {
    var editedSkill by remember {
        mutableStateOf(skill)
    }
    val focusManager = LocalFocusManager.current

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .padding(start = 16.dp, end = 8.dp)
                .size(4.dp)
                .background(
                    MaterialTheme.colorScheme.onBackground,
                    shape = CircleShape
                )
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            BasicTextField(
                value = editedSkill.skillName,
                onValueChange = { editedSkill = editedSkill.copy(skillName = it) },
                keyboardOptions = KeyboardOptions(
                    imeAction = if (editedSkill.description != null) ImeAction.Next else ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        onSkillUpdated(editedSkill)
                        focusManager.moveFocus(FocusDirection.Right)
                    },
                    onDone = {
                        onSkillUpdated(editedSkill)
                        focusManager.clearFocus()
                    }
                ),
                modifier = Modifier
            )
            Spacer(modifier = Modifier.width(2.dp))
            editedSkill.description?.let { desc ->
                BasicTextField(
                    value = desc,
                    onValueChange = { editedSkill = editedSkill.copy(description = it) },
                    keyboardOptions = KeyboardOptions(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            onSkillUpdated(editedSkill)
                            focusManager.clearFocus()
                        }
                    ),
                    modifier = Modifier
                )
            }
        }
    }
}
