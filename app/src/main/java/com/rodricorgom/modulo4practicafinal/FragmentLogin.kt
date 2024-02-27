package com.rodricorgom.modulo4practicafinal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.rodricorgom.modulo4practicafinal.databinding.FragmentLoginBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "EMAIL"
private const val ARG_PARAM2 = "PASSWORD"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentLogin.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentLogin : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var mail = binding.textEmail.text
        var pass = binding.textPassword.text
        binding.buttonSignIn.setOnClickListener{
            if(mail.isNotBlank() && pass.isNotBlank())
            {
                Log.println(Log.INFO,null,"User and mail set")
                val user = Usuario(mail.toString(),pass.toString())
                val signInIntent = Intent(requireContext(),getInfoActivity::class.java).apply{
                    putExtra("EXTRA_EMAIL",user.email)
                    putExtra("EXTRA_PASSWORD",user.password)
                    putExtra("EXTRA_TYPE","USER_LOGIN")
                }
                startActivity(signInIntent)
            }

            else
            {
                if(mail.isNullOrBlank())
                {
                    Toast.makeText(requireContext(),"Email can not be empty",Toast.LENGTH_SHORT).show()
                }
                if(pass.isBlank())
                {
                    Toast.makeText(requireContext(),"Password can not be empty",Toast.LENGTH_SHORT).show()

                }
            }
        }
        binding.registerText.setOnClickListener{
            val user = Usuario(mail.toString(),pass.toString())
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,FragmentSignUp.newInstance(user.email,user.password))
                .addToBackStack("FragmentSignUp")
                .commit()
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            FragmentLogin()
    }
}