package com.shrinvi.mypubinfo.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.shrinvi.mypubinfo.R

class MPISplashActivity : AppCompatActivity() {
 private  lateinit var mLoadingTv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        mLoadingTv = findViewById(R.id.loading_tv)
    }

    override fun onResume() {
        super.onResume()
        showAnimation();
    }
    private fun showAnimation(){
        mLoadingTv.postDelayed(object:Runnable {
            public override fun run(){
                launchHome();
            }
        },5000)
    }
    private fun launchHome(){
        val homeIntent =  Intent(this, MPIHomeActivity::class.java)
        startActivity(homeIntent)
        finish()
    }
}
