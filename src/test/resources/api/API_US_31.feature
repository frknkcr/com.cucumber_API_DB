

  Feature: API US31 As an administrator, you can make a new finding via API connection . category registration I want to be able to create .

    Scenario: TC_001  When a POST body with valid authorization information and correct data is sent to the FindingCategory endpoint,
    it should be verified that the status code returned is 200 and the message information in the response body is "Success"

      Given {string} endpoint'ine gecerli authorization bilgileri ile bir GET request gönderilir

    Scenario: TC_002 When a POST body containing invalid authorization information or incorrect data is sent to the FindingCategory endpoint,
    it should be verified that the status code returned is 403 and the message in the response body is "failed"

      Given {string} endpoint'ine gecerli authorization bilgileri ile bir GET request gönderilir

    Scenario: TC_003 via API new finding to be created category your record created , via API should be verified .
      
      Given dönen status code'un {int} oldugu ve response message bilgisinin {string} oldugu dogrulanmali