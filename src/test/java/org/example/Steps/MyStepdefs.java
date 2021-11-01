package org.example.Steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.AppTest;
import org.example.Category;
import org.example.Pet;
import org.example.Tags;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyStepdefs extends AppTest {
    Category category= new Category();
    Tags tags = new Tags();
    Pet pet = new Pet();
    List<Tags> tagsList = new ArrayList<>();



//    @Then("pet status should be successfully updated with the right data.")
//    public void pet_status_should_be_successfully_updated_with_the_right_data() throws JsonProcessingException {
//        // Write code here that turns the phrase above into concrete actions
//        validateStatusUpdateResponse(pet);
//    }
//
//    @When("I delete pet")
//    public void i_delete_pet() throws JsonProcessingException {
//        // Write code here that turns the phrase above into concrete actions
//        deletePet(pet);
//    }
//
//    @Then("pet should be successfully removed.")
//    public void pet_should_be_successfully_removed() throws JsonProcessingException {
//        // Write code here that turns the phrase above into concrete actions
//        validatePetDelete();
//    }


    @Given("^I have new pet with (\\d+) and \"([^\"]*)\"$")
    public void i_have_new_pet_with_and(int id, String name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pet.setId(id);
        pet.setName(name);
    }

    @Given("^I have category id as (\\d+) and category name as \"([^\"]*)\"$")
    public void i_have_category_id_as_and_category_name_as(int category_id, String category_name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        category = new Category(category_id, category_name);
        pet.setCategory(category);
    }

    @Given("^I have tag id as (\\d+) and tage name as \"([^\"]*)\"$")
    public void i_have_tag_id_as_and_tage_name_as(int tag_id, String tag_name) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        tags = new Tags(tag_id, tag_name);
        tagsList.add(0,tags);
        pet.setTags(tagsList);
    }

    @Given("^I have photo url as \"([^\"]*)\"$")
    public void i_have_photo_url_as(String photoUrl) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pet.setPhotoUrls(Collections.singletonList(photoUrl));
    }

    @Given("^I have status as \"([^\"]*)\"$")
    public void i_have_status_as(String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pet.setStatus(status);
    }

    @When("^I create new pet$")
    public void i_create_new_pet() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        addNewPet(pet);
    }

    @Then("^pet should be successfully created with the right data\\.$")
    public void pet_should_be_successfully_created_with_the_right_data() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        validateResponseDataIsEqualToRequestData(pet);
    }

    @Given("^I have an existing pet with (\\d+)$")
    public void i_have_an_existing_pet_with(int pet_id) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pet.setId(pet_id);
    }

    @When("^I update pet_name as \"([^\"]*)\" for pet (\\d+)$")
    public void i_update_pet_name_as_for_pet(String name, int id) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pet.setName(name);
        pet.setId(id);
        updatePet(pet);
    }

    @Then("^pet name should be successfully updated with the right data\\.$")
    public void pet_name_should_be_successfully_updated_with_the_right_data() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        validateNameUpdateResponse(pet);
    }

    @When("^I want to update status as \"([^\"]*)\"$")
    public void i_want_to_update_status_as(String status) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        pet.setStatus(status);
        updatePetStatus(pet);
    }

    @Then("^pet status should be successfully updated with the right data\\.$")
    public void pet_status_should_be_successfully_updated_with_the_right_data() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        validateStatusUpdateResponse(pet);
    }

    @When("^I delete pet$")
    public void i_delete_pet() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        deletePet(pet);
    }


    @Then("^pet status should be successfully removed$")
    public void petStatusShouldBeSuccessfullyRemoved() throws JsonProcessingException {
        validatePetDelete(pet);
    }
}
