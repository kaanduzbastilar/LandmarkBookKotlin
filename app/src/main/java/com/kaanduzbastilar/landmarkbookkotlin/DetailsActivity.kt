package com.kaanduzbastilar.landmarkbookkotlin

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kaanduzbastilar.landmarkbookkotlin.databinding.ActivityDetailsBinding

private lateinit var binding: ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val intent = intent
        //casting
        /*
        val selectedLandmark = if(Build.VERSION.SDK_INT >= 33){
            intent.getSerializableExtra("landmark", Landmark::class.java)!!}
        else{
                intent.getSerializableExtra("landmark") as Landmark
        }
         */

        val selectedLandmark = MySingleton.chosenLandmark

        selectedLandmark?.let {
            binding.nameText.text = it.name
            binding.countryText.text = it.country
            binding.imageView.setImageResource(it.image)
        }



    }
}