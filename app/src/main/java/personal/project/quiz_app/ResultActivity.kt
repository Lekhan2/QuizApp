package personal.project.quiz_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName:TextView=findViewById(R.id.tv_name)
        val tvScore:TextView=findViewById(R.id.tv_score)
        val btnFinish:Button=findViewById(R.id.btn_finish)

        tvName.text=intent.getStringExtra(Constant.username)
        val totalQuestion=intent.getIntExtra(Constant.Total_Question,0)
        val correctQuestion=intent.getIntExtra(Constant.Correct_Answers,0)

        tvScore.text="Your score is ${correctQuestion} out of $totalQuestion"

        btnFinish.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }
}