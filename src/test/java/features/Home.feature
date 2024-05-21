@feature
Feature: Home Page

  @WEB-UI
  Scenario: User open contact page
    Given user is on home page
    When user click 'contact'
    Then title 'New message' should be shown

  @WEB-UI
  Scenario: User open about us menu
    Given user is on home page
    When user click 'about us'
    Then title 'About us' should be shown
    
  @WEB-UI
  Scenario: User open cart menu
    Given user is on home page
    When user click 'cart'
    Then title 'Products' should be shown
    
  @WEB-UI
  Scenario: User open login menu
    Given user is on home page
    When user click 'login'
    Then title 'Log in' should be shown
    
  @WEB-UI
  Scenario: User open signup menu
    Given user is on home page
    When user click 'signup'
    Then title 'Sign up' should be shown

  @WEB-UI
  Scenario: User open phone categories
    Given user is on home page
    When user click 'phone'
    Then title 'Samsung galaxy s6' should be shown

  @WEB-UI
  Scenario: User open laptop categories
    Given user is on home page
    When user click 'laptop'
    Then title 'Sony vaio i5' should be shown

  @WEB-UI
  Scenario: User open monitor categories
    Given user is on home page
    When user click 'monitor'
    Then title 'Apple monitor 24' should be shown

  @WEB-UI
  Scenario: User open one of the product and add to cart
    Given user is on home page
    And user click 'product'
    And title 'Product description' should be shown
    And button 'Add to Cart' should be shown
    When user click 'add to cart'
    Then alert 'Product added' should present