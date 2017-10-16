package kaxiaosu.izx.mytestkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        init()
    }

    private fun init() {
        var bundle = intent.getBundleExtra("mBundle")
        mTvTestName.text = "嗨 " + bundle.getString("userName") + " 你好！"
    }
}
