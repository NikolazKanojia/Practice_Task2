package com.example.practiceapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.repcard_task_2.OfficeAdapter
import com.example.repcard_task_2.model.OfficePojo
import com.google.gson.Gson


class MainActivityJson : AppCompatActivity() {

    var adapter: OfficeAdapter? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var json: String? = null
        val inputStream = assets.open("Heirarchy.json")
        json = inputStream.bufferedReader().use { it.readText() }
        val officedata = Gson().fromJson(json, OfficePojo::class.java)
        val recyclerview = findViewById<RecyclerView>(R.id.rv_companyname)

        adapter = OfficeAdapter(this, officedata, object : Recycleinterface {
            override fun OnRecycleItemClik(
                officePosition: Int,
                teamPosition: Int,
                memberPosition: Int
            ) {
                if (officePosition == -1) return
                if (officedata.size > 0) {
                    for (i in officedata.indices) {
                        if (i == officePosition) {
                            officedata?.get(i)?.ischecked = officedata?.get(i)?.ischecked != true
                            for (j in officedata.get(i).items.indices) {
                                if (j == teamPosition) {
                                    officedata?.get(i)?.items?.get(j)?.ischeckedteam =
                                        officedata?.get(i)?.items?.get(j)?.ischeckedteam != true
                                         for (k in officedata.get(i).items.get(j).items.indices) {
                                        officedata?.get(i)?.items?.get(j)?.items?.get(k)?.ismemberchecked =
                                            officedata?.get(i)?.items?.get(j)?.items?.get(k)?.ismemberchecked != true
                                    }
                                }
                            }
                        }
                    }
                    adapter?.notifyDataSetChanged()
                }
            }
        })
        recyclerview.adapter = adapter


    }


}