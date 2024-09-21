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
import com.example.repcard_task_2.model.CompanyPojoItem

class OfficeAdapter(private val context: Context, private val companyList: List<CompanyPojoItem>,
    private val clickListner:Recycleinterface) :
    RecyclerView.Adapter<OfficeAdapter.viewHolder>() {

//    var isdown: Boolean = false

    class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerview_team = itemView.findViewById<RecyclerView>(R.id.recyclerview_Team)
        val checkbox = itemView.findViewById<CheckBox>(R.id.ischeck_company)
        val companyname = itemView.findViewById<TextView>(R.id.Company_nametxt)
//        val downImg = itemView.findViewById<ImageView>(R.id.company_downarrow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        return viewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_company, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return companyList.size
    }

    override fun onBindViewHolder(holder: viewHolder, @SuppressLint("RecyclerView") position: Int) {

        holder.companyname.text = companyList[position].title
//        holder.recyclerview_team.visibility = View.GONE
        val adapter = TeamAdapter(context, companyList[position].items,object :Recycleinterface{
            override fun OnRecycleItemClik(
                officePosition: Int,
                teamPosition: Int,
                memberPosition: Int
            ) {
                clickListner.OnRecycleItemClik(position,teamPosition,0)
            }

        })
        holder.recyclerview_team.adapter = adapter
//        holder.downImg.setOnClickListener {
//            isdown = !isdown
//            if (isdown) {
//                holder.recyclerview_team.visibility = View.GONE
//            } else {
//                holder.recyclerview_team.visibility = View.VISIBLE
//            }
//
//        }

        holder.checkbox.setOnClickListener {
            clickListner.OnRecycleItemClik(position,0,0)

        }
    }
}