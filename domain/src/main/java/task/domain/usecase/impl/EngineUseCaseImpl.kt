package task.domain.usecase.impl

import task.domain.repository.remote.CarRepository
import task.domain.usecase.EngineUseCase
import javax.inject.Inject

class EngineUseCaseImpl @Inject constructor(
    private val carRepository: CarRepository
) : EngineUseCase {
    override suspend fun startEngine(): Result<Boolean> {
        TODO("Not yet implemented")
    }

    override suspend fun stopEngine(): Result<Boolean> {
        TODO("Not yet implemented")
    }
}