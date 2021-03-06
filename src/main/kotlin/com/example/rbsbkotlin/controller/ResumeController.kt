
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

    @GetMapping("/resumes")
    fun getAllResumes(): List<Resume> =
            resumeRepository.findAll()
    
    
    @RequestMapping("/resumes/{resumeId}")
    fun getResumeById(@PathVariable("resumeId") resumeId: Long): ResponseEntity<Resume> {
        return resumeRepository.findById(resumeId).map { resume -> 
            ResponseEntity.ok(resume)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/resumes")
    fun createNewResume(@Valid @RequestBody resume: Resume): Resume =
        resumeRepository.save(resume)

    @PutMapping("/resumes/{id}")
    fun updateResumeById(@PathVariable(value = "id") resumeId: Long,
                          @Valid @RequestBody newResume: Resume): ResponseEntity<Resume> {

        return resumeRepository.findById(resumeId).map { existingResume ->
            val updatedResume: Resume = existingResume
                    .copy(title = newResume.title, summary = newResume.summary)

            ResponseEntity.ok().body(resumeRepository.save(updatedResume))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/resumes/{id}")
    fun deleteResumeById(@PathVariable(value = "id") resumeId: Long): ResponseEntity<Void> {

        return resumeRepository.findById(resumeId).map { resume  ->
            resumeRepository.delete(resume)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }

}
