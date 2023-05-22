package runners;


import io.cucumber.java.en.Then;
import utilities.DBUtils;

import java.sql.SQLException;

public class RunnerDB {




    @Then("connection")
    public void connection() {

        String query = "";

        try {
            DBUtils.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }



}
