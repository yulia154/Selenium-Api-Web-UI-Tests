@feature
Feature: CRUD API

  @API
  Scenario: get user data with valid user id
    Given user set endpoint with 'get' and '60d0fe4f5311236168a109ca'
    When user hit get API
    Then user should get status code 200
    And user should get the correct response as 'JsonSchemaGetUserInfo.json'

  @API
  Scenario: get user data with invalid user id
    Given user set endpoint with 'get' and '123'
    When user hit get API
    Then user should get status code 400
    And user should get error message 'PARAMS_NOT_VALID'

  @API
  Scenario: create user with valid values
    Given user set 'post' endpoint
    When user hit post API
    Then user should get status code 200
    And user should get the correct response as 'JsonSchemaGetUserInfo.json'
    And the response should have the correct value

  @API
  Scenario: update user data
    Given user set endpoint with 'update' and '6649a0ab7cdda7d1c059e088'
    And user set first name with 'new name'
    When user hit PUT API
    Then user should get status code 200
    And user should get the correct response as 'JsonSchemaGetUserInfo.json'
    And user data should be updated

  @API
  Scenario: delete user data
    Given user set 'post' endpoint
    And user hit post API
    And User set delete endpoint
    Then user hit DELETE API
    And user should get status code 200
    And the correct user should be deleted

  @API
  Scenario: get list of tags
    Given user set 'tag' endpoint
    When user hit get API
    Then user should get status code 200
    And user should get the correct response as 'JsonSchemaGetListOfTags.json'

  @API
  Scenario: create user with invalid values
    Given user set 'post' endpoint
    When user hit post API with invalid values
    Then user should get status code 400
    And user should get create error messages