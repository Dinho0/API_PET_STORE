package org.example;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.mapper.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private Response response;
    private JsonPath jsonPath = null;
    private String baseUrl = "https://petstore3.swagger.io/api/v3/";


    public void getPet(Integer id)
    {
        assertTrue( true );
        response =
                given()
                        .body("")
                        .when()
                        .get(baseUrl+"pet/"+id);
    }

    public void addNewPet(Pet pet) throws JsonProcessingException {
    //create an objectMapper for serialization and mapping of the POJO classes
    com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

    //serialize json object
    String petJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pet);

    //add the created pet by making the API call
    response=  given()
        .header("Content-Type","application/json")
        .body(petJson)
        .when()
        .post(baseUrl+"pet");

    //assert that the call was successful with response code 200
    assertEquals(200, response.getStatusCode());


    }

    public void updatePet(Pet pet ) throws JsonProcessingException {
        getPet(pet.getId());

        //save response body into a string and display the API call and response.
        String jsonResponse = response.getBody().asString();

        //create an objectMapper for serialization and mapping of the POJO classes
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

        //de-serialize json object
        Pet newPetRequestBody = objectMapper.readValue(jsonResponse, Pet.class);

        newPetRequestBody.setName(pet.getName());

        //add the created pet by making the API call
        response=  given()
                .header("Content-Type","application/json")
                .body(newPetRequestBody)
                .when()
                .put(baseUrl+"pet");

        // assert that the call was successful with response code 200
        assertEquals(200, response.getStatusCode());

    }

    public void updatePetStatus(Pet pet ) throws JsonProcessingException {
    getPet(pet.getId());

    //save response body into a string and display the API call and response.
    String jsonResponse = response.getBody().asString();

    //create an objectMapper for serialization and mapping of the POJO classes
    com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

    //de-serialize json object
    Pet newPetRequestBody = objectMapper.readValue(jsonResponse, Pet.class);

    newPetRequestBody.setStatus(pet.getStatus());

    //add the created pet by making the API call
    response=  given()
            .header("Content-Type","application/json")
            .body(newPetRequestBody)
            .when()
            .put(baseUrl+"pet");

    // assert that the call was successful with response code 200
    assertEquals(200, response.getStatusCode());

}
    public void deletePet(Pet pet ) throws JsonProcessingException {
        //create an objectMapper for serialization and mapping of the POJO classes
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

        //serialize json object
        String petJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pet);

        //add the created pet by making the API call
        response=  given()
                .header("Content-Type","application/json")
                .when()
                .delete(baseUrl+"pet/"+pet.getId());

        //assert that the call was successful with response code 200
        assertEquals(200, response.getStatusCode());


    }
    public void validateResponseDataIsEqualToRequestData(Pet petRequest) throws JsonProcessingException {

    assertEquals(200, response.getStatusCode());

    //save response body into a string and display the API call and response.
    String jsonResponse = response.getBody().prettyPrint();


    //create an objectMapper for serialization and mapping of the POJO classes
    com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

    //de-serialize json object
    Pet petResponse = objectMapper.readValue(jsonResponse, Pet.class);

    assertEquals(200, response.getStatusCode());
    assertEquals("The Pet id ", petRequest.getId(), petResponse.getId());
    assertEquals("The Pet name ", petRequest.getName(), petResponse.getName());
    assertEquals("The Pet Category ", petRequest.getCategory().getName(), petResponse.getCategory().getName());
    assertEquals("The Pet Photo url ", petRequest.getPhotoUrls(), petResponse.getPhotoUrls());
    assertEquals("The Pet status ", petRequest.getStatus(), petResponse.getStatus());


    System.out.println("Pet Id : "+petResponse.getId());
    System.out.println("Pet Name : "+petResponse.getName());
    System.out.println("Pet Category : "+petResponse.getCategory().getName());
    System.out.println("Pet Status : "+petResponse.getStatus());


    }

    public void validateNameUpdateResponse(Pet petRequest) throws JsonProcessingException {

        assertEquals(200, response.getStatusCode());

        //save response body into a string and display the API call and response.
        String jsonResponse = response.getBody().prettyPrint();


        //create an objectMapper for serialization and mapping of the POJO classes
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

        //de-serialize json response
        Pet petResponse = objectMapper.readValue(jsonResponse, Pet.class);

        assertEquals(200, response.getStatusCode());
        assertEquals("The Pet id ", petRequest.getId(), petResponse.getId());
        assertEquals("The Pet name ", petRequest.getName(), petResponse.getName());


        System.out.println("Pet Id : "+petResponse.getId());
        System.out.println("Pet Name : "+petResponse.getName());
        System.out.println("Pet Category : "+petResponse.getCategory().getName());
        System.out.println("Pet Status : "+petResponse.getStatus());

    }

    public void validateStatusUpdateResponse(Pet petRequest) throws JsonProcessingException {

        assertEquals(200, response.getStatusCode());

        //save response body into a string and display the API call and response.
        String jsonResponse = response.getBody().prettyPrint();


        //create an objectMapper for serialization and mapping of the POJO classes
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();

        //de-serialize json response
        Pet petResponse = objectMapper.readValue(jsonResponse, Pet.class);

        assertEquals(200, response.getStatusCode());
        assertEquals("The Pet id ", petRequest.getId(), petResponse.getId());
        assertEquals("The Pet name ", petRequest.getStatus(), petResponse.getStatus());


        System.out.println("Pet Id : "+petResponse.getId());
        System.out.println("Pet Name : "+petResponse.getName());
        System.out.println("Pet Category : "+petResponse.getCategory().getName());
        System.out.println("Pet Status : "+petResponse.getStatus());

    }

    public void validatePetDelete(Pet pet) throws JsonProcessingException {
        getPet(pet.getId());
        assertEquals(404, response.getStatusCode());
        assertEquals("The Pet is ", "Pet not found", response.getBody().print());

        System.out.println("The pet has been successfully deleted : "+response.getBody().prettyPrint());

    }
}
