package com.rodricorgom.modulo4practicafinal

import java.io.Serializable

data class Usuario(
    val email : String,
    val password : String,
    val name : String? = null,
    val surname : String? = null,
    val gender : String? = null
): Serializable
