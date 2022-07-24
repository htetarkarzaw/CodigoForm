package com.htetarkarzaw.codigotest3.common.utils

import androidx.core.util.PatternsCompat

object FormValidator {

    fun isVerifiedPhoneNumber(phone: String): Boolean {
        return phone.trim().isNotEmpty() && phone.trim().length > 9
    }

    fun isVerifiedFullName(fullName: String): Boolean {
        return fullName.trim().isNotEmpty()
    }

    fun isVerifiedLastName(lastName: String): Boolean {
        return lastName.trim().isNotEmpty()
    }

    fun isDobSelected(dob: String): Boolean {
        return dob.trim().isNotEmpty()
    }

    fun isVerifiedEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email.trim()).matches()
    }

}