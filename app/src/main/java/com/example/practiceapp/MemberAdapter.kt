package com.example.repcard_task_2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.practiceapp.R
import com.example.practiceapp.Recycleinterface
import com.example.repcard_task_2.model.MemebersPojo

class MemberAdapter(private val context: Context, private val memberList: List<MemebersPojo>,private val clickRecycle:Recycleinterface) :
    RecyclerView.Adapter<MemberAdapter.viewHolder>() {


    class viewHolder(iteam: View) : RecyclerView.ViewHolder(iteam) {

        val checkMember = iteam.findViewById<CheckBox>(R.id.ischeck_member)
        val member_img = iteam.findViewById<ImageView>(R.id.memeberImage)
        val username = iteam.findViewById<TextView>(R.id.userName)
        val userjob = iteam.findViewById<TextView>(R.id.userTitle)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_members, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return memberList.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.checkMember.setOnClickListener {
//            for(i in 0..memberList.size)
//            {
//                if(memberList.size==count)
//                {
//
//
//                }
//                else
//                {
                 //   clickRecycle.OnRecycleItemClik(0,0,position)
//                }
//            }


        }
        if (memberList[position].ismemberchecked) {
            holder.checkMember.isChecked = true
        } else {
            holder.checkMember.isChecked = false
        }
        holder.username.text = memberList[position].title
        holder.userjob.text =  memberList[position].type

        Glide.with(context)
            .load(memberList[position].image)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.dog)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(holder.member_img)


    }


}