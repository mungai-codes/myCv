package com.mungai_codes.mycv.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mungai_codes.mycv.presentation.MainViewModel
import com.mungai_codes.mycv.presentation.cvscreen.CvScreen
import com.mungai_codes.mycv.presentation.editscreen.EditScreen

@Composable
fun App(navController: NavHostController, viewModel: MainViewModel) {
    NavHost(navController = navController, startDestination = "cv_screen") {
        composable("cv_screen") {
            CvScreen(navController = navController, viewModel = viewModel)
        }
        composable("edit_screen") {
            EditScreen(navController = navController, viewModel = viewModel)
        }
    }
}