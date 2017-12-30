
package com.example.rbsbkotlin.controller

import com.example.rbsbkotlin.model.Resume
import com.example.rbsbkotlin.repository.ResumeRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class ResumeController(private val resumeRepository: ResumeRepository) {

    val counter = AtomicLong()

    /* @GetMapping("/resume/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Resume("Hello, $name", "Resume")
	*/

    @GetMapping("/resume")
    fun getAllResumes(): List<Resume> =
            resumeRepository.findAll()
    
    /*
    @RequestMapping("/resume/{resumeId}")
    fun getResumeById(@PathVariable("resumeId") resumeId: Long): ResponseEntity<Resume> {
        return resumeRepository.findById(resumeId).map { resume -> 
            ResponseEntity.ok(resume)
        }.orElse(ResponseEntity.notFound().build())
    }
    */

}
