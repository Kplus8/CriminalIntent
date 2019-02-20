package com.csci448.labs.criminalintent

import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.list_item_crime.view.*
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

private lateinit var adapter: CrimeListAdapter

private class CrimeHolder(val fragment: CrimeListFragment, val view: View): RecyclerView.ViewHolder(view) {
    fun bind(crime: Crime) {
        view.list_item_crime_title_text_view.text = crime.title
        view.list_item_crime_date_text_view.text = crime.date.toString()
        view.list_item_crime_solved_check_box.isChecked = crime.isSolved
        view.setOnClickListener {
            val intent = CrimeDetailsActivity.createIntent(fragment, crime.id)
            fragment.startActivity(intent)
        }
    }
}

private class CrimeListAdapter(val fragment: CrimeListFragment, val crimes: List<Crime>) : RecyclerView.Adapter<CrimeHolder>() {
    override fun getItemCount(): Int {
        return crimes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrimeHolder {
        val layoutInflater = LayoutInflater.from(fragment.context)
        val view = layoutInflater.inflate(R.layout.list_item_crime, parent, false)
        return CrimeHolder(fragment, view)
    }

    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        holder.bind(crimes[position])
    }
}

class CrimeListFragment: Fragment() {
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(CrimeListFragment.LOG_TAG, "onAttach() called")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(CrimeListFragment.LOG_TAG, "onCreate() called")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.d(CrimeListFragment.LOG_TAG, "onActivityCreated() called")
    }

    override fun onStart() {
        super.onStart()
        Log.d(CrimeListFragment.LOG_TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(CrimeListFragment.LOG_TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(CrimeListFragment.LOG_TAG, "onPaused() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(CrimeListFragment.LOG_TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(CrimeListFragment.LOG_TAG, "onDestroy() called")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(CrimeListFragment.LOG_TAG, "onDetach() called")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(CrimeListFragment.LOG_TAG, "onCreateView() called")
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d(CrimeListFragment.LOG_TAG, "onViewCreated() called")
        crime_list_recycler_view.layoutManager = LinearLayoutManager(activity)
        updateUI()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun updateUI() {
        adapter = CrimeListAdapter(this, CrimeLab.getCrimes() )
        crime_list_recycler_view.adapter = adapter
    }

    companion object {
        private const val LOG_TAG = "448.CrimeListFrag"
    }
}