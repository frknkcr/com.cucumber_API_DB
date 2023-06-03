package stepDefinitions.db;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

import static utilities.DBUtils.closeConnection;
import static utilities.DBUtils.createConnection;

public class CommonDB {

    ResultSet resultSet;
    String resultString;
    @Given("Establishes connection with database")
    public void establishes_connection_with_database() {

        String query="SELECT t1.driver_name\n" +
                "FROM (\n" +
                "    SELECT id, driver_name, \n" +
                "\t\tROW_NUMBER() OVER (ORDER BY manufacture_year ASC) AS rn\n" +
                "    FROM heallife_hospitaltraining.vehicles\n" +
                ") AS t1\n" +
                "JOIN (\n" +
                "    SELECT id, ROW_NUMBER() OVER (ORDER BY created_at ASC) AS rn\n" +
                "    FROM heallife_hospitaltraining.vehicles\n" +
                ") AS t2 ON t1.id = t2.id AND t1.rn = t2.rn;";
        try {

            resultSet= DBUtils.getStatement().executeQuery(query);
            resultSet.absolute(0);
            resultSet.next();
            resultString=resultSet.getString(1);
            System.out.println(resultString);

        } catch (SQLException e) {
            throw new RuntimeException(e);



        }

    }

    @Then("Sorting the lists confirms that both indexes are in the same order")
    public void sortingTheListsConfirmsThatBothIndexesAreInTheSameOrder() {
        Assert.assertEquals("team108",resultString);
    }

    @And("Database close")
    public void databaseClose() {
        closeConnection();
    }
    @Given("Database connection established")
    public void database_connection_established() {
        createConnection();
    }
    @Then("In the birth report table on the database, it is verified that the number of babies with a weight of two and a half kg and above is {int}")
    public void ınTheBirthReportTableOnTheDatabaseItIsVerifiedThatTheNumberOfBabiesWithAWeightOfTwoAndAHalfKgAndAboveIs(int count) {

        String query = "SELECT COUNT(weight) AS baby_count\n" +
                "FROM heallife_hospitaltraining.birth_report\n" +
                "WHERE weight >= 2.5;";
        try {
            resultSet = DBUtils.getStatement().executeQuery(query);
            resultSet.absolute(0);
            resultSet.next();
            System.out.println(resultSet.getInt(1));
            Assert.assertEquals(count, resultSet.getInt(1));
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }

    }
    @Then("Database connection is closed")
    public void database_connection_is_closed() {
        closeConnection();
    }
    @Then("It is verified that the doctor with staff_id=iki in the doctor_shift table on the database works for {int} hours on Tuesday.")
    public void ıtIsVerifiedThatTheDoctorWithStaff_idIkiInTheDoctor_shiftTableOnTheDatabaseWorksForHoursOnTuesday(int calismaSaati) {
        String query="SELECT  SUM(TIMEDIFF(end_time, start_time))/10000 AS calisma_suresi\n" +
                "FROM heallife_hospitaltraining.doctor_shift\n" +
                "where staff_id=2 and day='Tuesday'; ";
        try {
            resultSet=DBUtils.getStatement().executeQuery(query);
            resultSet.absolute(0);
            resultSet.next();
            System.out.println(resultSet.getInt(1));
            Assert.assertEquals(calismaSaati,resultSet.getInt(1));
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    @When("the vehicles in the vehicles table are sorted by manufacture_year and created_at, it is verified that they are vehicles in the same index in both lists.")
    public void theVehiclesInTheVehiclesTableAreSortedByManufacture_yearAndCreated_atItIsVerifiedThatTheyAreVehiclesInTheSameIndexInBothLists() {
        String query = "SELECT t1.driver_name\n" +
                "FROM (\n" +
                "    SELECT id, driver_name, \n" +
                "\t\tROW_NUMBER() OVER (ORDER BY manufacture_year ASC) AS rn\n" +
                "    FROM heallife_hospitaltraining.vehicles\n" +
                ") AS t1\n" +
                "JOIN (\n" +
                "    SELECT id, ROW_NUMBER() OVER (ORDER BY created_at ASC) AS rn\n" +
                "    FROM heallife_hospitaltraining.vehicles\n" +
                ") AS t2 ON t1.id = t2.id AND t1.rn = t2.rn;";
        try {
            // DB_Utils.getConnection();
            resultSet = DBUtils.getStatement().executeQuery(query);
            System.out.println(resultSet);
            resultSet.absolute(0);
            resultSet.next();
            String resultString = resultSet.getString(1);
            System.out.println(resultString);
            Assert.assertEquals("team108", resultString);
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
}
