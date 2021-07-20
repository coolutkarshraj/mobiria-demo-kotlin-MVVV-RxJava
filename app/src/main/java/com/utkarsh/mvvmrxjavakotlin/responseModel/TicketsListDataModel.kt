import com.google.gson.annotations.SerializedName

/*
* Data Class
* */

data class TicketsListDataModel (

	@SerializedName("campaigns_id") val campaigns_id : String,
	@SerializedName("campaigns_end_date") val campaigns_end_date : String,
	@SerializedName("campaigns_remaining_uts") val campaigns_remaining_uts : String,
	@SerializedName("campaigns_desc") val campaigns_desc : String,
	@SerializedName("campaigns_title") val campaigns_title : String,
	@SerializedName("campaigns_image") val campaigns_image : String,
	@SerializedName("campaigns_status") val campaigns_status : String,
	@SerializedName("product_id") val product_id : String,
	@SerializedName("product_name") val product_name : String,
	@SerializedName("product_desc") val product_desc : String,
	@SerializedName("product_desc_short") val product_desc_short : String,
	@SerializedName("product_image") val product_image : String,
	@SerializedName("product_images") val product_images : ArrayList<String>,
	@SerializedName("m_product_image") val m_product_image : String,
	@SerializedName("is_favourite") val is_favourite : String,
	@SerializedName("product_attrb_id") val product_attrb_id : String,
	@SerializedName("sale_price") val sale_price : String,
	@SerializedName("regular_price") val regular_price : String,
	@SerializedName("product_order_total_price") val product_order_total_price : String,
	@SerializedName("product_order_unit_price") val product_order_unit_price : String,
	@SerializedName("order_is_donation") val order_is_donation : String,
	@SerializedName("order_id") val order_id : String,
	@SerializedName("order_grand_total") val order_grand_total : Double,
	@SerializedName("order_tax_total") val order_tax_total : Double,
	@SerializedName("order_shipping_charge") val order_shipping_charge : String,
	@SerializedName("draw_date") val draw_date : String,
	@SerializedName("won_user_name") val won_user_name : String,
	@SerializedName("won_user_image") val won_user_image : String,
	@SerializedName("won_ticket_number") val won_ticket_number : String,
	@SerializedName("is_user_won_campaign") val is_user_won_campaign : String,
	@SerializedName("ticket_number") val ticket_number : String
)