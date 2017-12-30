package com.example.rbsbkotlin.model

import org.hibernate.validator.constraints.NotBlank
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class Resume (
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	val id: Long,
	@get: NotBlank
	val title: String,
	@get: NotBlank
	val summary: String
)
