package com.example.blog

import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.AfterAll
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {

    @BeforeAll
    fun setup() {
        println(">> Setup")
    }


    @Test
    fun `Assert blog page title, content and status code`() {
        val entity = restTemplate.getForEntity<String>("/")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains("<h1>Hello From The Blog</h1>")
        assertThat(entity.body).contains("<h1>Hello From Kotlin</h1>")
    }

    @Test
    fun `Assert article page title, content and status code`() {
        println(">> TODO")
    }

    @AfterAll
    fun teardown() {
        println(">> Tear down")
    }
}
