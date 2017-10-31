package wz.gg

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*
import android.webkit.WebView
import android.webkit.WebChromeClient





class MainActivity : AppCompatActivity() {
    var model: KeyModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        model = intent.getSerializableExtra("model") as KeyModel
        main_web.loadUrl(model!!.appForwardurl); // 你要回到的那个首页的URL
        tag1_tv.text = model!!.navigationTitle1
        tag2_tv.text = model!!.navigationTitle2
        tag1_tv.setOnClickListener {
            main_web.loadUrl(model!!.navigationUrl1); // 你要回到的那个首页的URL

//            val viewIntent = Intent("android.intent.action.VIEW", Uri.parse(model!!.navigationUrl1))
//            startActivity(viewIntent)
        }
        tag2_tv.setOnClickListener {
            main_web.loadUrl(model!!.navigationUrl2); // 你要回到的那个首页的URL

//            val viewIntent = Intent("android.intent.action.VIEW", Uri.parse(model!!.navigationUrl2))
//            startActivity(viewIntent)
        }
        main_web.setWebViewClient(WebViewClient());
        main_web.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean { //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                view.loadUrl(url)
                return true
            }
        })
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
        main_web.setWebChromeClient(object : WebChromeClient() {
            override fun onProgressChanged(view: WebView, newProgress: Int) {
                // TODO 自动生成的方法存根

                if (newProgress == 100) {
                    progressBar1.visibility = View.GONE//加载完网页进度条消失
                } else {
                    progressBar1.visibility = View.VISIBLE//开始加载网页时显示进度条
                    progressBar1.progress = newProgress//设置进度值
                }

            }
        })
    }
}
