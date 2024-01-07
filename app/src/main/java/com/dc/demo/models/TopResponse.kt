package com.dc.demo.models

import com.google.gson.annotations.SerializedName

data class TopResponse(

	@field:SerializedName("main_sticky_menu")
	val mainStickyMenu: List<MainStickyMenuItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class SliderImagesItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("cta")
	val cta: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("sort_order")
	val sortOrder: String? = null
)

data class MainStickyMenuItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("sort_order")
	val sortOrder: String? = null,

	@field:SerializedName("slider_images")
	val sliderImages: List<SliderImagesItem?>? = null
)
