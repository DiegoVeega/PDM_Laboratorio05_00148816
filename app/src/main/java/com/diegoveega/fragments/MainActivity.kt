package com.diegoveega.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

//

class MainActivity : AppCompatActivity(), FRagmentBasic.ListenerToolBox {
    override fun ClickListenerHandler(view: TextView) {
        //Main activity defina FragmentBasic
        view.text="Valiendo en EMA"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentBasic=FRagmentBasic.newInstance("texto1","texto2")

        supportFragmentManager
                .beginTransaction()
                .add(R.id.activity_content, fragmentBasic)
                .commit()
        //Saber si esta en port o land con IF(resource.configuration.orientation ==Configaration."ORIENTATION"){ toast.maketext(this, "estoy en land", toast.LENGT_LONG.show)
    }


}
