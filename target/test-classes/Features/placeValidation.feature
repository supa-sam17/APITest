
Feature: Validating Place APIs
@AddPlace
  Scenario Outline: Verify if place is being successfully added using AddPlaceAPU
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with Post http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    
    Examples:
    |name				|language	|address								|
    |Play House	|Zulu			|Durban, KwazuluNatal		|
    |Gateway		|English	|Umlanga, KwazuluNatal	|
    
    
    
    
    
@Regression
  Scenario Outline: Verify if place is being successfully added using AddPlaceAPU
    Given Add Place Payload with "<name>" "<language>" "<address>"
    When user calls "AddPlaceAPI" with Post http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    
    Examples:
    |name				|language	|address								|
    |Play House	|Afrikaans|Bay, KwazuluNatal			|
    |Balito			|English	|Umlanga, KwazuluNatal	|				