import com.google.gson.annotations.SerializedName

/*
* Data Class
* */
data class ODataModel (

	@SerializedName("ticketsList") val ticketsList : ArrayList<TicketsListDataModel>,
	@SerializedName("categories") val categories : ArrayList<CategoriesDataModel>
)