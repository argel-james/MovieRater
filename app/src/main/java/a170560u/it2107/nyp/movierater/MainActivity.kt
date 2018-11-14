package a170560u.it2107.nyp.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkBoxFirst = findViewById<CheckBox>(R.id.checkbox1)
        val checkBoxSecond = findViewById<CheckBox>(R.id.checkbox2)
        val checkBoxThird = findViewById<CheckBox>(R.id.checkbox3)

        val btnClicked = findViewById(R.id.btnIdentify) as Button
        val titleValid = findViewById(R.id.title) as EditText
        val descValid = findViewById(R.id.desc) as EditText
        val dateValid = findViewById(R.id.date) as EditText
        val radioAnswer = findViewById(R.id.radioResults) as RadioGroup
        var language_buffer: String = ""
        var checkbox_rating_buffer: String = "false"
        val reason_array = arrayListOf<String>()

        btnClicked.setOnClickListener {
            val titleStr: String = titleValid.text.toString()
            val descStr: String = descValid.text.toString()
            val dateStr: String = dateValid.text.toString()
            val radioStr: Int = radioAnswer.checkedRadioButtonId


            checkBoxFirst?.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    checkBoxSecond.setVisibility(View.VISIBLE)
                    checkBoxThird.setVisibility(View.VISIBLE)
                    checkbox_rating_buffer = "true"

                    checkBoxSecond?.setOnCheckedChangeListener { buttonView2, isChecked2 ->
                        if(isChecked2) {
                            reason_array.add("Violence")
                        }
                        else {
                            reason_array.remove("Violence")
                        }

                    }

                    checkBoxThird?.setOnCheckedChangeListener { buttonView3, isChecked3 ->
                        if(isChecked3) {
                            reason_array.add("Language")
                        }
                        else {
                            reason_array.remove("Language")
                        }

                    }
                } else {
                    checkBoxSecond.setVisibility(View.INVISIBLE)
                    checkBoxThird.setVisibility(View.INVISIBLE)
                    checkbox_rating_buffer = "false"
                }
            }


            //Converting languages to string(fromt Int)
            if(radioStr == 2131230847)
                language_buffer = "English"
            else if(radioStr == 2131230848)
                language_buffer = "Chinese"
            else if(radioStr == 2131230849)
                language_buffer = "Malay"
            else if(radioStr == 2131230890)
                language_buffer = "Tamil"

            if (titleStr.isEmpty()) {
                titleValid.setError("Please enter movie title!")

                if (descStr.isEmpty()) {
                    descValid.setError("Please enter movie description!")

                    if (dateStr.isEmpty()) {
                        dateValid.setError("Field empty")
                    }
                }
            } else {
                if (descStr.isEmpty()) {
                    descValid.setError("Please enter movie description!")

                    if (dateStr.isEmpty()) {
                        dateValid.setError("Field empty")
                    }
                } else {
                    if (dateStr.isEmpty()) {
                        dateValid.setError("Field empty")
                    } else {
                        //return values
                        Toast.makeText(applicationContext, "Title = "+titleStr
                            +"\n" + "Overview ="+descStr + "\n" + "Release date = " +dateStr
                            +"\n" + "Language = "+radioStr + "\n" + "Suitable for all ages = " +checkbox_rating_buffer
                            +"\nReason: \n" +reason_array.joinToString(separator="\n"), Toast.LENGTH_SHORT).show()


                        val obj = MovieData(titleStr, descStr, language_buffer, dateStr, checkbox_rating_buffer)
                        val intent = Intent(this, MovieDisplayDetails::class.java)
                        intent.putExtra("key", obj)
                        startActivity(intent)
                    }
                }


            }



            }






        }
    }
