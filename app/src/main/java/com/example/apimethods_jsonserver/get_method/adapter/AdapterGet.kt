package com.example.apimethods_jsonserver.get_method.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apimethods_jsonserver.R
import com.example.apimethods_jsonserver.get_method.model.ModelGetItem
import com.google.android.material.textview.MaterialTextView

class AdapterGet(

    private val context: Context,
    private val listUserJson: List<ModelGetItem>
) :
    RecyclerView.Adapter<AdapterGet.UserJsonViewHolder>() {

    class UserJsonViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var identification: MaterialTextView? = null
        var name: MaterialTextView? = null
        var phone: MaterialTextView? = null
        var age: MaterialTextView? = null

        init {

            identification = view.findViewById(R.id.textView_userId_componentGet_id)
            name = view.findViewById(R.id.textView_userName_componentGet_id)
            phone = view.findViewById(R.id.textView_userPhone_componentGet_id)
            age = view.findViewById(R.id.textView_userAge_componentGet_id)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserJsonViewHolder {
        val layoutInflater = LayoutInflater.from(context).inflate(
            R.layout.component_get, parent, false
        )

        val holder = UserJsonViewHolder(layoutInflater)
        LayoutInflater.from(parent.context).inflate(R.layout.component_get, parent, false)
        return holder
    }

    override fun onBindViewHolder(holder: UserJsonViewHolder, position: Int) {

        val jsonData = listUserJson[position]
        val userId = jsonData.id
        val userName = jsonData.name

        println("Id User = $userId")
        println("Name User = $userName")

        if (jsonData != null) {

            holder.identification?.text = buildString {
                append("▬▬▬ Nº IDENTIFICAÇÃO: 00")
                append(jsonData.id.toString())
                append(" ▬▬▬")
            }

            holder.name?.text = buildString {
                append("▬▬▬ NOME: ")
                append(jsonData.name.toString())
            }

            holder.phone?.text = buildString {
                append("▬▬▬ TELEFONE: ")
                append(jsonData.phone)
            }

            holder.age?.text = buildString {
                append("▬▬▬ IDADE: ")
                append(jsonData.age)
            }
        }
    }

    override fun getItemCount(): Int {

        return listUserJson.size
    }
}