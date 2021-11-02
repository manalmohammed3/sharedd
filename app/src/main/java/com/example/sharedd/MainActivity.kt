package com.example.registrationform



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sharedd.R
import com.example.sharedd.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.regButton.setOnClickListener { regeneration() }
    }


    fun regeneration() {
        val stringInTextFiled = binding.PersonName.editText?.text.toString()
        val stringInEmail = binding.EmailAddress.editText?.text.toString()
        val stringInPassword = binding.Password.editText?.text.toString()
        val stringInRePassword = binding.rePassword.editText?.text.toString()
        val stringInDataInput = binding.birthDay.editText?.text.toString()
        val gender = when (binding.radioGroup.checkedRadioButtonId) {
            R.id.radioFemale -> "Female"
            else -> "Male"
        }


        if (stringInDataInput!!.isNotEmpty() && stringInEmail.isNotEmpty() && stringInPassword.isNotEmpty()
            && stringInRePassword.isNotEmpty() && stringInDataInput.isNotEmpty()) {
            if (stringInPassword == stringInRePassword) {
                binding.output.text = "Your Info is \n " +
                        "================= \n " +
                        "Name: $stringInTextFiled  \n " +
                        "Email $stringInEmail \n" +
                        "password: $stringInPassword \n " +
                        "re_password $stringInRePassword \n" +
                        "Birth Date: $stringInDataInput \n " +
                        "Gender $gender "
            } else {
                binding.output.text = "the password not matching!!please re_enter a gain "
            }

        } else {
            binding.output.text = "fill the all the fields right"
        }
    }
}