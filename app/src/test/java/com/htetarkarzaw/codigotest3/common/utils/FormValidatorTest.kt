package com.htetarkarzaw.codigotest3.common.utils

import org.junit.Assert.*

import org.junit.Test

class FormValidatorTest {

    @Test
    fun `empty phone number returns false`() {
        val result = FormValidator.isVerifiedPhoneNumber(
            phone = ""
        )
        assertFalse(result)
    }

    @Test
    fun `phone number length below 8 returns false`() {
        val phone = "12345"
        val result1 = FormValidator.isVerifiedPhoneNumber(
            phone = phone
        )
        assertFalse(result1)
    }

    @Test
    fun `unselect dob returns false`() {
        val result = FormValidator.isDobSelected(
            dob = ""
        )
        assertFalse(result)
    }

    @Test
    fun `invalid email return false`() {
        val result1 = FormValidator.isVerifiedEmail(
            email = "!tp@gmail.com"
        )
        val result2 = FormValidator.isVerifiedEmail(
            email = "gmail.com"
        )
        val result3 = FormValidator.isVerifiedEmail(
            email = "tp@gmail"
        )
        val result4 = FormValidator.isVerifiedEmail(
            email = "t p@gmail.com"
        )
        val result5 = FormValidator.isVerifiedEmail(
            email = "1234/@gmail.com"
        )
        val result6 = FormValidator.isVerifiedEmail(
            email = "thawzinoojanuary@gmail.com"
        )
        assertFalse(result1)
        assertFalse(result2)
        assertFalse(result3)
        assertFalse(result4)
        assertFalse(result5)
        assertTrue(result6)
    }

    @Test
    fun isVerifiedFullName() {
    }

    @Test
    fun isVerifiedLastName() {
    }

    @Test
    fun isDobSelected() {
    }

    @Test
    fun isVerifiedEmail() {
    }
}