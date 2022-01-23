package task.domain.usecase

interface EngineUseCase {

    suspend fun startEngine(): Result<Boolean>
    suspend fun stopEngine(): Result<Boolean>
}