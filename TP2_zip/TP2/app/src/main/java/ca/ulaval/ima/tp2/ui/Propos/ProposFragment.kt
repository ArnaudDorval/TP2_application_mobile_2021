package ca.ulaval.ima.tp2.ui.Propos

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp2.R


class ProposFragment : Fragment() {

    val textEnregistre = "Spicy jalapeno bacon ipsum dolor amet pork chop doner sausage chicken porchetta tri-tip rump. Short ribs tenderloin pancetta, spare ribs turducken burgdoggen pork belly filet mignon ribeye ball tip sausage tongue fatback beef ribs ham hock. Picanha sausage kielbasa tri-tip frankfurter porchetta fatback beef ribs pancetta jowl chuck filet mignon pork belly pig. Jowl boudin swine pork alcatra ham. Ball tip pork belly prosciutto fatback. Pork chop pig landjaeger turducken, tenderloin picanha beef ribs flank swine. Pastrami fatback porchetta kevin cupim, shankle shank ball tip tenderloin prosciutto ham hock short loin.\n" +
            "\n" +
            "Ham pastrami porchetta frankfurter boudin salami. Capicola cupim flank meatball shank bacon ham hock pastrami sausage prosciutto pork chop short ribs porchetta pig tri-tip. Prosciutto cupim t-bone shoulder, corned beef rump capicola sausage jerky pork loin pig. Bacon leberkas chuck pork loin ham pastrami. Flank biltong filet mignon bacon.\n" +
            "\n" +
            "Landjaeger biltong sirloin leberkas flank ribeye. Doner ham tenderloin kielbasa cupim tongue. Short loin tail fatback prosciutto chicken, pork belly pastrami shankle filet mignon t-bone flank turkey pancetta. Bresaola jerky prosciutto pancetta ball tip sausage meatloaf tenderloin t-bone porchetta pork chop rump tail doner fatback. Ribeye kielbasa biltong, drumstick shoulder pork leberkas beef ribs turducken spare ribs short loin picanha frankfurter brisket pork loin. Drumstick alcatra meatball, hamburger ham frankfurter ribeye strip steak leberkas pig landjaeger.\n" +
            "\n" +
            "Bacon ground round chicken kielbasa biltong fatback pork chop. Beef ribs fatback chicken chuck. Cow meatloaf short loin landjaeger prosciutto frankfurter ball tip. Cupim tenderloin pig ribeye shank. Pig ball tip cow kevin beef bacon. Pig leberkas strip steak, shank pork pastrami chicken jerky tenderloin meatloaf. Pancetta pork loin salami biltong beef fatback capicola sausage kevin drumstick picanha shank beef ribs brisket doner.\n" +
            "\n" +
            "Landjaeger alcatra andouille burgdoggen kevin, pig kielbasa ground round tri-tip doner beef ribs capicola. Brisket ball tip spare ribs, landjaeger pork boudin filet mignon sirloin sausage frankfurter tri-tip picanha cow venison. Ground round corned beef sausage t-bone biltong beef ribs landjaeger drumstick. Brisket chuck t-bone jerky turducken chicken. Jerky alcatra beef ribs turducken frankfurter swine landjaeger picanha pork chop pork loin. Jerky capicola ball tip sausage porchetta. Frankfurter pancetta beef ribs prosciutto tenderloin burgdoggen alcatra cow bresaola kevin.\n" +
            "\n" +
            "Long enough eh! \n" +
            "THE END 5x!\n \n"

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_propos, container, false)
        val textView: TextView = root.findViewById(R.id.textViewPropos)

        textView.setText(textEnregistre + textEnregistre + textEnregistre + textEnregistre + textEnregistre)
        textView.setMovementMethod(ScrollingMovementMethod())

        return root
    }
}