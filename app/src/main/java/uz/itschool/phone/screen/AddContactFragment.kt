package uz.itschool.phone.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import uz.itschool.phone.R
import uz.itschool.phone.database.AppDatabase
import uz.itschool.phone.database.entity.Contact
import uz.itschool.phone.databinding.FragmentAddContactBinding
import java.time.Duration

class AddContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val appDatabase = AppDatabase.getInstance(requireContext())
        val contacts = appDatabase.getContactDao().getAllContacts()
        val binding = FragmentAddContactBinding.inflate(inflater, container, false)

        binding.addButton.setOnClickListener {
            val number = binding.addNumber.text.toString()
            val firstName = binding.addFirstName.text.toString()
            val lastName = binding.addLastName.text.toString()

            if (number.length != 12 || firstName == ""){
                return@setOnClickListener
            }

            for (i in contacts){
                if (i.number == number){
                    Toast.makeText(requireContext(), "Kontakt mavjud", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
            }
            appDatabase.getContactDao().addContact(Contact(firstName =  firstName, lastName =   lastName,  number = number))
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        return binding.root
    }
}