package com.csci448.labs.criminalintent

import android.content.Intent
import android.support.v4.app.Fragment
import java.util.*

class CrimeDetailsActivity: SingleFragmentActivity() {

    override fun getLogTag(): String {
        return LOG_TAG
    }

    override fun createFragment(): Fragment {
        val uuid = intent.getSerializableExtra(ID_KEY) as UUID
        return CrimeDetailsFragment.createFragment(uuid)
    }


    companion object {
        private const val LOG_TAG = "448.CrimeDetailsAct"
        private const val ID_KEY = "UUID_KEY"

        fun createIntent(fragment: CrimeListFragment, id: UUID): Intent {
            val intent = Intent(fragment.context, CrimeDetailsActivity::class.java)
            intent.putExtra(ID_KEY, id)
            return intent
        }
    }
}