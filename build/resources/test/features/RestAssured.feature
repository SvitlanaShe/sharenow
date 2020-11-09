Feature:Verify GET operation using REST_Assured

  Scenario Outline: Verify GET response for resource interiorLightsFront
    Given I perform GET operation on resource <resource>
    Then response status is <expectedStatus>
    And <resource> value is <valueExpected>
    And <resource> timestamp is <timestampExpected>
    Examples:
      | resource              | expectedStatus | valueExpected | timestampExpected |
      | "interiorLightsFront" | 200            | "false"       | 1541080800000     |

  Scenario: Verify 404 error on non-exists resource
    Given I perform GET operation on resource "nonExists"
    Then response status is 404