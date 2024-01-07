package com.dc.demo.models

import com.google.gson.annotations.SerializedName

data class CategoryResponse(

	@field:SerializedName("categories")
	val categories: List<CategoriesItem?>? = null,

	@field:SerializedName("banner_image")
	val bannerImage: String? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class CategoriesItem(

	@field:SerializedName("category_name")
	val categoryName: String? = null,

	@field:SerializedName("category_id")
	val categoryId: String? = null,

	@field:SerializedName("parent_id")
	val parentId: String? = null,

	@field:SerializedName("child")
	val child: List<ChildItem?>? = null
)

data class ChildItem(

	@field:SerializedName("category_name")
	val categoryName: String? = null,

	@field:SerializedName("category_id")
	val categoryId: String? = null,

	@field:SerializedName("parent_id")
	val parentId: String? = null
)
