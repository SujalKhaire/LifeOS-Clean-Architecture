package com.sujalkhaire.lifeos.Presentation.Rule

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RuleScreen(viewModel: RuleViewModel = hiltViewModel()){
    val message by viewModel.message.collectAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = "Rule", fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(26.dp))
        Button(onClick = { viewModel.addDummyRule() }) {
            Text(text = "Add Low Focus Rule")
        }
        Spacer(modifier = Modifier.height(26.dp))
        message.forEach {
            Text(text = it)
        }

    }
}