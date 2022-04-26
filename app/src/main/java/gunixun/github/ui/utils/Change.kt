package gunixun.github.ui.utils

data class Change<out T> (
    val oldData: T,
    val newData: T
)

fun <T> createCombinePayloads(payloads: List<Change<T>>): Change<T>{
    val firs = payloads.first()
    val last = payloads.last()
    return Change(firs.oldData, last.newData)
}