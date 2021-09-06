package com.rijan.rijanshrestha_jobfinder.user

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.common.internal.Constants
import com.google.android.material.snackbar.Snackbar
import com.rijan.rijanshrestha_jobfinder.Constants.READ_STORAGE_PERMISSIONS_CODE
import com.rijan.rijanshrestha_jobfinder.R
import kotlinx.android.synthetic.main.activity_user_profile.*
import java.util.jar.Manifest

private const val FILE_PICKER_ID = 12
private const val PERMISSION_REQUEST = 10
class UserProfileActivity : AppCompatActivity() {
    private var permissions = arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE)
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)
        context = this

        iv_userpic.setOnClickListener{
            if(checkPermission(context,permissions)){
                Toast.makeText(context, "Permissions are already provided", Toast.LENGTH_SHORT).show()
            }else{
                requestPermissions(permissions, PERMISSION_REQUEST)
            }
        }
    }

    fun checkPermission(context: Context,permissionArray:Array<String>):Boolean{
        return false
    }
}


