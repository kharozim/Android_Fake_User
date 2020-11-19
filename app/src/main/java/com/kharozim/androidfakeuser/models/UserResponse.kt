package com.kharozim.androidfakeuser.models

import com.google.gson.annotations.SerializedName

data class UserResponse(

	@field:SerializedName("createdAt")
	val createdAt: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("job")
	val job: String
)
