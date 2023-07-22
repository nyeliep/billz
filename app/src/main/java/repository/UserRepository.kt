package repository

import api.ApiClient
import api.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import model.RegisterRequest
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildClient(ApiInterface::class.java)
    
    suspend fun registerUser(registerRequest: RegisterRequest): Response<RegisterRequest>{
        return withContext(Dispatchers.IO){
            apiClient.registerUser((registerRequest))
        }
    }
}
  