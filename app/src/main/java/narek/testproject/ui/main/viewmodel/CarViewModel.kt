package narek.testproject.ui.main.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import task.domain.model.Result
import task.domain.usecase.DoorsUseCase
import task.domain.usecase.EngineUseCase
import javax.inject.Inject

@HiltViewModel
class CarViewModel @Inject constructor(
    private val doorsUseCase: DoorsUseCase,
    private val engineUseCase: EngineUseCase
) : ViewModel() {

    /**
     *  State for locking car doors
     */
    var doorsLockState by mutableStateOf<Result<Boolean>>(value = Result.Non())
        private set

    /**
     * State for unlocking car doors
     */
    var doorsUnLockState by mutableStateOf<Result<Boolean>>(value = Result.Non())
        private set

    fun lockDoors() {
        viewModelScope.launch {
            doorsUseCase.lockDoors().collect {
                doorsLockState = it
            }
        }
    }

    fun unLockDoors() {
        viewModelScope.launch {
            doorsUseCase.unLockDoors().collect {
                doorsUnLockState = it
            }
        }
    }
}