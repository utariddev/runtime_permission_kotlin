package org.utarid.runtimepermisson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import org.utarid.runtimepermisson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

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

    }
}