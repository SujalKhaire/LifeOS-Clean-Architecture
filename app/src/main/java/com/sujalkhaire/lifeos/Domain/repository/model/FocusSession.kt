package com.sujalkhaire.lifeos.Domain.repository.model

data class FocusSession( val plannedMinutes: Int,
                         val focusedMinutes: Int,
                         val focusScore: Int,
                         val timestamp: Long)
