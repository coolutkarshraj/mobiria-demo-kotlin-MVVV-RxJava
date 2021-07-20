import com.google.gson.annotations.SerializedName
/*
* Data Class
* */
data class CategoriesDataModel (

	@SerializedName("category_id") val category_id : String,
	@SerializedName("category_name") val category_name : String
)