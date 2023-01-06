package br.com.fundatec.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import br.com.fundatec.R
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val image = findViewById<ImageView>(R.id.iv_home)
//        Glide
//            .with(this)
//            .load("https://www.crunchyroll.com/imgsrv/display/thumbnail/1200x675/catalog/crunchyroll/36bdc5ea4443cd8e42f22ec7d3884cbb.jpe")
//            .into(image)

        Picasso
            .get()
            .load("https://static.wikia.nocookie.net/infinitas-guerras/images/4/4f/647552.jpg/revision/latest?cb=20161011200149&path-prefix=pt-br")
            .resize(50,50)
            .centerCrop()
            .into(image)
    }
}