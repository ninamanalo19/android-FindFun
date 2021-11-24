package com.ninaestoye.findfun.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ninaestoye.findfun.R
import com.ninaestoye.findfun.adapter.AnswersAdapter.ViewHolder
import com.ninaestoye.findfun.databinding.AnswerRowBinding

class AnswersAdapter: RecyclerView.Adapter<ViewHolder>() {

    private val TAG = AnswersAdapter::class.simpleName;
    private var answers = emptyList<String>();

    class ViewHolder(val binding: AnswerRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.answer = answers[position];
        holder.binding.tvAnswer.setOnClickListener {
            Log.d(TAG, "onBindViewHolder: answer=${answers[position]}")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.answer_row,
            parent,
            false
        ));
    }

    override fun getItemCount(): Int {
        return answers.size;
    }

    fun populateAnswers(answers: List<String>) {
        this.answers = answers;
        notifyDataSetChanged();
    }


}