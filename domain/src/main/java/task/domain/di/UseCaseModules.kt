package task.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import task.domain.repository.remote.CarRepository
import task.domain.usecase.DoorsUseCase
import task.domain.usecase.EngineUseCase
import task.domain.usecase.impl.DoorsUseCaseImpl
import task.domain.usecase.impl.EngineUseCaseImpl


@InstallIn(SingletonComponent::class)
@Module
object UseCaseModules {

    @Provides
    fun provideDoorsUseCase(carRepository: CarRepository): DoorsUseCase =
        DoorsUseCaseImpl(carRepository)

    @Provides
    fun provideEngineUseCase(carRepository: CarRepository): EngineUseCase =
        EngineUseCaseImpl(carRepository)
}