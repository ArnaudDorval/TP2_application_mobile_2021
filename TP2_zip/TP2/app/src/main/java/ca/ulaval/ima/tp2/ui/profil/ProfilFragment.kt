package ca.ulaval.ima.tp2.ui.profil

import android.os.Bundle
import android.os.Parcelable
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp2.Profil
import ca.ulaval.ima.tp2.R

class ProfilFragment : Fragment() {

    var textDescription = "He has enough money to last forever. He knows he needs to keep moving. You'll never find him. He's out of the picture. I saved his life, I owed him that, but now he and I are done. Which is exactly what you wanted, isn't it. You've always struck me as a very pragmatic man so if I may, I would like to review options with you. Of which, it seems to me you have two. \n" +
            "\n" +
            "Option A, you kill me right here and now. Apparently I've made that very easy for you. You can kill me, no witnesses and then spend the next few weeks or months tracking down Jesse Pinkman and you kill him too. A pointless exercise it seems to me but that is Option A. \n" +
            "\n" +
            "I continue cooking, you and I both forget about Pinkman. We forget this ever happened. We consider this a lone hiccup in an otherwise long and fruitful business arrangement. I prefer Option B. \n" +
            "\n" +
            "He'll live. I asked to see you in order to... clear the air. There are uh, some... issues that could cause a misunderstanding between us and I think it's in our best interest to lay the cards on the table. My brother-in-law, moments before he was attacked, someone called to warn him. I believe that same person was protecting me. \n" +
            "\n" +
            "THE END 4x "

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


        val root = inflater.inflate(R.layout.fragment_profil, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Profil"

        val labelDescription = root.findViewById<TextView>(R.id.TextViewDescription)
        labelDescription.text = textDescription + textDescription + textDescription + textDescription
        labelDescription.setMovementMethod(ScrollingMovementMethod())

        val bundle = this.arguments
        if (bundle != null) {
            val user = bundle.getParcelable<Parcelable>("pProfil") as Profil

            val textName = root.findViewById<TextView>(R.id.TextViewNomB)
            val textPrenom = root.findViewById<TextView>(R.id.TextViewPrenomB)
            val textNaissance = root.findViewById<TextView>(R.id.TextViewNaissance)
            val textSexe = root.findViewById<TextView>(R.id.TextViewGenreB)
            val textBac= root.findViewById<TextView>(R.id.TextViewBacB)

            textPrenom.text = user.prenom
            textName.text = user.nom
            textNaissance.text = user.naissance
            textSexe.text = user.sexe
            textBac.text = user.bac
        }

        return root
    }


}