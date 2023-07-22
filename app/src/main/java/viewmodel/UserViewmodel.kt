package viewmodel


import android.annotation.SuppressLint
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.launch
import model.RegisterRequest
import repository.UserRepository

class UserViewmodel: ViewModel() {
    val userRepo = UserRepository()
    val regLiveData = MutableLiveData<RegisterRequest>()
    val errLiveData = MutableLiveData<String>()

    @SuppressLint("SuspiciousIndentation")
    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch{
            val response = userRepo.registerUser(registerRequest)
              if(response.isSuccessful){
                  regLiveData.postValue((response.body()))
              }
            else{
                errLiveData.postValue(response.errorBody()?.string())
              }
        }
    }
}