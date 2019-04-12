package com.diegoveega.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_basic.view.*
import java.lang.Exception

const val ARG_TEXT = "text1"
const val ARG_TEXT2 = "text2"


class FRagmentBasic: Fragment(){
    var texto1:String?=null
    var texto2:String?=null
    var toolbox:ListenerToolBox?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Leer argumentos
        arguments?.apply {
            //
            texto1= getString(ARG_TEXT,"")
            texto2= getString(ARG_TEXT2,"")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_basic, container, false).apply {
            tv_1.text=texto1
            tv_2.text=texto2
            bt_boton.setOnClickListener{
                toolbox?.ClickListenerHandler(tv_1)
            }
        }
    }

    companion object {
        fun newInstance(texto1:String, texto2:String)=FRagmentBasic().apply {
            arguments=Bundle().apply {
                putString(ARG_TEXT, texto1)
                putString(ARG_TEXT2, texto2)
            }
        }
    }

    interface ListenerToolBox{
        fun ClickListenerHandler(view:TextView)
    }

    //LO QUE SIEMPRE VOY A COPIAR////////////////////////////////////////////////////7
    //CONTEXTO DE MAIN ACTIVITY, QUE PUEDE QUE SEA UNA INSTANCIA DEL TOOLBOX LISTENER
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        //ES TOOLBOX?
        if(context is ListenerToolBox){
            //IGUALA CONTEXTO
            toolbox=context
        } else{
            throw Exception("SE necesita algo... toolboxListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        toolbox=null

    }
    //////////////////////////////////////////////////////////////////////////////77

}