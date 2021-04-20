package com.balditsyn.stackoveflow.ui

import androidx.lifecycle.*
import com.balditsyn.stackoveflow.data.model.Answer
import com.balditsyn.stackoveflow.data.repository.QuestionRepository
import com.balditsyn.stackoveflow.data.utils.State
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.collect

class AnswerListViewModel(
    private val questionRepository: QuestionRepository,
): ViewModel() {
    val question = questionRepository.selectedQuestion

    private val _state = MutableLiveData<State<List<Answer>>>()
    val state: LiveData<State<List<Answer>>>
        get() = _state

    init {
        _state.value = State.loading()
    }

    fun getAnswers() {
        viewModelScope.launch {
            val question = question.value ?: return@launch
            questionRepository.getAnswers(question.id).collect {
                _state.value = it
            }
        }
    }
}

