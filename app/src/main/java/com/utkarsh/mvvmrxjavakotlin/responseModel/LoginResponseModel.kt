import com.google.gson.annotations.SerializedName


data class LoginResponseModel (

	@SerializedName("status") val status : String,
	@SerializedName("message") val message : String,
	@SerializedName("accessToken") val accessToken : String,
	@SerializedName("oData") val oData : ODataLoginResponse
)