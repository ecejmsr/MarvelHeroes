package com.zensolutions.marvelheroes.data.network.retrofit

import com.zensolutions.marvelheroes.data.model.networkModel.ServiceResult
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

object RetrofitCallHandler {

    suspend fun <T> processCall(
        call: suspend () -> Response<T>
    ): ServiceResult<T> {

        return try {

            val serviceCall = call()
            val body = serviceCall.body()
            if (serviceCall.isSuccessful && body != null) {
                ServiceResult.Success(body)
            } else {
                logExceptionMessage(
                    serviceCall.code().toString(),
                    serviceCall.message().orEmpty()
                )
                returnGenericErrorMessage(
                    serviceCall.code().toString(),
                    serviceCall.errorBody().toString()
                )

                //TODO JOSE we need to make a decent exception message here
                return ServiceResult.Error(Exception())
            }
        } catch (exception: Exception) {
            when (exception) {
                is IOException -> {
                    logExceptionMessage(
                        "No Internet detected",
                        "NETWORK IS NOT CONNECTED!"
                    )
                    ServiceResult.Error(exception)
                }

                else -> {
                    logExceptionMessage(
                        "1337",
                        exception.localizedMessage ?: ""
                    )
                    ServiceResult.Error(exception)
                }
            }
        }
    }

    private fun returnGenericErrorMessage(code: String?, error: String?): String {
        return "$code: $error"
    }

    internal fun logExceptionMessage(code: String?, message: String) {
        val codedMessage = if (code == null) "" else "with code: $code"
        //TODO JOSE We need to implement timber logger here
    }
}
