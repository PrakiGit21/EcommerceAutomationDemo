Feature: Add to Cart Scenarios

  @UITest
  Scenario: 1: Add random items to cart and remove least priced item from cart
    Given I add four random items to cart
    When I view my cart
    Then I find total four items listed in my cart
    When I search for lowest price item
    And I am able to remove the lowest price item from my cart
    Then I am able to verify three items in my cart
