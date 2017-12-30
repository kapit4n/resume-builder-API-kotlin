
package com.example.rbsbkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class ResumeController {

    val counter = AtomicLong()

    @GetMapping("/resume/hello")
    fun hello(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Resume(counter.incrementAndGet(), "Hello, $name")

    @GetMapping("/resume")
    fun Resume() = listOf(Resume(counter.incrementAndGet(), "Full Stack Kotlin Developer"))
    
    @RequestMapping("/resume/{resumeId}")
    fun Resume(@PathVariable("resumeId") resumeId: String) =
            Resume(counter.incrementAndGet(), "Full Stack Kotlin Developer $resumeId")

}
