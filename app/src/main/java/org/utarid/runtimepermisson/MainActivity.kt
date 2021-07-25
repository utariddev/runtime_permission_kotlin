package org.utarid.runtimepermisson

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.utarid.runtimepermisson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE: Int = 1
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding!!.root
        setContentView(view.rootView)

        binding!!.btnRequestPermisson.setOnClickListener {
            requestPerm()
        }
    }

    private fun requestPerm() {
        if (ContextCompat.checkSelfPermission(
                applicationContext,
                Manifest.permission.READ_CONTACTS
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // user has already given permission
        } else {
            // ask for the permission.
            requestPermissions(
                arrayOf(Manifest.permission.READ_CONTACTS),
                REQUEST_CODE
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CODE -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)
                ) {
                    // Permission is granted. Continue the action or workflow in your app.
                } else {
                    // user denied permission
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                        requestPerm()
                    } else {
                        //can not show permission dialog because of user click 'do not ask again'

                        Toast.makeText(this, "can not show permission dialog", Toast.LENGTH_LONG).show()
                    }
                }
                return
            }
        }
    }
}