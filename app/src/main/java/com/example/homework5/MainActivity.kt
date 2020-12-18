package com.example.homework5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var inputEmailEditText: EditText
    private lateinit var inputPasswordEditText: EditText
    private lateinit var submitButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        inputEmailEditText = findViewById(R.id.inputEmailEditText)
        inputPasswordEditText = findViewById(R.id.inputPasswordEditText)
        submitButton = findViewById(R.id.submitButton)


        submitButton.setOnClickListener {
            val email = inputEmailEditText.text.toString()
            val password = inputPasswordEditText.text.toString()
            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "ერთ-ერთი ველი ცარიელია", Toast.LENGTH_LONG).show()
            }else{
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task->
                    if (task.isSuccessful){
                        Toast.makeText(this, "წარმატებით გაიარეთ აუთენთიფიკაცია", Toast.LENGTH_LONG).show()
                    } else{
                        Toast.makeText(this, "რაღაც არასწორია, სცადეთ ხელახლა", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

    }
}