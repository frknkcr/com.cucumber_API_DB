

  Feature: API US20 As an administrator, I should be able to access the relevant expenditure data by entering the id over the API connection .

    Scenario: TC_001 When a GET body is sent to ExpenseHeadById endpoint with valid authorization information and correct data,
    it should be verified that the status code returned is 200 and the message information in the response body is "Success"

      Given Api kullanicisi "api/profile/allCountries" path parametreleri set eder

    Scenario: TC_002 When sending a GET body with invalid authorization information and invalid data to the ExpenseHeadById endpoint,
    it should be verified that the status code returned is 403 and the message information in the response body is "failed"

      Given AllCountries icin Get request gonderilir

    Scenario: TC_003 in the response body (id, exp_category , description , is_active , is_deleted , created_at ) must be verified .

      Given {string} endpoint'ine gecerli authorization bilgileri ile bir GET request gönderilir