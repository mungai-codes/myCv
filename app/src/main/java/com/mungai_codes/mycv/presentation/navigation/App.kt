package com.mungai_codes.mycv.presentation.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mungai_codes.mycv.presentation.cvscreen.CvScreen

@Composable
fun App(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "cv_screen") {
        composable("cv_screen") {
            CvScreen(navController = navController)
        }
        composable("edit_screen") {
            // EditScreen()
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Edit your CV here")
            }
        }
    }
}