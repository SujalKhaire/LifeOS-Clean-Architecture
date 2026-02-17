package com.sujalkhaire.lifeos.Presentation.Habit

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HabitScreen(viewModel: HabitViewModel = hiltViewModel()){

    val habits by viewModel.habits.collectAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Habit", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(22.dp))
        Button(onClick = { viewModel.addDummyHabit()}) {
            Text(text = "Add Habit", fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(22.dp))
        habits.forEach {
            Card(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp)) {
                Column {
                    Text(text = it.name)
                    Text(text = "Streak : ${it.streak}")
                    Text(text = "Success Rate : ${it.successRate}")
                    Button(onClick = {viewModel.updateHabit(it)}) {
                        Text(text = "Complete")
                    }
                }

            }
        }
    }
}