package uz.itschool.phone.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import uz.itschool.phone.R
import uz.itschool.phone.adapter.ContactRecyclerAdapter
import uz.itschool.phone.database.AppDatabase
import uz.itschool.phone.databinding.FragmentContactBinding

class ContactFragment : Fragment() {
    val appDatabase = AppDatabase.getInstance(requireContext())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentContactBinding.inflate(inflater, container, false)
        val adapter = ContactRecyclerAdapter(appDatabase, object : ContactRecyclerAdapter.OnCall{
            override fun call(number: String) {
                // TODO: CALL
            }
        })
        binding.contactRecycler.adapter = adapter
        binding.contactAddButton.setOnClickListener {
            findNavController().navigate(R.id.action_bodyFragment_to_addContactFragment)
        }
        return binding.root
    }

}