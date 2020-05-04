package com.yly.permissionx

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yly.librarypermission.PermissionX
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mackCall.setOnClickListener {
            PermissionX.request(this,
                android.Manifest.permission.CALL_PHONE){ allGranted,deniedList ->
                    if (allGranted){
                        call()
                    }else{
                        Toast.makeText(this,"没有权限",Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }

    private fun call(){
        try {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:10086")
            startActivity(intent)
        }catch (e:SecurityException){
            e.printStackTrace()
        }
    }
}
