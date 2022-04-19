package gunixun.github.ui.utils

sealed class AppState {
    data class Success(val account: String) : AppState()
    data class Error(val error: Exception) : AppState()
    object Loading : AppState()
}