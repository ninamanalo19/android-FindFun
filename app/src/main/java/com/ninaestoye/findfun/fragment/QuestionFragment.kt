package com.ninaestoye.findfun.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ninaestoye.findfun.R
import com.ninaestoye.findfun.databinding.FragmentQuestionBinding
import com.ninaestoye.findfun.helper.Category
import com.ninaestoye.findfun.viewModel.QuestionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class QuestionFragment : Fragment() {

    private val TAG = QuestionFragment::class.simpleName;
    val questionViewModel : QuestionViewModel by viewModels();

    private lateinit var binding : FragmentQuestionBinding;

    // TODO: use jetpack compose layouting
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false);
        val view = binding.root;

        fetchQuestions();
        return view;
    }

    private fun fetchQuestions() {
        questionViewModel.getSavedQuestions.observe(viewLifecycleOwner, Observer { questions ->
            if (questions.isNotEmpty()) {
                Log.d(TAG, "fetchQuestions: bind the first saved question");
                binding.question = questions[0];
            } else {
                Log.d(TAG, "fetchQuestions: request questions");
                questionViewModel.getQuestionsByCategory(10, Category.GENERAL_KNOWLEDGE, "easy");
            }
        })
    }
}