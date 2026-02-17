package com.sujalkhaire.lifeos.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sujalkhaire.lifeos.Presentation.Dashboard.DashboardScreen
import com.sujalkhaire.lifeos.Presentation.Focus.FocusScreen
import com.sujalkhaire.lifeos.Presentation.Habit.HabitScreen
import com.sujalkhaire.lifeos.Presentation.Money.MoneyScreen
import com.sujalkhaire.lifeos.Presentation.Rule.RuleScreen

@Composable
fun LifeOsNavHost(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Dashboard.route ){
        composable(route= Screen.Dashboard.route){
            DashboardScreen()
        }
        composable(route= Screen.Focus.route){
            FocusScreen()
        }
        composable(route= Screen.Money.route){
            MoneyScreen()
        }
        composable(route= Screen.Habits.route){
            HabitScreen()
        }
        composable(route= Screen.Rules.route){
            RuleScreen()
        }
    }
}