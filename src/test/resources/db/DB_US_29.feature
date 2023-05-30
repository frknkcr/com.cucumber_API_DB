

  Feature: DB_US29 Queries data in the database

    Scenario: TC_001 When the vehicles in the vehicles table are listed according to the manufacture_year information, verify that there is a vehicle in the same index in both lists.

      Given Establishes connection with database
      Then Sorting the lists confirms that both indexes are in the same order
      And Database close