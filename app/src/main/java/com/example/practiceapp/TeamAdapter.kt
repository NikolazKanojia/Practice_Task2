package com.example.repcard_task_2

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practiceapp.R
import com.example.practiceapp.Recycleinterface
import com.example.repcard_task_2.model.TeamPojo

class TeamAdapter(private val context: Context, private val TeamList: List<TeamPojo>,private val clickRecycle:Recycleinterface) :
    RecyclerView.Adapter<TeamAdapter.viewHolder>() {
    var isdown: Boolean = false

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkboxoffice = itemView.findViewById<CheckBox>(R.id.ischeckoffice)
        val officename = itemView.findViewById<TextView>(R.id.officeName)
        val officedownImg = itemView.findViewById<ImageView>(R.id.office_downarrow)
        var memberrecyclerview = itemView.findViewById<RecyclerView>(R.id.member_recyclerview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_office, parent, false))
    }

    override fun getItemCount(): Int {
        return TeamList.size
    }

    override fun onBindViewHolder(holder: viewHolder, @SuppressLint("RecyclerView") position: Int) {
        val adapter = MemberAdapter(context, TeamList[position].items,object :Recycleinterface{
            override fun OnRecycleItemClik(
                officePosition: Int,
                teamPosition: Int,
                memberPosition: Int
            ) {
                clickRecycle.OnRecycleItemClik(0,position,memberPosition)
            }

        })
//        holder.memberrecyclerview.visibility = View.GONE
        holder.memberrecyclerview.adapter = adapter
        holder.officename.text = TeamList[position].title
        if (TeamList[position].ischeckedteam) {
            holder.checkboxoffice.isChecked = true
        } else {
            holder.checkboxoffice.isChecked = false
        }
//        holder.officedownImg.setOnClickListener {
//            isdown = !isdown
//            if (isdown) {
//                holder.memberrecyclerview.visibility = View.VISIBLE
//            } else {
//                holder.memberrecyclerview.visibility = View.GONE
//            }
//        }
        holder.checkboxoffice.setOnClickListener {
          //  TeamList[position].ischeckedteam = !TeamList[position].ischeckedteam
            clickRecycle.OnRecycleItemClik(0,position,0)

        }

    }
}