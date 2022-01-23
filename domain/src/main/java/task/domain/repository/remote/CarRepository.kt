package task.domain.repository.remote


interface CarRepository {

    /**
     *  Functions regarding doors
     *
     *  @return [Int]
     *  0 -> success
     * -1 -> error
     */
    suspend fun lockDoors(): Int
    suspend fun unLockDoors(): Int
    suspend fun isLocked(): Boolean

    /**
     *  Function regarding engine
     *  @return [Int]
     *  0 -> success
     * -1 -> error
     */
    suspend fun startEngine(): Int
    suspend fun stopEngine(): Int
}