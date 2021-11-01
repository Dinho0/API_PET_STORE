package org.example.Steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    @Given("I have pet with {int} and {string}")
    public void i_have_pet_with_and(Integer id, String name) {
        // Write code here that turns the phrase above into concrete actions
        pet.setId(id);
        pet.setName(name);
    }

    @Given("I have category id as {int} and category name as {string}")
    public void i_have_category_id_as_and_category_name_as(Integer category_id, String category_name) {
        // Write code here that turns the phrase above into concrete actions
         category = new Category(category_id, category_name);
         pet.setCategory(category);
    }

    @Given("I have tag id as {int} and tage name as {string}")
    public void i_have_tag_id_as_and_tage_name_as(Integer tag_id, String tag_name) {
        // Write code here that turns the phrase above into concrete actions
        tags = new Tags(tag_id, tag_name);
        tagsList.add(0,tags);
        pet.setTags(tagsList);

    }

    @Given("I have photo url as {string}")
    public void i_have_photo_url_as(String photoUrl) {
        // Write code here that turns the phrase above into concrete actions
        pet.setPhotoUrls(Collections.singletonList(photoUrl));
    }

    @When("I have status as {string}")
    public void i_have_status_as(String status) {
        // Write code here that turns the phrase above into concrete actions
        pet.setStatus(status);
    }

    @When("I create new pet")
    public void iCreateNewPet() throws JsonProcessingException {
        addNewPet(pet);
    }

    @Then("pet should be successfully created with the right data.")
    public void pet_should_be_successfully_created_with_the_right_data() throws JsonProcessingException {
        // Write code here that turns the phrase above into concrete actions
        validateResponseDataIsEqualToRequestData(pet);
    }

    @Given("I have an existing pet with {int}")
    public void i_have_an_existing_pet_with(Integer pet_id) {
        // Write code here that turns the phrase above into concrete actions
        pet.setId(pet_id);

    }

    @When("I update pet_name as {string} for pet {int}")
    public void i_update_pet_name_as_for_pet(String name, Integer id) throws JsonProcessingException {
        // Write code here that turns the phrase above into concrete actions
        pet.setName(name);
        pet.setId(id);
        updatePet(pet);
    }

    @Then("pet name should be successfully updated with the right data.")
    public void pet_name_should_be_successfully_updated_with_the_right_data() throws JsonProcessingException {
        // Write code here that turns the phrase above into concrete actions
        validateNameUpdateResponse(pet);
    }


    @Given("I want to update status as {string}")
    public void i_want_to_update_status_as(String status) throws JsonProcessingException {
        // Write code here that turns the phrase above into concrete actions
        pet.setStatus(status);
        updatePetStatus(pet);
    }

    @Then("pet status should be successfully updated with the right data.")
    public void pet_status_should_be_successfully_updated_with_the_right_data() throws JsonProcessingException {
        // Write code here that turns the phrase above into concrete actions
        validateStatusUpdateResponse(pet);
    }

    @When("I delete pet")
    public void i_delete_pet() throws JsonProcessingException {
        // Write code here that turns the phrase above into concrete actions
        deletePet(pet);
    }

    @Then("pet should be successfully removed.")
    public void pet_should_be_successfully_removed() throws JsonProcessingException {
        // Write code here that turns the phrase above into concrete actions
        validatePetDelete();
    }


}
