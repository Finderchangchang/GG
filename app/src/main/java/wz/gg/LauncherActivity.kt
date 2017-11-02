package wz.gg

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.text.TextUtils
import com.google.gson.Gson
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import okhttp3.Call
import okhttp3.Response
import java.lang.Exception
import java.util.*

class LauncherActivity : AppCompatActivity() {
    private val timer = Timer()
    private var task: TimerTask? = null
    var handler: Handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            OkGo.post("http://103.215.124.200/AppManage/appManageService?id=1")
                    .execute(object : StringCallback() {
                        override fun onSuccess(model: String, call: okhttp3.Call?, response: okhttp3.Response?) {
                            var model=Gson().fromJson(model.replace("[","").replace("]",""),KeyModel::class.java)
                            if(TextUtils.isEmpty(model.navigationStatus)){//跳转到假的主页
                                startActivity(Intent(this@LauncherActivity, JMainActivity::class.java))
                                finish()
                            }else{
                                startActivity(Intent(this@LauncherActivity, MainActivity::class.java)
                                        .putExtra("model",model))
                                finish()
                            }
                            timer.cancel()
                        }

                        override fun onError(call: Call?, response: Response?, e: Exception?) {
                            super.onError(call, response, e)
                        }
                    })
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        task = object : TimerTask() {
            override fun run() {
                val message = Message()
                message.what = 1
                handler.sendMessage(message)
            }
        }
        timer.schedule(task, 3000, 3000);
    }
}
