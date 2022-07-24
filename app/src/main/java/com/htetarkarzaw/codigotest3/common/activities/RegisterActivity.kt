package com.htetarkarzaw.codigotest3.common.activities

import android.content.Context
import android.content.Intent
import com.google.android.material.snackbar.Snackbar
import com.htetarkarzaw.codigotest3.R
import com.htetarkarzaw.codigotest3.common.base.BaseActivity
import com.htetarkarzaw.codigotest3.common.delegate.ChooserDelegate
import com.htetarkarzaw.codigotest3.common.utils.FormValidator
import com.htetarkarzaw.codigotest3.databinding.ActivityRegisterBinding
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog
import java.util.*

class RegisterActivity : BaseActivity<ActivityRegisterBinding>(ActivityRegisterBinding::inflate),
    ChooserDelegate {
    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    private var phonePrefix = "+65"
    private var nationality = ""
    private var residence = ""
    private var dob = ""
    override fun initUi() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.etDOB.setOnClickListener {
            val now: Calendar = Calendar.getInstance()
            val dpd: DatePickerDialog = DatePickerDialog.newInstance(
                { _, year, monthOfYear, dayOfMonth ->
                    val dateOfBirth = "$dayOfMonth/$monthOfYear/$year"
                    dob = dateOfBirth
                    binding.etDOB.setText(dateOfBirth)
                },
                now.get(Calendar.YEAR),  // Initial year selection
                now.get(Calendar.MONTH),  // Initial month selection
                now.get(Calendar.DAY_OF_MONTH) // Initial day selection
            )
            dpd.maxDate = now
            dpd.show(supportFragmentManager, "Datepickerdialog")
        }
        binding.etNationality.setOnClickListener {
            val nationalityList =
                resources.getStringArray(R.array.array_nationality).toMutableList()
            val chooserBSFragment =
                ChooserBottomSheetDialogFragment(this, nationalityList, "nationality")
            chooserBSFragment.isCancelable = false
            chooserBSFragment.show(supportFragmentManager, "nationality_bs_dialog")
        }
        binding.etCountryOfResidence.setOnClickListener {
            val residenceList = resources.getStringArray(R.array.array_Residence).toMutableList()
            val chooserBSFragment =
                ChooserBottomSheetDialogFragment(this, residenceList, "residence")
            chooserBSFragment.isCancelable = false
            chooserBSFragment.show(supportFragmentManager, "residence_bs_dialog")
        }
        binding.btnCreateMyAccountNow.setOnClickListener {
            if (!FormValidator.isVerifiedFullName(binding.etFirstName.text.toString())) {
                Snackbar.make(
                    binding.root,
                    "Enter valid name!",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            if (!FormValidator.isVerifiedLastName(binding.etLastName.text.toString())) {
                Snackbar.make(
                    binding.root,
                    "Enter valid name!",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            if (!FormValidator.isVerifiedEmail(binding.etEmailAddress.text.toString())) {
                Snackbar.make(
                    binding.root,
                    "Enter valid email!",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            if (dob == "") {
                Snackbar.make(
                    binding.root,
                    "Select date of birth!",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            if (nationality == "") {
                Snackbar.make(
                    binding.root,
                    "Select Nationality!",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            if (residence == "") {
                Snackbar.make(
                    binding.root,
                    "Select country of residence!",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            if (!FormValidator.isVerifiedPhoneNumber(binding.etMobileNo.text.toString())) {
                Snackbar.make(
                    binding.root,
                    "Enter valid phone number!",
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }
            var gender = "MR."
            gender = if(binding.rbMale.isChecked){
                "MR."
            }else{
                "MRS."
            }
            val accountString =
                "$gender${binding.etFirstName.text.toString()} ${binding.etLastName.text.toString()}, " +
                        "your are $nationality and from $residence. Your phone number is $phonePrefix${binding.etMobileNo.text.toString()}" +
                        " and email is ${binding.etEmailAddress.text.toString()}"
            Snackbar.make(
                binding.root,
                accountString,
                Snackbar.LENGTH_LONG
            ).show()

        }
    }

    override fun onClickedItem(selectedItem: String, type: String) {
        when (type) {
            "nationality" -> {
                nationality = selectedItem
                binding.etNationality.setText(selectedItem)
            }
            "residence" -> {
                when (selectedItem) {
                    "Singapore" -> phonePrefix = "+65"
                    "Thailand" -> phonePrefix = "+66"
                    "Myanmar" -> phonePrefix = "+95"
                    "Vietnam" -> phonePrefix = "+84"
                    "China" -> phonePrefix = "+86"
                }
                residence = selectedItem
                binding.containerMobileNoInput.prefixText = phonePrefix
                binding.etCountryOfResidence.setText(selectedItem)
            }
        }

    }

    override fun observe() {
    }
}