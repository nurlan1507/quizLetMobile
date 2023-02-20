package com.plcoding.cleanarchitecturenoteapp.feature_quiz.presentation.quiz.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.cleanarchitecturenoteapp.feature_note.presentation.notes.components.DefaultRadioButton
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Quiz
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.util.OrderType
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.util.QuizOrder

@Composable
fun OrderSection(
    modifier: Modifier,
    quizOrder: QuizOrder = QuizOrder.Date(OrderType.Descending),
    onOrderChange:(QuizOrder)->Unit
){
    Column(modifier = modifier) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)){
            DefaultRadioButton(
                text = "Title",
                selected = quizOrder is QuizOrder.Title ,
                onSelect = { onOrderChange(QuizOrder.Title(quizOrder.orderType))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Date",
                selected = quizOrder is QuizOrder.Date ,
                onSelect = { onOrderChange(QuizOrder.Date(quizOrder.orderType))
                }
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)){
            DefaultRadioButton(
                text = "Ascending",
                selected = quizOrder.orderType is OrderType.Ascending ,
                onSelect = { onOrderChange(quizOrder.copy(OrderType.Ascending))
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            DefaultRadioButton(
                text = "Descending",
                selected = quizOrder.orderType is OrderType.Descending ,
                onSelect = { onOrderChange(quizOrder.copy(OrderType.Descending))
                }
            )
        }
    }
}