package br.com.portfolioapp.data.model

sealed class ApiResult<T> {
    class Success<T>(val data: T) : ApiResult<T>()
    class Fail<T>(val error: String?) : ApiResult<T>()
    class Loading<T>(val isLoading: Boolean) : ApiResult<T>()
}