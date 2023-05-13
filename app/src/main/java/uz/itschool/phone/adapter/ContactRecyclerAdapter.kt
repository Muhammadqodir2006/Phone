package uz.itschool.phone.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.itschool.phone.R
import uz.itschool.phone.database.AppDatabase

class ContactRecyclerAdapter(val appDatabase: AppDatabase, val onCall: OnCall): RecyclerView.Adapter<ContactRecyclerAdapter.ViewHolder>() {
    val contactList = appDatabase.getContactDao().getAllContacts()
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val ism = itemView.findViewById<TextView>(R.id.item_ism_familiya)
        val raqam = itemView.findViewById<TextView>(R.id.item_raqam)
        val button = itemView.findViewById<FloatingActionButton>(R.id.item_call)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false).rootView)
    }

    override fun getItemCount(): Int {
        return appDatabase.getContactDao().getAllContacts().size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = contactList[position]
        holder.ism.text = item.firstName + " " + item.lastName
        holder.raqam.text = "+${item.number}"

        holder.button.setOnClickListener {
            onCall.call(item.number)
        }
    }
    interface OnCall{
        fun call(number:String)
    }
}