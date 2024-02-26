package com.rodricorgom.modulo4practicafinal

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.rodricorgom.modulo4practicafinal.databinding.FragmentSignUpBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM_EMAIL = "email"
private const val ARG_PARAM_PASS = "password"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSignUp.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentSignUp : Fragment() {
    private lateinit var binding : FragmentSignUpBinding
    // TODO: Rename and c SignUpFragmenthange types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM_EMAIL)
            param2 = it.getString(ARG_PARAM_PASS)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.emailTxt.setText(param1)
        binding.passwordTxt.setText(param2)

        val registerBtn = binding.registroBtn

        val sendUserIntent = Intent(requireContext(),getInfoActivity::class.java)

        var correo = binding.emailTxt.text
        var password = binding.passwordTxt.text
        var nombre = binding.nombreTxt.text
        var apellido = binding.apellidoTxt.text
        var genero = binding.radioGroup


        registerBtn.setOnClickListener{
            var genderId = genero.checkedRadioButtonId
            val radioButton: RadioButton = binding.root.findViewById(genderId)
            val radioButtonText = radioButton.text
            var user = Usuario(correo.toString(),password.toString(),nombre.toString(),apellido.toString(),radioButtonText.toString())
            val dataIntent = sendUserIntent.apply{
                putExtra("EXTRA_EMAIL",user.email)
                putExtra("EXTRA_PASSWORD",user.password)
                putExtra("EXTRA_NAME",user.name)
                putExtra("EXTRA_SURNAME",user.surname)
                putExtra("EXTRA_GENDER",user.gender)
            }
            startActivity(dataIntent)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignUpFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentSignUp().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_EMAIL, param1)
                    putString(ARG_PARAM_PASS, param2)
                }
            }
    }
}