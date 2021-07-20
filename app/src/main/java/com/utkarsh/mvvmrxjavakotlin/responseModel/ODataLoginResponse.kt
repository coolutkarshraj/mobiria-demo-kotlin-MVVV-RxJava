import com.google.gson.annotations.SerializedName

/*
Copyright (c) 2021 Kotlin Data Classes Generated from JSON powered by http://www.json2kotlin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

For support, please feel free to contact me at https://www.linkedin.com/in/syedabsar */


data class ODataLoginResponse (

	@SerializedName("user_full_name") val user_full_name : String,
	@SerializedName("user_email") val user_email : String,
	@SerializedName("user_type") val user_type : String,
	@SerializedName("user_image") val user_image : String,
	@SerializedName("login_type") val login_type : String,
	@SerializedName("user_country_id") val user_country_id : String,
	@SerializedName("country_name") val country_name : String,
	@SerializedName("referal_code") val referal_code : String,
	@SerializedName("dial_code") val dial_code : String,
	@SerializedName("phone_number") val phone_number : String,
	@SerializedName("firebase_user_key") val firebase_user_firebase_user_key : String,
	@SerializedName("poStrings") val poStrings : String
)