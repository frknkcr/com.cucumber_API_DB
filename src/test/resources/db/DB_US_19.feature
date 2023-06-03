

  Feature: DB_US19 Queries data in the database

    Scenario: DB_US19 TC_001 From the database, calculate how many hours the doctor with staff_id=2 in the doctor_shift table works on Tuesday. (2)
      Given Database connection established
      Then It is verified that the doctor with staff_id=iki in the doctor_shift table on the database works for 2 hours on Tuesday.
      And   Database connection is closed
