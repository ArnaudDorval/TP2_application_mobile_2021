package ca.ulaval.ima.tp2.ui.abacus

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import android.widget.TextView
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp2.R

class AbacusFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_abacus, container, false)
        //val textView: TextView = root.findViewById(R.id.text_wifi)

        val seekerC = root.findViewById<SeekBar>(R.id.seekBarC)
        val seekerB= root.findViewById<SeekBar>(R.id.seekBarB)
        val seekerA = root.findViewById<SeekBar>(R.id.seekBarA)

        val textA = root.findViewById<TextView>(R.id.textViewValueA)
        val textB = root.findViewById<TextView>(R.id.textViewValueB)
        val textC = root.findViewById<TextView>(R.id.textViewValueC)

        seekerC.isEnabled = false;

        seekerA.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                //seekerUpdate(textA, textB, textC, seekerA, seekerB, seekerB);
                // on ajoute +1 et +2 prcq les progress bar peuvent pas avoir de minimum
                val valueA = seekerA.progress + 1;
                val valueB = seekerB.progress + 2;
                val valueC = seekerC.progress;
                Log.d("seeker value", "A:$valueA B: $valueB C: $valueC")

                textA.text = valueA.toString();
                textB.text = valueB.toString();
                textC.text = (valueA*valueB).toString();

                seekerC.progress = ((valueA) * (valueB));
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        seekerB.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                //seekerUpdate(textA, textB, textC, seekerA, seekerB, seekerB);
                val valueA = seekerA.progress + 1;
                val valueB = seekerB.progress + 2;
                val valueC = seekerC.progress;
                Log.d("seeker value", "A:$valueA B: $valueB C: $valueC")

                textA.text = valueA.toString();
                textB.text = valueB.toString();
                textC.text = (valueA*valueB).toString();

                seekerC.progress = ((valueA) * (valueB));
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {

            }
        })

        return root
    }


    fun seekerUpdate(TA: TextView, TB: TextView, TC: TextView, SA : SeekBar, SB : SeekBar, SC : SeekBar) {
        val valueA = SA.progress;
        val valueB = SB.progress;
        val valueC = SC.progress;

        TA.setText(valueA);
        TB.setText(valueB);
        TC.setText(valueA*valueB);
    }
}