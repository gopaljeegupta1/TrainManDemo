package com.hilt.demo.view

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.hilt.demo.R

//@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {

    var tvId: TextView? = null
    var tvName: TextView? = null
    var tvUrl: TextView? = null
    lateinit var imImgUrl: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout_details)

        val bundle = intent.extras

        tvId = findViewById(R.id.tv_id)
        tvName = findViewById(R.id.tv_name)
        tvUrl = findViewById(R.id.tv_url)
        imImgUrl = findViewById(R.id.im_imgUrl)


        tvId?.setText(bundle!!.getString("id", "No value :("))
        tvName?.setText(bundle!!.getString("username", "No value :("))
        tvUrl?.setText(bundle!!.getString("url", "No value :("))

        val imgUrl = bundle!!.getString("imgUrl", "No value :(")
        Glide.with(this)
            .load(imgUrl)
            .placeholder(R.drawable.loading_image)
            .into(imImgUrl)
    }


}


