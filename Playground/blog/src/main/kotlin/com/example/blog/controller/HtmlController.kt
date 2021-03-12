package com.example.blog.controller

import com.example.blog.data.Message
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {

    @GetMapping
    fun blog(model: Model): String{
        // we import the org.springframework.ui.set extension function in order to be able to write
        // model["title"] = "Blog" instead of
        // model.addAttribute("title", "Blog")
        model["title"] = "Hello From The Blog"
        model["titletwo"] = "Hello From Kotlin"
        return "blog";
    }

    @GetMapping("/hello")
    fun hello(model : Model): String{
        val message = Message("1", "Hello")
        model["title"] = message.id ?: throw NullPointerException() //model["title"] = message.id!!
        model["greeting"] = message.text
        return "greeting"
    }
}
