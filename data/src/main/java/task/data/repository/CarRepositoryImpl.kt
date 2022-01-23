package task.data.repository

import kotlinx.coroutines.suspendCancellableCoroutine
import task.domain.repository.remote.CarRepository
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class CarRepositoryImpl @Inject constructor() : CarRepository {
    private var isLocked: Boolean = false

    override suspend fun lockDoors(): Int = suspendCancellableCoroutine {
        return@suspendCancellableCoroutine try {
            val successResponse = 0
            isLocked = true
            it.resume(successResponse)
        } catch (error: Exception) {
            error.printStackTrace()
            it.resumeWithException(error)
        }
    }

    override suspend fun unLockDoors(): Int = suspendCancellableCoroutine {
        return@suspendCancellableCoroutine try {
            val successResponse = 0
            isLocked = false
            it.resume(successResponse)
        } catch (error: Exception) {
            error.printStackTrace()
            it.resumeWithException(error)
        }
    }

    override suspend fun isLocked(): Boolean = suspendCancellableCoroutine {
        return@suspendCancellableCoroutine try {
            it.resume(isLocked)
        } catch (error: Exception) {
            error.printStackTrace()
            it.resumeWithException(error)
        }
    }

    override suspend fun startEngine(): Int = suspendCancellableCoroutine {
        try {

        } catch (error: Exception) {

        }
    }

    override suspend fun stopEngine(): Int = suspendCancellableCoroutine {
        try {

        } catch (error: Exception) {

        }
    }

}