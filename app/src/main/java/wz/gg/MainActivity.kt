package wz.gg

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var model:KeyModel?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model=intent.getSerializableExtra("model") as KeyModel
        main_web.loadUrl(model!!.appForwardurl); // 你要回到的那个首页的URL
        tag1_tv.text=model!!.navigationTitle1
        tag2_tv.text=model!!.navigationTitle2
        tag1_tv.setOnClickListener {
            val viewIntent = Intent("android.intent.action.VIEW", Uri.parse(model!!.navigationUrl1))
            startActivity(viewIntent)
        }
        tag2_tv.setOnClickListener {
            val viewIntent = Intent("android.intent.action.VIEW", Uri.parse(model!!.navigationUrl2))
            startActivity(viewIntent)
        }
        home_iv.setOnClickListener {
            main_web.clearHistory(); // 清除
            main_web.loadUrl(model!!.appForwardurl); // 你要回到的那个首页的URL
        }
        go_iv.setOnClickListener {
            main_web.goBack();   //后退
        }
        refresh_iv.setOnClickListener {
            main_web.reload();   //刷新
        }
        back_iv.setOnClickListener {
            main_web.goForward();//前进
        }
    }
}
