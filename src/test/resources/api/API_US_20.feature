

  Feature: API US20 As an administrator, I should be able to access the relevant expenditure data by entering the id over the API connection .

    Scenario: TC_001 When a GET body is sent to ExpenseHeadById endpoint with valid authorization information and correct data,
    it should be verified that the status code returned is 200 and the message information in the response body is "Success"

      Given API user sets "/api/getExpenseHeadById" path parameters
      And   Verifies that the status code returned when GET request is sent is 200 and the response message information is "Success"

    Scenario: API_US20 TC_002 /api/getExpenseHeadById to your endpoint invalid Status returned when sending a GET body containing authorization information and
    invalid data (id) the code is 403 and the message information in the response body is " failed " must be verified
      Given API user sets "api/getExpenseHeadById" path parameters
      And  Verifies that the status code returned when GET request is sent is 403 and the response message informations is "failed"

    Scenario: API_US20 TC_003 in the response body (id, exp_category , description , is_active , is_deleted , created_at ) must be verified .
      Given API user sets "api/getExpenseHeadById" path parameters
      Then  Saves the result of the Get Request sent by the APi user
      And   Verifies that  "3", "Electricity Bill" , "" , "yes" , "no" , "2021-10-25 09:51:01" must be verified .