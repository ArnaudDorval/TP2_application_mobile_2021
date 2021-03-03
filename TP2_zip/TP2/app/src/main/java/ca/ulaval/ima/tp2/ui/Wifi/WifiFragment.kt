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
            if (t == true) {
                Log.d("Internet", "t : $t")
                ellipse.setColorFilter(Color.parseColor("#18FD3B"))

            } else {
                Log.d("Internet", "t : $t")
                ellipse.setColorFilter(Color.parseColor("#FD1818"))
            }
        })

        return root
    }

    @Suppress("DEPRECATION")
    fun Context.isConnectedToNetwork(): Boolean {
        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        return connectivityManager?.activeNetworkInfo?.isConnectedOrConnecting ?: false
    }
}