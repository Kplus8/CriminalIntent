package com.csci448.labs.criminalintent

import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_details.*
import java.util.*

// TODO create the fragment
class CrimeDetailsFragment : Fragment() {

    private lateinit var crime: Crime

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(LOG_TAG, "onCreate() called")
        crime = Crime()
        val randomUUIDString = UUID.randomUUID().toString()
        val uuidString = arguments?.getString(ID_KEY, randomUUIDString)?: randomUUIDString
        crime = CrimeLab.getCrime(UUID.fromString(uuidString))?: Crime()
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume() called")
    }

    override fun onPause() {
        Log.d(LOG_TAG, "onPause() called")
        super.onPause()
    }

    override fun onStop() {
        Log.d(LOG_TAG, "onStop() called")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(LOG_TAG, "onDestroy() called")
        super.onDestroy()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(LOG_TAG, "onCreateView() called")
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(LOG_TAG, "onViewCreated() called")
        crime_title_edit_text.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                crime.title = s.toString()
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        crime_date_button.text = crime.date.toString()
        crime_date_button.isEnabled = false

        crime_solved_checkbox.setOnCheckedChangeListener { _, isChecked -> crime.isSolved = isChecked}
    }

    override fun onDestroyView() {
        Log.d(LOG_TAG, "onDestroyView() called")
        super.onDestroyView()
    }

    companion object {
        private const val LOG_TAG = "448.CrimeDetailsFrag"
        private const val ID_KEY = "UUID_KEY"

        fun createFragment(id: UUID): Fragment {
            val argument = Bundle()
            argument.putString(ID_KEY, id.toString())
            var detailFragment = CrimeDetailsFragment()
            detailFragment.setArguments(argument)
            return detailFragment


        }
    }
}