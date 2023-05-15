package uz.itschool.phone.screen

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uz.itschool.phone.R
import uz.itschool.phone.adapter.ContactRecyclerAdapter
import uz.itschool.phone.database.AppDatabase
import uz.itschool.phone.databinding.FragmentContactBinding

class ContactFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        checkPermission()

        val appDatabase = AppDatabase.getInstance(requireContext())
        val binding = FragmentContactBinding.inflate(inflater, container, false)
        val adapter = ContactRecyclerAdapter(appDatabase, object : ContactRecyclerAdapter.OnCall{
            override fun call(number: String) {
                val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:+$number"))
                startActivity(intent)
            }
        })
        binding.contactRecycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.contactRecycler.adapter = adapter
        binding.contactAddButton.setOnClickListener {
            findNavController().navigate(R.id.action_bodyFragment_to_addContactFragment)
        }
        return binding.root
    }

    private fun checkPermission() {
        if (ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.CALL_PHONE), 101)
        }
    }

}