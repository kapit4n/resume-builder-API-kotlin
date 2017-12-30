package com.example.rbsbkotlin.repository

import com.example.rbsbkotlin.model.Resume
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ResumeRepository : JpaRepository<Resume, Long>