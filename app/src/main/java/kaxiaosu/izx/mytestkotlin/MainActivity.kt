package kaxiaosu.izx.mytestkotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        var mBtnLogin = mBtnUserLogin
        mBtnLogin.setOnClickListener { click() }
    }



    private fun click() {
        var mName = mEtUserName.text
        if (!mName.isEmpty()) {
            var testIntent = Intent(this, TestActivity().javaClass)
            var bundle=Bundle()
            bundle.putString("userName", mName.toString())
            testIntent.putExtra("mBundle",bundle)
            startActivity(testIntent)
        } else {
            Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show()
        }
    }

}
