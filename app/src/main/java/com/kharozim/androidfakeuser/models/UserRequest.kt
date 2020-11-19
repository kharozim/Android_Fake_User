package com.kharozim.androidfakeuser.models

import com.google.gson.annotations.SerializedName

data class UserRequest(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("job")
	val job: String
)
