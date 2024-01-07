package com.dc.demo.models

import com.google.gson.annotations.SerializedName

data class BottomResponse(

	@field:SerializedName("design_occasion")
	val designOccasion: List<DesignOccasionItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("range_of_pattern")
	val rangeOfPattern: List<RangeOfPatternItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class DesignOccasionItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("cta")
	val cta: String? = null,

	@field:SerializedName("sub_name")
	val subName: String? = null,

	@field:SerializedName("product_id")
	val productId: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)

data class RangeOfPatternItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("product_id")
	val productId: String? = null,

	@field:SerializedName("name")
	val name: String? = null
)
