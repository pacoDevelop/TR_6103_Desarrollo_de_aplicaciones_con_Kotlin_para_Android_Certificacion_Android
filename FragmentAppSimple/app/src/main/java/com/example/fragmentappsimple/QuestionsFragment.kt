package com.example.fragmentappsimple

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

interface AnswerListener {
    fun onSeleted(question: Int)
}

class QuestionsFragment : Fragment(), View.OnClickListener {

    private lateinit var answerLister: AnswerListener;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_questions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val planets = listOf<View>(
            view.findViewById(R.id.most_moons),
            view.findViewById(R.id.largest_planet),
            view.findViewById(R.id.side_spinning)
        )

        planets.forEach {
            it.setOnClickListener(this)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AnswerListener) {
            answerLister = context
        } else {
            throw RuntimeException("El attach debe ser del tipo AnswerListener")
        }

    }

    override fun onClick(v: View?) {
        v?.let {
            answerLister.onSeleted(it.id)
        }
    }
}