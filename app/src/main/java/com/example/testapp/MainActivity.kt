package com.example.testapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testapp.presentation.home.HomeFragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            TestAppTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Box(modifier = Modifier.padding(innerPadding)){
//                        AppNavHost()
//                    }
//                }
//            }
//        }
//    }
//}






class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragment = HomeFragment()

        // Get the FragmentManager and start a new transaction
        val fragmentManager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()

        // Add the fragment to the container (replace 'fragment_container' with your container's ID)
        transaction.add(R.id.container, fragment, "home_fragment") // Add with tag

        // Commit the transaction
        transaction.commit()


    }
}

