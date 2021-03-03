package ca.ulaval.ima.tp2.ui.profil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp2.R

class ProfilFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_profil, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Profil"
        return root
    }
}