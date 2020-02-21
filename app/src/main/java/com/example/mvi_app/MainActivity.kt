package com.example.mvi_app

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import arrow.core.Either
import com.example.mvi_app.model.User
import com.example.mvi_app.viewmodel.UserAction
import com.example.mvi_app.viewmodel.UserAction.findUserById
import com.example.mvi_app.viewmodel.UserViewModel
import com.example.mvi_app.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userViewModel: UserViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MviApplication).applicationComponent.satisfyDependenciesFor(this)

        userViewModel = ViewModelProviders.of(this, viewModelFactory).get(UserViewModel::class.java)
//        userViewModel.getUser().observe(this, Observer<User> {
//            if (it != null) {
//                Log.d("JMP", it.name)
//            }
//        })
        userViewModel.run {
            lifecycleScope.launch {
                getState().collect {
                    when (it) {
                        is Either.Right -> printMessage(it.b.name)
                        is Either.Left -> printMessage("ERROR")
                    }
                }
            }
        }

        my_button.run {
            setOnClickListener {
                userViewModel.handleAction(findUserById(2))
            }
        }

    }


    fun printMessage(msg: String) = Log.d("JMP", msg)


}




