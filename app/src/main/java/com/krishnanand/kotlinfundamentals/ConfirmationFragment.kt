package com.krishnanand.kotlinfundamentals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_confirmation.*
import java.math.BigDecimal


class ConfirmationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_confirmation, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments ?: return
        val recipient: String = arguments?.getString("recipient", "") ?: ""
        val amount : BigDecimal = (arguments?.getString("amount", "0.00") ?: "0.00").toBigDecimal()
        confirmation_message.text = "${amount} USD was sent to ${recipient}"
    }
}