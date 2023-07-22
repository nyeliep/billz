package api

import model.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/users/register")
    fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterRequest>
}