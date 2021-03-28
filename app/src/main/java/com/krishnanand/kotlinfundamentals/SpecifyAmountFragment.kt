package com.krishnanand.kotlinfundamentals

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_specify_amount.*
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    lateinit var recipient: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_specify_amount, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        recipient = arguments?.getString(ChooseRecipientFragment.RECIPIENT_BUNDLE_EXTRA, "") ?: ""
        view.findViewById<Button>(R.id.send_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v ?: return
        when(v.id) {
            R.id.cancel_btn -> activity?.onBackPressed()
            R.id.send_btn -> {
                val amount = input_amount.text.toString()
                val bundle = if (!TextUtils.isEmpty(recipient) && !TextUtils.isEmpty(amount)) {
                    bundleOf("recipient" to recipient, "amount" to Money(BigDecimal(amount)))
                } else {
                    bundleOf()
                }
                navController.navigate(R.id.action_specifyAmountFragment_to_confirmationFragment, bundle)
            }
        }
    }
}