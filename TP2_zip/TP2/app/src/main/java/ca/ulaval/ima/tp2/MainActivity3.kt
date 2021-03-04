package ca.ulaval.ima.tp2

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import ca.ulaval.ima.tp2.ui.profil.ProfilFragment

class MainActivity3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //val toolbar: Toolbar = findViewById(R.id.toolbar)

        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar()?.setDisplayShowHomeEnabled(true);


        val user = intent.getParcelableExtra<Profil>("pProfil")
        val bundle = Bundle()
        bundle.putParcelable("pProfil", user)

        val transaction = supportFragmentManager.beginTransaction()
        val fragmentGet = ProfilFragment()
        fragmentGet.arguments = bundle
        transaction.replace(R.id.nav_host_fragment, fragmentGet)
        transaction.commit()
    }

    override fun onOptionsItemSelected(item:MenuItem):Boolean{
        if(item.getItemId() === android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}