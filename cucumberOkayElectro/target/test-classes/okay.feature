Feature: shopping website

  Scenario Outline: Reachability of product categories
    Given I am a user of the website
    When I visit the news website
    And I click on the <categoryName> category
    Then I should be taken to <categoryName> category
    And the category should show at least <number> products
    When I click on the first product in the results
    Then I should be taken to the details page for that product
    Examples:
      | categoryName          | number |
      | "Smart elektro"       | 5      |
      | "Velké spotřebiče"    | 5      |
      | "Malé spotřebiče"     | 5      |
      | "Televize"            | 5      |
      | "Mobilní telefony"    | 5      |

  Scenario: Search functionality
    Given I am a user of the website
    When I look up for a product using the term "mobil"
    Then I should see the search results
    And there should be at least 5 products in the search results
    When I click on the first product in the results
    Then I should be taken to the details page for that product

