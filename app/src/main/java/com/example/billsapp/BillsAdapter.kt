package com.example.billsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class BillAdapter(private val billList: MutableList<Bill>) :
    RecyclerView.Adapter<BillAdapter.BillViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BillViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_bill, parent, false)
        return BillViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: BillViewHolder, position: Int) {
        val bill: Bill = billList[position]
        holder.bind(bill)
    }

    override fun getItemCount(): Int {
        return billList.size
    }


    inner class BillViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvBillTitle: TextView = itemView.findViewById(R.id.tvBillTitle)
        private val tvBillAmount: TextView = itemView.findViewById(R.id.tvBillAmount)

        fun bind(bill: Bill) {
            tvBillTitle.text = bill.title
            tvBillAmount.text = "Amount: $" + bill.amount
        }
    }
}

data class Bill(val title: String, val amount: Double) {

}
