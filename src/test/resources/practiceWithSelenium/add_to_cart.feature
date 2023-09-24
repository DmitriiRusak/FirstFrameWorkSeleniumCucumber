@First
Feature: add to cart
  Scenario:Add one quantity to the cart.
    Given I am on the store page
    When I add "Blue Shoes" to the cart
    Then I see 1 "Blue Shoes" in the cart

  Scenario Outline:Add multiple quantity to the cart.
    Given I am on the store page
    When I add "<product_name>" to the cart
    Then I see 1 "<product_name>" in the cart
    Examples:
    |product_name    |
    |Basic Blue Jeans|
    |Anchor Bracelet |
    |Black Over-the-shoulder Handbag|
    |Blue Denim Shorts              |
    |Blue Tshirt                    |
    |Boho Bangle Bracelet           |
    |Dark Brown Jeans               |
