package com.example.kalkulator

import java.math.BigDecimal
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.math.RoundingMode

class SimpleCalculator : AppCompatActivity() {
    var result = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_calculator)


        if(savedInstanceState != null){
            result = savedInstanceState.getString("result").toString();
        }


        var resultText = findViewById<TextView>(R.id.textView2)
        resultText.setText(result)//po prostu ustawienie początkowej wartości

        val button_zero = findViewById<Button>(R.id.button_zero)
        button_zero.setOnClickListener {
            if(check_len(result)==0){
                if(result.length==1 && result=="0"){
                    result="0"
                }else{
                    result += "0"
                }
            }
            resultText.setText(result)
        }

        val button_one = findViewById<Button>(R.id.button_one)
        button_one.setOnClickListener {
            if(check_len(result)==0){
                if(result.length==1 && result=="0"){
                    result="1"
                }else{
                    result += "1"
                }
            }
            resultText.setText(result)
        }

        val button_two = findViewById<Button>(R.id.button_two)
        button_two.setOnClickListener {
            if(check_len(result)==0){
                if(result.length==1 && result=="0"){
                    result="2"
                }else{
                    result += "2"
                }
            }
            resultText.setText(result)
        }

        val button_three = findViewById<Button>(R.id.button_three)
        button_three.setOnClickListener {
            if(check_len(result)==0){
                if(result.length==1 && result=="0"){
                    result="3"
                }else{
                    result += "3"
                }
            }
            resultText.setText(result)
        }

        val button_four = findViewById<Button>(R.id.button_four)
        button_four.setOnClickListener {
            if(check_len(result)==0){
                if(result.length==1 && result=="0"){
                    result="4"
                }else{
                    result += "4"
                }
            }
            resultText.setText(result)
        }

        val button_five = findViewById<Button>(R.id.button_five)
        button_five.setOnClickListener {
            if(check_len(result)==0){
                if(result.length==1 && result=="0"){
                    result="5"
                }else{
                    result += "5"
                }
            }
            resultText.setText(result)
        }

        val button_six = findViewById<Button>(R.id.button_six)
        button_six.setOnClickListener {
            if(check_len(result)==0){
                if(result.length==1 && result=="0"){
                    result="6"
                }else{
                    result += "6"
                }
            }
            resultText.setText(result)
        }

        val button_seven = findViewById<Button>(R.id.button_seven)
        button_seven.setOnClickListener {
            if(check_len(result)==0){
                if(result.length==1 && result=="0"){
                    result="7"
                }else{
                    result += "7"
                }
            }
            resultText.setText(result)
        }

        val button_eight = findViewById<Button>(R.id.button_eight)
        button_eight.setOnClickListener {
            if(check_len(result)==0){
                if(result.length==1 && result=="0"){
                    result="8"
                }else{
                    result += "8"
                }
            }
            resultText.setText(result)
        }

        val button_nine = findViewById<Button>(R.id.button_nine)
        button_nine.setOnClickListener {
            if(check_len(result)==0){
                if(result.length==1 && result=="0"){
                    result="9"
                }else{
                    result += "9"
                }
            }
            resultText.setText(result)
        }

        val button_add = findViewById<Button>(R.id. button_plus)
        button_add.setOnClickListener {
            if(check_len(result)==0){
                if(result.length>0){
                    if(checkIfAnyOperations()==false){
                        result += "+"
                    }
                }
            }
            resultText.setText(result)
        }

        val button_sub = findViewById<Button>(R.id. button_minus)
        button_sub.setOnClickListener {
            var if_any_operation = 0
            var counter = 0
            if(check_len(result)==0){
                if(result.length>0){
                    for(i in result){
                        if(i=='-' && counter==0){
                            counter+=1
                            continue
                        }
                        if(i=='-' || i=='+' || i=='/' || i=='*'){
                            if_any_operation = 1
                            break
                        }
                        counter+=1
                    }
                    if(if_any_operation==1){
                        if(counter==result.length-1){
                            //można dodać coś
                            result+='-'
                        }
                    }else{
                        result+='-'
                    }

                }
            }
            resultText.setText(result)
        }

        val button_mul = findViewById<Button>(R.id. button_multiply)
        button_mul.setOnClickListener {
            if(check_len(result)==0){
                if(result.length>0){
                    if(checkIfAnyOperations()==false){
                        result += "*"
                    }
                }else{
                    //wypisać że jest błędna operacja
                }
            }
            resultText.setText(result)
        }

        val button_div = findViewById<Button>(R.id. button_divide)
        button_div.setOnClickListener {
            if(check_len(result)==0){
                if(result.length>0){
                    if(checkIfAnyOperations()==false){
                        result += "/"
                    }
                }else{
                    Toast.makeText(this, "Nie dzielimy przez 0!", Toast.LENGTH_SHORT).show()
                }
            }
            resultText.setText(result)
        }

        val button_bcksp = findViewById<Button>(R.id. button_backspace)
        button_bcksp.setOnClickListener {
            if(result.length>1){
                result = result.substring(0,result.length-1)
            }else{
                result = "0"
            }

            resultText.setText(result)
        }

        val button_clear = findViewById<Button>(R.id. button_clear)
        button_clear.setOnClickListener {
            result = "0"
            resultText.setText(result)
        }

        val button_change_sign = findViewById<Button>(R.id. button_change_sign)
        button_change_sign.setOnClickListener {
            var where_operation = 0
            var first_digit: BigDecimal = BigDecimal("0.0")
            var second_digit: BigDecimal = BigDecimal("0.0")
            var if_found_operation = 0
            var minus_flag = 0

            for (i in result){
                if(where_operation==0 && i=='-'){
                    where_operation+=1
                    continue
                }
                if(i=='-'){
                    minus_flag=1
                    break
                }
                if(i=='+' || i=='/' || i=='*'){
                    if_found_operation=1
                    break
                }
                where_operation+=1
            }
            if(where_operation!=result.length && result[result.length-1].isDigit()){
                first_digit = result.substring(0,where_operation).toBigDecimal()
                second_digit = result.substring(where_operation+1,result.length).toBigDecimal().negate()
                if(result[where_operation]=='-'){
                    second_digit = second_digit.negate()
                    result = first_digit.toString()+"+"+second_digit.toString()
                }else{

                    result = first_digit.toString()+result[where_operation]+second_digit.toString()

                }
            }else if(result[result.length-1].isDigit()){
                result = result.toBigDecimal().negate().toString()
            }
            resultText.setText(result)
        }


        val button_dot = findViewById<Button>(R.id. button_dot)
        button_dot.setOnClickListener {
            var flag_if_found_dot = 0
            var flag_if_found_operation = 0
            var counter = result.length
            if(check_len(result)==0){
                for(i in result.reversed()){

                    if(i=='-' || i=='*' || i=='/' || i=='+' || i=='^'){
                        flag_if_found_operation=1
                        break
                    }
                    if(i=='.'){
                        flag_if_found_dot=1
                        break
                    }
                    counter -=1
                }

                if(flag_if_found_dot!=1){
                    if(counter!=result.length){
                        result+='.'
                        resultText.setText(result)
                    }
                }
            }
        }


        val button_equal = findViewById<Button>(R.id. button_equal)
        button_equal.setOnClickListener {

            var where_operation = 0
            var first_digit = BigDecimal(0.0)
            var second_digit = BigDecimal(0.0)
            var flag_if_any_operation = 0
            var minus_flag = 0

            for (i in result){
                if(where_operation==0 && i=='-'){
                    where_operation+=1
                    continue
                }
                if(i=='-' || i=='+' || i=='/' || i=='*'){
                    if(i=='-'){
                        minus_flag=1
                    }
                    flag_if_any_operation=1
                    break
                }
                where_operation+=1
            }
            if(where_operation>=result.length-1){
                Toast.makeText(this, "Błędne dane!", Toast.LENGTH_SHORT).show()

            }else if(!isNumericSubstring(result,where_operation+1)){
                Toast.makeText(this, "Błędne dane!", Toast.LENGTH_SHORT).show()
            }else if(flag_if_any_operation==1 && checkHowManyMinusAfterOperation()<=2){

                first_digit = result.substring(0,where_operation).toBigDecimal()
                second_digit = result.substring(where_operation+1,result.length).toBigDecimal()
                if(result[where_operation]=='+'){
                    result = (first_digit+second_digit).toString()
                }else if(result[where_operation]=='-'){
                    result = (first_digit-second_digit).toString()
                }else if(result[where_operation]=='*'){
                    result = (first_digit*second_digit).toString()
                }else if(result[where_operation]=='/'){
                    val regex = Regex("[0].[0]*")
                    if (regex.matches(second_digit.toString())) {
                        second_digit = BigDecimal(0)
                    }
                    if(!(second_digit == BigDecimal(0)) && !(second_digit == BigDecimal(0.0))){
                        result = first_digit.divide(second_digit,6,RoundingMode.HALF_UP).toString()
                    }else{
//dodać toast
                        Toast.makeText(this, "Nie dzielimy przez 0!", Toast.LENGTH_SHORT).show()
                        result = "0"//oczywiscie to do przerobienia
                    }

                }
                val temp = 0
            }
            result = removeZerosAfterDot(result)
            resultText.setText(result)
        }


    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putString("result",result)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle){
        super.onRestoreInstanceState(savedInstanceState)
    }

    fun checkHowManyMinusAfterOperation(): Int{
        var how_many_minus = 0
        var location_of_operation = 0
        for(i in result){
            if(i=='-' && location_of_operation==0){
                location_of_operation+=1
                continue
            }
            if(i=='-' || i=='*' || i=='+' || i=='/'){
                if(i=='-'){
                    how_many_minus+=1
                }
                break
            }
            location_of_operation+=1
        }
        var temp_counter = 0
        for (i in result){
            if(temp_counter<=location_of_operation){
                temp_counter+=1
                continue
            }
            if(i=='-'){
                how_many_minus+=1
            }
            temp_counter+=1
        }
        return how_many_minus
    }

    fun checkIfAnyOperations(): Boolean {
        var counter = 0
        for (i in result){
            if(counter == 0){
                counter+=1
                continue
            }
            if(i=='+' || i=='-' || i=='*' || i=='/'){
                return true
            }
            counter+=1
        }
        return false
    }

    fun removeZerosAfterDot(input: String): String {
        var res = input
        var dotFound = false
        var i = input.length - 1
        while (i >= 0) {
            val char = input[i]
            if (char == '.') {
                dotFound = true
                break
            }
            if (char == '+' || char == '-' || char == '/' || char == '*') {
                break
            }
            i--
        }
        if (dotFound) {
            val dotIndex = i
            i = input.length - 1
            while (i > dotIndex) {
                if (res[i] == '0') {
                    res = res.substring(0, i) + res.substring(i + 1)
                } else {
                    break
                }
                i--
            }
            if (res[i] == '.') {
                res = res.substring(0, i)
            }
        }
        return res
    }


    fun isNumericSubstring(str: String, startIndex: Int): Boolean {
        var i = startIndex
        if (str[i] == '-') {
            i++
            if (i >= str.length || !str[i].isDigit()) {
                return false
            }
        }
        var dotCount = 0
        var lastDigitIndex = -1
        while (i < str.length) {
            val ch = str[i]
            if (ch.isDigit()) {
                lastDigitIndex = i
            } else if (ch == '.') {
                dotCount++
                if (dotCount > 1 || i == startIndex || (lastDigitIndex >= 0 && i == lastDigitIndex + 1 && str.substring(lastDigitIndex + 1, i) == "0")) {
                    return false
                }
            } else {
                return false
            }
            i++
        }
        return true
    }
    fun check_len(str: String): Int{
        if(str.length>=20){
            Toast.makeText(this, "Zbyt dużo liczb wpisanych!", Toast.LENGTH_SHORT).show()
            return 1
        }
        return 0
    }
}