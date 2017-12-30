
package com.example.rbsbkotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong

@RestController
class ResumeController {

    val counter = AtomicLong()

    @GetMapping("/resume")
    fun resume(@RequestParam(value = "name", defaultValue = "World") name: String) =
            Resume(counter.incrementAndGet(), "Hello, $name")

}
