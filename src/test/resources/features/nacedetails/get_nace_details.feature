Feature: Get NACE details

  Scenario Outline: Searching for a nace details by order id
    When I fetch nace details for order <order_id>
    Then response.Body should be valid json
    And response.Level should be "<Level>"
    And response.Code should be "<Code>"
    And response.Parent should be null
    And response.Description should be "<Description>"
    And response.This_item_includes should be "<This_item_includes>"
    And response.This_item_also_includes should be null
    And response.Rulings should null
    And response.This_item_excludes should be null
    And response.Reference_to_ISIC_Rev_4 should be "<Reference_to_ISIC_Rev_4>"
    Examples:
      | order_id | Level | Code | Description                       | This_item_includes                                                                                                                                                                                                                                                                                         | Reference_to_ISIC_Rev_4 |
      | 398481   | 1     | A    | AGRICULTURE, FORESTRY AND FISHING | AGRICULTURE, FORESTRY AND FISHING	This section includes the exploitation of vegetal and animal natural resources, comprising the activities of growing of crops, raising and breeding of animals, harvesting of timber and other plants, animals or animal products from a farm or their natural habitats. | A                       |

