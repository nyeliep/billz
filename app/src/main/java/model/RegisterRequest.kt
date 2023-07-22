package model
import com.google.gson.annotations.SerializedName
import android.provider.ContactsContract.CommonDataKinds.Email

data class RegisterRequest(
    @SerializedName("first_name")var firstName: String,
    @SerializedName("last_name")var lastName: String,
    @SerializedName("phone_number")var phoneNumber: String,
    @SerializedName("user_id")var userId:String,
    var email: String,
)
