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
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.fragment_choose_recipient.*


class ChooseRecipientFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_choose_recipient, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        view.findViewById<Button>(R.id.next_btn).setOnClickListener(this)
        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v ?: return
        when(v.id) {
            R.id.next_btn -> {
                val recipient = input_recipient.text.toString()
                val bundle = if (!TextUtils.isEmpty(recipient)) {
                   bundleOf(RECIPIENT_BUNDLE_EXTRA to recipient)
                } else {
                    bundleOf()
                }
                navController.navigate(
                    R.id.action_chooseRecipientFragment_to_specifyAmountFragment, bundle)
            }
            R.id.cancel_btn -> activity?.onBackPressed()
        }
    }

    companion object {
        val RECIPIENT_BUNDLE_EXTRA = "name"
    }
}