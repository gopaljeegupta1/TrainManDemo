package com.hilt.demo.model

data class Images (

	val original : Original,
	val downsized : Downsized,
	val downsized_large : Downsized_large,
	val downsized_medium : Downsized_medium,
	val downsized_small : Downsized_small,
	val downsized_still : Downsized_still,
	val fixed_height : Fixed_height,
	val fixed_height_downsampled : Fixed_height_downsampled,
	val fixed_height_small : Fixed_height_small,
	val fixed_height_small_still : Fixed_height_small_still,
	val fixed_height_still : Fixed_height_still,
	val fixed_width : Fixed_width,
	val fixed_width_downsampled : Fixed_width_downsampled,
	val fixed_width_small : Fixed_width_small,
	val fixed_width_small_still : Fixed_width_small_still,
	val fixed_width_still : Fixed_width_still,
	val looping : Looping,
	val original_still : Original_still,
	val original_mp4 : Original_mp4,
	val preview : Preview,
	val preview_gif : Preview_gif,
	val preview_webp : Preview_webp
//	val 480w_still : 480w_still
)