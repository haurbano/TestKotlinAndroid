package haurbano.movil.restaurant

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import haurbano.movil.restaurant.databinding.ActivityShowMessageBinding
import kotlinx.android.synthetic.main.activity_show_message.*

class ShowMessageActivity : AppCompatActivity() {

    lateinit var binding : ActivityShowMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_show_message)
        showMessage()
    }

    fun showMessage(){
        var message : String = intent.extras["message"].toString()
        txt_message.text = message
    }
}
