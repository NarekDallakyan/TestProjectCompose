package task.domain.usecase

import kotlinx.coroutines.flow.Flow
import task.domain.model.Result

interface DoorsUseCase {
    suspend fun lockDoors(): Flow<Result<Boolean>>
    suspend fun unLockDoors(): Flow<Result<Boolean>>
}