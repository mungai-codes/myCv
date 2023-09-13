package com.mungai_codes.mycv.presentation.editscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mungai_codes.mycv.R
import com.mungai_codes.mycv.presentation.AppUiState
import com.mungai_codes.mycv.presentation.MainViewModel
import com.mungai_codes.mycv.presentation.editscreen.components.BioEditItem
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EditScreen(
    navController: NavController,
    viewModel: MainViewModel
) {

    LaunchedEffect(key1 = true) {
        viewModel.editScreenUiEventsSharedFlow.collectLatest { event ->
            when (event) {
                EditScreenUiEvents.NavigateToCvScreen -> {
                    navController.navigate("cv_screen")
                }
            }
        }
    }

    EditScreenContent(
        state = viewModel.state.collectAsState().value,
        onEvent = viewModel::onEditScreenEvent
    )
}

@Composable
fun EditScreenContent(
    state: AppUiState,
    onEvent: (EditScreenEvents) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onEvent(EditScreenEvents.OnDoneEditingEvent) }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_ok),
                    contentDescription = "done",
                    modifier = Modifier.size(30.dp)
                )
            }
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding()
                ),
            contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                BioEditItem(
                    label = "Edit your bio",
                    text = state.personalInfo.bio,
                    desc = "bio editing",
                    onEditText = { text ->
                        onEvent(
                            EditScreenEvents.EditBioEvent(text = text)
                        )
                    }
                )
            }

            item {

            }
        }
    }
}