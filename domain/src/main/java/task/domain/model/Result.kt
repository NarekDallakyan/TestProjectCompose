package task.domain.model

/**
 * A generic class that holds a value or an error status.
 * @param <T>
 */
sealed class Result<out T : Any> {

    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Failure(val stateError: Any, val identifier: Any? = null) : Result<Nothing>()
    class Loading<T : Any> : Result<T>()
    data class Non(val identifier: Any? = null) : Result<Nothing>()


    companion object {
        /**
         * Returns [Result.Success] instance.
         * @param data Data to emit with status.
         */
        fun <T : Any> success(data: T) = Success(data)

        /**
         * Returns [Error] instance.
         * @param errorBody Description of failure.
         */
        fun error(errorBody: Any, identifier: Any? = null) =
            Failure(errorBody, identifier)
    }
}