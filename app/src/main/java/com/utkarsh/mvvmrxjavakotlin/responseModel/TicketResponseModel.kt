import com.google.gson.annotations.SerializedName

/*
* Data Class
* */
data class TicketResponseModel (

	@SerializedName("status") val status : String,
	@SerializedName("message") val message : String,
	@SerializedName("oData") val oData : ODataModel
)