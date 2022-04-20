package gunixun.github.utils

interface CallbackData<T> {

    fun onSuccess(result: T)

    fun onError(error: Exception)

}