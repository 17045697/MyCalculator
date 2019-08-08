package com.example.mycalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var Once = ""
    var global = ""
    var total = 0.0
    var Firstchange = false
    var op = ""
    var dot = false
    var negative = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonAC
        buttonAC.setOnClickListener {
            Once = ""
            global = ""
            tvSum.text = ""
            Firstchange = false
            dot = false
            negative = false
        }
    }

    fun btnOnClick(view : View){
        val btnSelected = view as Button
        if(Firstchange == false) {
            when (btnSelected.id) {
                button00.id -> Once = Once + "0"
                button01.id -> Once = Once + "1"
                button02.id -> Once = Once + "2"
                button03.id -> Once = Once + "3"
                button04.id -> Once = Once + "4"
                button05.id -> Once = Once + "5"
                button06.id -> Once = Once + "6"
                button07.id -> Once = Once + "7"
                button08.id -> Once = Once + "8"
                button09.id -> Once = Once + "9"
            }
            tvSum.text = "$Once"
        }else{
            when (btnSelected.id) {
                button00.id -> global = global + "0"
                button01.id -> global = global + "1"
                button02.id -> global = global + "2"
                button03.id -> global = global + "3"
                button04.id -> global = global + "4"
                button05.id -> global = global + "5"
                button06.id -> global = global + "6"
                button07.id -> global = global + "7"
                button08.id -> global = global + "8"
                button09.id -> global = global + "9"
            }
            tvSum.text = "$global"
        }
    }

    fun btnOnClick100(view : View){
        if(global.isEmpty()) {
            var percent = Once.toDouble() / 100
            tvSum.text = "$percent"
        }else{
            var percent = (Once.toDouble() + global.toDouble()) / 100
            tvSum.text = "$percent"
        }
    }

    fun btnOnClickNegative(view : View){
        if (negative){

        }else{

        }
    }


    fun btnOnOpClick(view : View){
        val btnSelected = view as Button
        when(btnSelected.id){
            buttonDivide.id -> op = "/"
            buttonMinus.id -> op = "-"
            buttonTimes.id -> op = "*"
            buttonPlus.id -> op = "+"
        }
        if(op == "+" && global != ""){
            total = Once.toDouble() + global.toDouble()
            Once = total.toString()
            global = ""
            total = 0.0
        }else if(op == "-"&& global != "" ){
            total = Once.toDouble() - global.toDouble()
            Once = total.toString()
            global = ""
            total = 0.0
        }else if(op == "*"&& global != ""){
            total = Once.toDouble() * global.toDouble()
            Once = total.toString()
            global = ""
            total = 0.0
        }else if(op == "/"&& global != ""){
            total = Once.toDouble() / global.toDouble()
            Once = total.toString()
            global = ""
            total = 0.0
        }
        Firstchange = true
        dot = false
        tvSum.text = ""
        buttonDot.isEnabled = true
    }

    fun btnEqualsClick(view : View){
        if(op == "+"){
            total = Once.toDouble() + global.toDouble()
        }else if(op == "-"){
            total = Once.toDouble() - global.toDouble()
        }else if(op == "*"){
            total = Once.toDouble() * global.toDouble()
        }else if(op == "/"){
            total = Once.toDouble() / global.toDouble()
        }
        tvSum.text = total.toString()
        Once = total.toString()
        total = 0.0
        global = ""
        dot = false
        buttonDot.isEnabled = true
    }

    fun btnDotClick(view : View){
        if(Firstchange == false){
            Once = Once + "."
            tvSum.text = "$Once"
        }else if(Firstchange == true){
            global = global + "."
            tvSum.text = "$global"
        }
        if(dot == false){
            dot = true
            buttonDot.isEnabled = false
        }
    }




}

