package a170560u.it2107.nyp.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_display_details.*
import android.content.Intent
import android.graphics.Movie
import android.os.Handler
import android.widget.Toast


class MovieDisplayDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_display_details)


        val movie = intent.extras.get("key") as MovieData
        val suitable_bool: String

        titleID.text = movie.title
        overviewID.text = movie.desc
        languageID.text = movie.language
        dateID.text = movie.date

        if(movie.suitable == "true")
            suitable_bool = "No"
        else
            suitable_bool = "Yes"

        suitableID.text = suitable_bool

        Handler().postDelayed({
            val i = Intent(this, MovieRate_stars::class.java)
            i.putExtra("singleTitle", movie)
            startActivity(i)
        }, 5000)
    }
}
