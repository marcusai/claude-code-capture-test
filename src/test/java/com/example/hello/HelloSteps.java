package com.example.hello;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloSteps {

    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    private ResponseEntity<String> response;

    @Given("the application is running")
    public void the_application_is_running() {
        // SpringBootTest above already starts the context on a random port.
    }

    @When("I call GET /hello")
    public void i_call_get_hello() {
        response = restTemplate.getForEntity("http://localhost:" + port + "/hello", String.class);
    }

    @Then("I get a 200 response")
    public void i_get_a_200_response() {
        assertThat(response.getStatusCode().value()).isEqualTo(200);
    }

    @And("the response body is {string}")
    public void the_response_body_is(String expected) {
        assertThat(response.getBody()).isEqualTo(expected);
    }
}
