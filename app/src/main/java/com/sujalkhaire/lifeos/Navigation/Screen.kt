package com.sujalkhaire.lifeos.Navigation

sealed class Screen(val route:String){
    object Dashboard:Screen("dashboard")
    object Focus:Screen("focus")
    object Money:Screen("money")
    object Habits:Screen("habits")
    object Rules:Screen("rules")
}