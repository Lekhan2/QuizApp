package personal.project.quiz_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etbtn:EditText=findViewById(R.id.et_btn)
        val btnStart:Button=findViewById(R.id.btn_start)

        btnStart.setOnClickListener{
            if (etbtn.text.isEmpty()){
                Toast.makeText(this,"Please enter the name",Toast.LENGTH_LONG).show()
            }
            else{
                val intent=Intent(this,QuizQuestion::class.java)
                intent.putExtra(Constant.username,etbtn.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}