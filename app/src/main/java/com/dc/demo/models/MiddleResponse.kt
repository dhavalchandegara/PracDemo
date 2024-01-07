package com.dc.demo.models

import com.google.gson.annotations.SerializedName

data class MiddleResponse(

	@field:SerializedName("shop_by_fabric")
	val shopByFabric: List<ShopByFabricItem?>? = null,

	@field:SerializedName("shop_by_category")
	val shopByCategory: List<ShopByCategoryItem?>? = null,

	@field:SerializedName("Unstitched")
	val unstitched: List<UnstitchedItem?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("boutique_collection")
	val boutiqueCollection: List<BoutiqueCollectionItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class ShopByFabricItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("fabric_id")
	val fabricId: String? = null,

	@field:SerializedName("category_id")
	val categoryId: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("sort_order")
	val sortOrder: String? = null,

	@field:SerializedName("tint_color")
	val tintColor: String? = null
)

data class BoutiqueCollectionItem(

	@field:SerializedName("cta")
	val cta: String? = null,

	@field:SerializedName("banner_id")
	val bannerId: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("banner_image")
	val bannerImage: String? = null
)

data class ShopByCategoryItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("category_id")
	val categoryId: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("sort_order")
	val sortOrder: String? = null,

	@field:SerializedName("tint_color")
	val tintColor: String? = null
)

data class UnstitchedItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("range_id")
	val rangeId: String? = null
)
