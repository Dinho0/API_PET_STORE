Feature: Pet
  @createNew @runAll
  Scenario Outline: Adding new Pets
    Given I have new pet with <id> and "<name>"
    And I have category id as <category_id> and category name as "<category_name>"
    And I have tag id as <tag_id> and tage name as "<tag_name>"
    And I have photo url as "<photo_url>"
    And I have status as "<status>"
    When I create new pet
    Then pet should be successfully created with the right data.

    Examples:
    |id|name|category_id|category_name|tag_id|tag_name|photo_url|status|
    |23|meow|2          |cat          |2     |meowCats|[https://google.com]|available|

  @updateName @runAll
  Scenario Outline: Update  Pets Name
    Given I have an existing pet with <id>
    When I update pet_name as "<pet_name>" for pet <id>
    Then pet name should be successfully updated with the right data.

    Examples:
      |id|pet_name|
      |11|pur|

  @updateStatus @runAll
  Scenario Outline: Update  Pets Status
    Given I have an existing pet with <id>
    When I want to update status as "<status>"
    Then pet status should be successfully updated with the right data.

    Examples:
      |id|status|
      |11|sold|

  @deletePet @runAll
  Scenario Outline: Delete  Pets Status
    Given I have an existing pet with <id>
    When I delete pet
    Then pet status should be successfully removed

    Examples:
      |id|
      |10|