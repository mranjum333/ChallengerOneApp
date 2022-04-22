package com.android.challengeroneapp.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso


@BindingAdapter("text")
fun TextView.setDefaultText(text: Int) {
    this.text = this.resources.getText(text)
}

@BindingAdapter("imageUrl")
fun ImageView.setImage(imageUrl: String) {
    Picasso.get().load(imageUrl).into(this)
}

@BindingAdapter("imageUrl")
fun ImageView.setImage(imageId: Int) {
    this.setImageDrawable(resources.getDrawable(imageId, null))
}