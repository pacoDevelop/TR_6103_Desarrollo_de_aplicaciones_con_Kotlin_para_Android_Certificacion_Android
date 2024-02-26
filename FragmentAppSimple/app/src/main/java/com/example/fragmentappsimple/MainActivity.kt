package com.example.fragmentappsimple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView

class MainActivity : AppCompatActivity(), AnswerListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            findViewById<FragmentContainerView>(R.id.fragment_container)?.let { frameLayout ->
                val questionsFrament = QuestionsFragment()
                supportFragmentManager.beginTransaction()
                    .add(frameLayout.id, questionsFrament).commit()
            }
        }

    }

    override fun onSeleted(questionId: Int) {
        findViewById<FragmentContainerView>(R.id.fragment_container)?.let { frameLayout ->
            val answerFragment = AnswersFragment.newInstance(questionId)

            supportFragmentManager.beginTransaction().replace(frameLayout.id, answerFragment)
                .addToBackStack(null).commit()
        }
    }
}