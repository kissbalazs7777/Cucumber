@AjaxForm
Feature: Ajax Form
  In order to validate the ajax form
  As a user
  I want to send a comment with a name

  @smoke
  Scenario Outline: Validate Ajax Form working as expected with filled input fields
    Given The user is at "https://www.seleniumeasy.com/test/ajax-form-submit-demo.html"
    When The user types in "<Name>" in the Name input
    And The user types in "<Comment>" in the Comment input
    And The user clicks on the Submit button
    Then There should be a message "Form submited Successfully!"
    
		Examples:
		| Name  | Comment 			  |
		| Balázs| Ez egy komment  |
		| Tamás | Még egy komment |
    
  @smoke
  Scenario Outline: Validate Ajax Form working as expected with empty Name input field
    Given The user is at "https://www.seleniumeasy.com/test/ajax-form-submit-demo.html"
    When The user types in "<Comment>" in the Comment input
    And The user clicks on the Submit button
    Then The Name input should have red border
    And Submit button shouldnt disappear
    
		Examples:
		| Name  | Comment 			  |
		| Balázs| Ez egy komment  |
		| Tamás | Még egy komment |
