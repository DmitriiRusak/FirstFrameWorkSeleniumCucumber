Feature: place an order
  # The porpose of that Feature is validating the placement order using the default options,
  # and it does not matter which product we add.
  # so we can use word product and do not use string as a parameter. Because since we do not validate
  # the value of product we are not interesting in the name value of that product.
  #The gherkin should be declarative an not tightly coupled with UI actions
  # Notice that Given step doesnot start from home page
  @Number2
  Scenario: using default payment option
    Given I am a customer
    And my billing details are
      | First name | Last name | Country   | Street address | Town      | Department  | Email address       |
      | Dimas      | Thander   | Guatemala | Zelenaia       | Mosty     | El Progreso | myEmail@gmail.com   |
#      | Bambas     | Rus       | Guatemala | Krasnaia       | Bykshtava | Jalapa      | notMyEmail@gmail.com|
    And I have a product in the cart
    And I am on the checkout page
    When I provide Billing details
    And I place an order
    Then The order schould be placed successfuly