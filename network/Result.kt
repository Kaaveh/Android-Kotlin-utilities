sealed class Result<T>(
    val data: T? = null,
    val exception: Exception? = null,
) {
    class Success<T>(data: T) : Result<T>(data)
    class Error<T>(exception: Exception, data: T? = null) : Result<T>(data, exception)
}
