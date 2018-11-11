package a170560u.it2107.nyp.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnValidate(v: View) {

        var editTextNumber: Int= etNumBiggerThan25.text.toString().toInt()

        if(editTextNumber <= 25) {

            etNumBiggerThan25.setError("Number is less or equal 25")
        }
    }
}
