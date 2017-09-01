package haurbano.movil.restaurant

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import haurbano.movil.restaurant.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity(), AnkoLogger {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.handler = this

    }

    fun showAlert(){
        var message : String = edit_message.text.toString()

        if (message.isEmpty()){
            alert {
                customView {
                    linearLayout {
                        orientation =  LinearLayout.VERTICAL
                        imageView{
                            setImageResource(R.mipmap.ic_launcher)
                        }
                        textView{
                            text = "Empty message"
                            textSize = 25f
                            gravity = View.TEXT_ALIGNMENT_CENTER

                        }.lparams(width= matchParent, height = wrapContent)
                    }
                }
                yesButton {  }

            }.show()
        }else{
            alert("Do you want send message?") {
                title="Confirm Alert"
                yesButton { sendMessage(message) }
                noButton { showToast() }
            }.show()
        }
    }

    fun showToast(){
        toast("Message not sent")
    }

    fun sendMessage(message : String){
        startActivity(intentFor<ShowMessageActivity>("message" to message))
    }
}
