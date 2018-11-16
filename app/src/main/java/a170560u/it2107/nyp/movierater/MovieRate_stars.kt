package a170560u.it2107.nyp.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_rate_stars.*

class MovieRate_stars : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rate_stars)

        val reuse = intent.extras.get("singleTitle") as MovieData

        val text_title_final = reuse.title
        ratingID.text = "Enter your review for the movie: " +text_title_final
    }
}
