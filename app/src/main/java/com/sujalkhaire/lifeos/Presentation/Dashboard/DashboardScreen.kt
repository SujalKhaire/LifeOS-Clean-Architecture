package com.sujalkhaire.lifeos.Presentation.Dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DashboardScreen(viewmodel: DashboardViewmodel = hiltViewModel()){
    val state by viewmodel.uiState.collectAsState()

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "Dashboard", fontWeight = FontWeight.ExtraBold)
        Card(modifier = Modifier.fillMaxWidth()) {
            Text(text = "Average Score", fontWeight = FontWeight.Bold, fontSize = 22.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text(text =state.avgFocusScore.toString(),fontWeight = FontWeight.Bold, fontSize = 16.sp )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = state.focusStatus,fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}