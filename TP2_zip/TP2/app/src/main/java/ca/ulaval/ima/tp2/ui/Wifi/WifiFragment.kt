package ca.ulaval.ima.tp2.ui.Wifi


import android.content.Context
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ca.ulaval.ima.tp2.R


class WifiFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_wifi, container, false)
        //val textView: TextView = root.findViewById(R.id.text_gallery)
        (activity as AppCompatActivity?)!!.supportActionBar!!.title = "Status Internet"
        val buttonInternet = root.findViewById<Button>(R.id.button_internet_status)
        val ellipse = root.findViewById<ImageView>(R.id.imageViewRed)


        buttonInternet.setOnClickListener(View.OnClickListener {
            val t = requireContext().isConnectedToNetwork()
            val textwifi = root.findViewById<TextView>(R.id.text_wifi)
            if (t == 1) {
                Log.d("Internet", "t : $t")
                ellipse.setColorFilter(Color.parseColor("#18FD3B"))
                textwifi.text = "Wifi"
            }else if (t == 2){
                Log.d("Internet", "t : $t")
                ellipse.setColorFilter(Color.parseColor("#18FD3B"))
                textwifi.text = "3G/LTE"
            } else{
                Log.d("Internet", "t : $t")
                ellipse.setColorFilter(Color.parseColor("#FD1818"))
                textwifi.text = "Aucune connexion"
            }
        })

        return root
    }

    @Suppress("DEPRECATION")
    fun Context.isConnectedToNetwork(): Int {
        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

        val pInfo = connectivityManager?.activeNetworkInfo
        val connected = pInfo != null && pInfo.isAvailable && pInfo.isConnected
        val wifi = pInfo?.type == ConnectivityManager.TYPE_WIFI

        if (connected && wifi){
            return 1
        }else if ( connected && !wifi){
            return 2
        } else{
            return 0
        }
    }
}