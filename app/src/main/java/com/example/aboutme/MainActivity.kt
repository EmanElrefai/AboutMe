package com.example.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.aboutme.MyName
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("Eman Lotfy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        setContentView(R.layout.activity_main)
        binding.doneButton.setOnClickListener{
            addNickname(it)

        }

    }

 private fun addNickname(view:View){
     val editText =findViewById<EditText>(R.id.nickname_edit)
     val nicknameTextView =findViewById<TextView>(R.id.nickname_text)

   binding.apply{
       nicknameTextView.text=binding.nicknameEdit.text
       invalidateAll()
       editText.visibility=View.GONE
       view.visibility=View.GONE
       nicknameTextView.visibility=View.VISIBLE

   }



     // Hide the keyboard.
     val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
     imm.hideSoftInputFromWindow(view.windowToken, 0)


 }

}
