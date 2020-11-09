Feature: feature to test Share Now Registration page

  Background:
    Given user is on ShareNow home page
    When accept banner
    And user clicks the button 'Choose a Country'
    Then user sees country list
    When user selects a city "Berlin"
    And user selects language "engLish"
    And user clicks 'Join for free' button
    Then registration page is opened

  Scenario: User gets errors when mandatory fields are not filled
    When user clicks on "Register Now" button
    Then 15 error(s) are shown for mandatory fields
    And close driver

  Scenario Outline: User is able to reach Payment page when mandatory data added
    When user selects "addressCountryIsoCode" "<addressCountryIsoCode>" on Registration page
    And user selects "language" "<language>" on Registration page
    And user selects "salutation" "<salutation>" on Registration page
    And user selects "birthDate" "<birthDate>" on Registration page

    And user types "email" "<email>" on Registration page
    And user types "password" "<password>" on Registration page
    And user types "pin" "<pin>" on Registration page
    And user types "firstName" "<firstName>" on Registration page
    And user types "lastName" "<lastName>" on Registration page

    And user types "birthPlace" "<birthPlace>" on Registration page
    And user types "addressStreet" "<addressStreet>" on Registration page
    And user types "addressZipCode" "<addressZipCode>" on Registration page
    And user types "addressCity" "<addressCity>" on Registration page
    #as mobilePhone parameter send a lengths of mobile phone without country code
    And user types "mobilePhone" "<mobilePhone>" on Registration page

    And user clicks on "Register Now" button
    Then 1 error(s) are shown for mandatory fields
    When user checks GDPR checkbox
    And user clicks on "Register Now" button
    Then Payment page is opened

    Examples:
      | addressCountryIsoCode | language | email             | password       | pin  | salutation | firstName | lastName | birthDate  | birthPlace | addressStreet            | addressZipCode | addressCity | mobilePhone |
      | DE                    | en       | test-%s@gmail.com | password123!@# | 1234 | FRAU       | First     | Last     | 26.10.1998 | Berlin     | Oranienburger strasse 23 | 12344          | Berlin      | 9           |
