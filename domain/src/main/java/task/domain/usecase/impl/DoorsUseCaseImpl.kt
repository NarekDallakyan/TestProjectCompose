package task.domain.usecase.impl

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import task.domain.exeption.DoorLockException
import task.domain.exeption.DoorUnlockException
import task.domain.model.Result
import task.domain.repository.remote.CarRepository
import task.domain.usecase.DoorsUseCase
import javax.inject.Inject

class DoorsUseCaseImpl @Inject constructor(
    private val carRepository: CarRepository
) : DoorsUseCase {

    override suspend fun lockDoors(): Flow<Result<Boolean>> = flow {
        emit(Result.Loading())
        val lockResult = carRepository.lockDoors()
        delay(5000)
        if (lockResult == 0) {
            emit(Result.success(true))
        } else {
            emit(Result.Failure(stateError = DoorLockException("Can't lock doors, please try again")))
        }
    }

    override suspend fun unLockDoors(): Flow<Result<Boolean>> = flow {
        emit(Result.Loading())
        val unLockResult = carRepository.unLockDoors()
        delay(5000)
        if (unLockResult == 0) {
            emit(Result.success(true))
        } else {
            emit(Result.Failure(stateError = DoorUnlockException("Can't unlock doors, please try again")))
        }
    }
}