@TableFilter
Feature: Table Filter
  In order to validate the table filter function
  As a user
  I want to click on the filter buttons

  @smoke
  Scenario Outline: Validate "<Color>" button working as excpected
    Given The user is at "https://www.seleniumeasy.com/test/table-records-filter-demo.html"
    When The user clicks on the "<Color>" filter button
    Then There should be only "<Color>" type of records in the table
    
		Examples:
		| Color  |
		| Green  |
		| Orange |
		| Red    |
    
	@smoke
  Scenario Outline: Validate All button working as excpected
    Given The user is at "https://www.seleniumeasy.com/test/table-records-filter-demo.html"
    When The user clicks on the "<Color>" filter button
    Then There should be only "<Color>" type of records in the table
    When The user clicks on the All filter button
    Then There should be all types of records in the table
    
		Examples:
		| Color  |
		| Green  |
		| Orange |
		| Red    |
