package com.plcoding.cleanarchitecturenoteapp.feature_quiz.presentation.quiz

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.models.Quiz
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.use_cases.QuizUseCases
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.util.OrderType
import com.plcoding.cleanarchitecturenoteapp.feature_quiz.domain.util.QuizOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(
    private val quizUseCases: QuizUseCases
):ViewModel() {

    private var _state = mutableStateOf(QuizState())
    val state = _state


    private var getQuizesJob : Job? = null
    init {
        getQuizesWithOrder(QuizOrder.Date(OrderType.Descending))
    }
    fun onEvent(event: QuizEvent){
        when(event){
            is QuizEvent.DeleteQuiz ->{
                viewModelScope.launch {
                    quizUseCases.deleteQuiz(event.quiz)
                }
            }
            is QuizEvent.ToggleOrderSection -> {
                _state.value = _state.value.copy(
                    isOrderSectionVisible = !_state.value.isOrderSectionVisible
                )

            }
            is QuizEvent.Order -> {
                if(_state.value.order::class == event.quizOrder::class && _state.value.order.orderType == event.quizOrder.orderType){
                    return
                }
                getQuizesWithOrder(event.quizOrder)
            }
        }

    }

    private fun getQuizesWithOrder(order:QuizOrder){
        getQuizesJob?.cancel()
        getQuizesJob = quizUseCases.getQuizzes(order = order).onEach {list->
            _state.value = _state.value.copy(
                quizzes =  list,
                order = order
            )
            }
            .launchIn(viewModelScope)
    }
}