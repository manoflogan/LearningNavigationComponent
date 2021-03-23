package com.krishnanand.kotlinfundamentals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

class MainFragment: Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = layoutInflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        setOnClickListener(view, R.id.send_money_btn)
        setOnClickListener(view, R.id.view_transactions_btn)
        setOnClickListener(view, R.id.view_balance_btn)
    }

    private fun setOnClickListener(view: View, resId: Int) {
        view.findViewById<Button>(resId).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v ?: return
        when(v.id) {
            R.id.view_transactions_btn -> navController.navigate(R.id.action_fragment_main_to_viewTransactionFragment)
            R.id.send_money_btn -> navController.navigate(R.id.action_fragment_main_to_chooseRecipientFragment)
            R.id.view_balance_btn -> navController.navigate(R.id.action_fragment_main_to_viewBalanceFragment2)
        }
    }
}