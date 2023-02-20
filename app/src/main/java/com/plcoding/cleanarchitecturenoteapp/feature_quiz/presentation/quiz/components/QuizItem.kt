package com.plcoding.cleanarchitecturenoteapp.feature_quiz.presentation.quiz.components

import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Quiz
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils



@Composable
fun QuizItem(
    quiz: Quiz,
    modifier:Modifier = Modifier,
    cornerRadius : Dp = 10.dp,
    cutCornerSize:Dp = 30.dp,
    onDelete: ()->Unit
){
    Box(
        modifier = modifier
    ){
        Canvas(
            modifier = Modifier.matchParentSize(),
        ){
            val clipPath = Path().apply {
                lineTo(size.width - cutCornerSize.toPx(), 0f)
                lineTo(size.width, cutCornerSize.toPx())
                lineTo(size.width, size.height)
                lineTo(0f,size.height)
                close()
            }
            clipPath(clipPath){
                drawRoundRect(
                    color = Color.White,
                    size = size,
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
                drawRoundRect(
                    color = Color.White,
                    topLeft = Offset(size.width - cutCornerSize.toPx(), -100f),
                    size = Size(cutCornerSize.toPx()+100f, cutCornerSize.toPx()+100f),
                    cornerRadius = CornerRadius(cornerRadius.toPx())
                )
            }
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(end = 32.dp)
        ) {
            Text(
                text= quiz.title,
                style = MaterialTheme.typography.h6,
                color = MaterialTheme.colors.onSurface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(2.dp))
            Text(
                text= quiz.description,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                maxLines = 10,
                overflow = TextOverflow.Ellipsis
            )
        }
        IconButton(
            onClick = onDelete,
            modifier = modifier
        ) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete note")
        }
    }
}