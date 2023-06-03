
  Feature: DB_US09 Queries data in the database

    Scenario: DB_US09 TC_001 Verify that the number of babies with a weight of 2.5 kg and above is 6 in the birth_report table on the database.

      Given Database connection established
      Then In the birth report table on the database, it is verified that the number of babies with a weight of two and a half kg and above is 6
      And   Database connection is closed