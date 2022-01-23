package task.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import task.data.repository.CarRepositoryImpl
import task.domain.repository.remote.CarRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModules {

    @Provides
    @Singleton
    fun provideUserRepository(): CarRepository = CarRepositoryImpl()
}