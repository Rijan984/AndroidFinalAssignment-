package com.rijan.rijanshrestha_jobfinder.user

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rijan.rijanshrestha_jobfinder.Model.User
import com.rijan.rijanshrestha_jobfinder.R
import org.w3c.dom.Text

class PostAdapter (
    private val data: ArrayList<User>,
    private val context: Context

): RecyclerView.Adapter<PostAdapter.PostViewholder>() {
    class PostViewholder(val view: View) : RecyclerView.ViewHolder(view) {
        val address: TextView
        val username: TextView
        val email: TextView
        val phone: TextView
        val title: TextView
        init{
            title=view.findViewById(R.id.postAuthor)
            username=view.findViewById(R.id.postedUser)
            address=view.findViewById(R.id.postedaddress)
            email=view.findViewById(R.id.postedemail)
            phone=view.findViewById(R.id.postedphone)
        }


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewholder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_user_lists, parent, false)
        return PostViewholder(view)
    }

    override fun onBindViewHolder(holder: PostViewholder, position: Int) {
        //   holder.bind(listStudent.get(position), position)
        val post = data[position]
        print(post)
        holder.title.text = post.fname
        holder.username.text = post.username
        holder.address.text = post.address
        holder.email.text = post.email
        holder.phone.text = post.phone

    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun deleteItem(index: Int) {
        notifyDataSetChanged()
    }



}