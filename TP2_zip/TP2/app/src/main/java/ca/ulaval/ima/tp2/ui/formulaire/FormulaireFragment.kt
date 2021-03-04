package ca.ulaval.ima.tp2.ui.formulaire

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp2.*
import java.text.SimpleDateFormat
import java.util.*


class FormulaireFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_formulaire, container, false)
        //val textView: TextView = root.findViewById(R.id.text_gallery)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Formulaire"
        val ctx = requireContext();
        val spinner = root.findViewById<Spinner>(R.id.spinnerBac)
        ArrayAdapter.createFromResource(
                ctx,
                R.array.bac_array,
                android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


        val radioGroup = root.findViewById<RadioGroup>(R.id.radioGroupSexe);
        var Sexe = "masculin"

        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId -> // checkedId is the RadioButton selected
            when (checkedId) {
                R.id.radioButton -> {
                    Sexe = "masculin"
                }
                R.id.radioButton2 -> {
                    Sexe = "feminin"
                }
            }
        })

        val myCalendar: Calendar = Calendar.getInstance()

        val editextNaissance = root.findViewById<EditText>(R.id.editTextTextNaissance)

        editextNaissance.transformIntoDatePicker(requireContext(), "yyyy-MM-dd", Date())
        val Naissance = editextNaissance.getText().toString()
        val editTextPrenom = root.findViewById<EditText>(R.id.editTextTextPrenom)
        val Prenom: String = editTextPrenom.getText().toString()
        val editTextNom = root.findViewById<EditText>(R.id.editTextTextPersonName)
        val Nom: String = editTextNom.getText().toString()

        val soumettreButton = root.findViewById<Button>(R.id.button_soumettre);

        soumettreButton.setOnClickListener(View.OnClickListener {
            val Naissance = editextNaissance.getText().toString()
            val editTextPrenom = root.findViewById<EditText>(R.id.editTextTextPrenom)
            val Prenom: String = editTextPrenom.getText().toString()
            val editTextNom = root.findViewById<EditText>(R.id.editTextTextPersonName)
            val Nom: String = editTextNom.getText().toString()
            val bac = spinner.selectedItem.toString();
            Log.d("Parcelable", "MSG : $Prenom; $Nom; $Naissance; $Sexe; $bac")
            val user = Profil(Nom, Prenom, Naissance, Sexe, bac);

            (activity as MainActivity?)?.let{
                val intent = Intent (it, MainActivity3::class.java)
                intent.putExtra("pProfil", user);
                it.startActivity(intent)
            }

        })

        return root


        TODO("Criss de boutton radio sont jaune dans le ui mais après la compilation sont rouge")
        TODO("Faut utiliser la classe profil implémenté pis faire le calisse d'affichage")
        TODO("faut aussi créer le parcelable avec class profil")
        TODO("faut ouvrir la nouvelle activity vers la page profil")
    }


    fun EditText.transformIntoDatePicker(context: Context, format: String, maxDate: Date? = null) {
        isFocusableInTouchMode = false
        isClickable = true
        isFocusable = false

        val myCalendar = Calendar.getInstance()
        val datePickerOnDataSetListener =
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    myCalendar.set(Calendar.YEAR, year)
                    myCalendar.set(Calendar.MONTH, monthOfYear)
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                    val sdf = SimpleDateFormat(format, Locale.UK)
                    setText(sdf.format(myCalendar.time))
                }

        setOnClickListener {
            DatePickerDialog(
                    context, datePickerOnDataSetListener, myCalendar
                    .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                    myCalendar.get(Calendar.DAY_OF_MONTH)
            ).run {
                maxDate?.time?.also { datePicker.maxDate = it }
                show()
            }
        }
    }

}