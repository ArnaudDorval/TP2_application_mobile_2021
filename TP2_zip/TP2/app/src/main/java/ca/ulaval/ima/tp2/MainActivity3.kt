package ca.ulaval.ima.tp2

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import ca.ulaval.ima.tp2.ui.profil.ProfilFragment


class MainActivity3 : AppCompatActivity() {

    var user = Profil("","","","","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //val toolbar: Toolbar = findViewById(R.id.toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        user = intent.getParcelableExtra<Profil>("pProfil")
        val userB = Profil(user.nom, user.prenom, user.naissance, user.sexe, user.bac)


        val transaction = supportFragmentManager.beginTransaction()
        val fragmentGet = ProfilFragment()
        val bundle = Bundle()
        bundle.putParcelable("pProfil", userB)
        fragmentGet.arguments = bundle
        transaction.replace(R.id.nav_host_fragment, fragmentGet)
        transaction.commit()
    }

    override fun onOptionsItemSelected(item:MenuItem):Boolean{
        if(item.itemId === android.R.id.home){
            val retData = Intent()
            retData.putExtra("pProfil", user);
            //setResult(RESULT_OK, retData);
            //
            setResult(RESULT_OK, retData);
            finish()
            //startActivity(intent);
        }
        return super.onOptionsItemSelected(item)
    }
}