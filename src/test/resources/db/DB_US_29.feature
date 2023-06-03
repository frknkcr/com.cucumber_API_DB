

  Feature: DB_US29 Queries data in the database

    Scenario: DB_US29 TC_001 When the vehicles in the vehicles table are listed according to the manufacture_year information,
    verify that there is a vehicle in the same index in both lists.

      Given Database connection established
      When the vehicles in the vehicles table are sorted by manufacture_year and created_at, it is verified that they are vehicles in the same index in both lists.
      And   Database connection is closed