package com.ninaestoye.findfun.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ninaestoye.findfun.R
import com.ninaestoye.findfun.adapter.AnswersAdapter
import com.ninaestoye.findfun.databinding.FragmentQuestionBinding
import com.ninaestoye.findfun.helper.Category
import com.ninaestoye.findfun.helper.SwipeListener
import com.ninaestoye.findfun.model.Question
import com.ninaestoye.findfun.viewModel.QuestionViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_question.view.*

@AndroidEntryPoint
class QuestionFragment : Fragment() {

    private val TAG = QuestionFragment::class.simpleName;
    val questionViewModel : QuestionViewModel by viewModels();

    private lateinit var binding : FragmentQuestionBinding;
    private lateinit var adapter : AnswersAdapter;

    // TODO: use jetpack compose layouting
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_question, container, false);
        val view = binding.root;
        setUpRecyclerview(view.rvAnswers);
        fetchQuestions(view);
        return view;
    }

    private fun setBindingCurrentIndexQuestion(current: Int) {
        binding.current = current;
    }

    private fun setSwipeListener(view: View, questions: List<Question>) {
        view.setOnTouchListener(object: SwipeListener(requireContext()) {
            override fun onSwipeLeft() {
                questionViewModel.setCurrent(questionViewModel.currentIndex + 1);
                if (questionViewModel.currentIndex < questions.size) {
                    val fIndex = questionViewModel.currentIndex + 1;
                    setBindingCurrentIndexQuestion(fIndex);
                    Log.d(TAG, "onSwipeLeft: currentIndex=${questionViewModel.currentIndex} fIndex=${fIndex}");
                    setCurrentQuestion(questions[questionViewModel.currentIndex]);
                } else {
                    questionViewModel.setCurrent(questions.size - 1);
                }
            }

            override fun onSwipeRight() {
                if (questionViewModel.currentIndex > 0 && questionViewModel.currentIndex < questions.size) {
                    setBindingCurrentIndexQuestion(questionViewModel.currentIndex);
                    questionViewModel.setCurrent(questionViewModel.currentIndex - 1);
                    Log.d(TAG, "onSwipeRight: currentIndex=${questionViewModel.currentIndex} questions count=${questions.size}")
                    setCurrentQuestion(questions[questionViewModel.currentIndex]);
                } else {
                    questionViewModel.setCurrent(0);
                }
            }
        });
    }

    private fun setUpRecyclerview(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);
        adapter = AnswersAdapter();
        recyclerView.adapter = adapter;
    }

    private fun populateAnswers(answers: List<String>) {
        adapter.populateAnswers(answers);
    }

    private fun setCurrentQuestion(question : Question) {
        binding.question = question;
        val answers : MutableList<String> =  question.incorrect_answers.toMutableList();
        answers.add(0, question.correct_answer);
        answers.shuffle();
        populateAnswers(answers);
        questionViewModel.currentTime.observe(viewLifecycleOwner) { currentTime ->
            val btnAnswer = binding.root.btnAnswer;
            if (currentTime > 0) {
                if (!btnAnswer.isEnabled) {
                    btnAnswer.isEnabled = true;
                }
                binding.time = currentTime;
            } else {
                btnAnswer.isEnabled = false;
                btnAnswer.text = getString(R.string.times_up);
            }
        };
    }

    private fun fetchQuestions(view: View) {
        questionViewModel.getSavedQuestions.observe(viewLifecycleOwner, Observer { questions ->
            if (questions.isNotEmpty()) {
                Log.d(TAG, "fetchQuestions: bind the first saved question");
                binding.total = questions.size;
                setBindingCurrentIndexQuestion(questionViewModel.currentIndex + 1);
                setCurrentQuestion(questions[questionViewModel.currentIndex]);
                setSwipeListener(view.clMain, questions);
                setSwipeListener(view.rvAnswers, questions);
            } else {
                Log.d(TAG, "fetchQuestions: request questions");
                questionViewModel.getQuestionsByCategory(10, Category.GENERAL_KNOWLEDGE, "easy");
            }
        })
    }
}