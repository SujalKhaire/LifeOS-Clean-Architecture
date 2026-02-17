package com.sujalkhaire.lifeos.Domain.repository.model

data class Rule(
    val id: Int = 0,
    val conditionType: String,
    val threshold: Int,
    val message: String
)
