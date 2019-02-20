package com.csci448.labs.criminalintent

import android.support.v4.app.Fragment

class CrimeListActivity: SingleFragmentActivity() {

    override fun getLogTag(): String {
        return LOG_TAG
    }

    override fun createFragment(): Fragment {
        return CrimeListFragment()
    }

    companion object {
        private const val LOG_TAG = "448.CrimeListAct"
    }
}