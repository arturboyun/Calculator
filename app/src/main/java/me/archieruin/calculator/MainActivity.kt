package me.archieruin.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_0.setOnClickListener{ setTextFields("0") }
        btn_1.setOnClickListener{ setTextFields("1") }
        btn_2.setOnClickListener{ setTextFields("2") }
        btn_3.setOnClickListener{ setTextFields("3") }
        btn_4.setOnClickListener{ setTextFields("4") }
        btn_5.setOnClickListener{ setTextFields("5") }
        btn_6.setOnClickListener{ setTextFields("6") }
        btn_7.setOnClickListener{ setTextFields("7") }
        btn_8.setOnClickListener{ setTextFields("8") }
        btn_9.setOnClickListener{ setTextFields("9") }
        dot_btn.setOnClickListener{ setTextFields(".") }
        minus_btn.setOnClickListener{ setTextFields("-")}
        plus_btn.setOnClickListener{ setTextFields("+")}
        multi_btn.setOnClickListener{ setTextFields("*")}
        divide_btn.setOnClickListener{ setTextFields("/")}
        bracket_open_btn.setOnClickListener{ setTextFields("(")}
        bracket_close_btn.setOnClickListener{ setTextFields(")")}

        clear_btn.setOnClickListener{
            math_operation.text = ""
            result_text.text = ""
        }

        back_btn.setOnClickListener{
            val str = math_operation.text.toString()
            if (str.isNotEmpty())
                math_operation.text = str.substring(0, str.length-1)
            result_text.text = ""
        }

        equal_btn.setOnClickListener{
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()
                val result = ex.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble())
                    result_text.text = longResult.toString()
                else
                    result_text.text = result.toString()
            } catch (e:Exception) {
                Log.d("Error", e.message.toString())
                result_text.text = "Ошибка!"
            }
        }
    }

    private fun setTextFields(str: String) {
        math_operation.append(str)
    }
}
