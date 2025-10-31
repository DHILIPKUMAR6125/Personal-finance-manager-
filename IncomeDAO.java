import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO {
    private Connection connection;

    public IncomeDAO(Connection connection) {
        this.connection = connection;
    }

    public void addIncome(Income income) throws SQLException {
        String query = "INSERT INTO income (date, amount, source) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, income.getDate());
        statement.setDouble(2, income.getAmount());
        statement.setString(3, income.getSource());
        statement.executeUpdate();
    }

    public List<Income> getAllIncome() throws SQLException {
        String query = "SELECT * FROM income";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<Income> incomeList = new ArrayList<>();

        while (resultSet.next()) {
            Income income = new Income();
            income.setId(resultSet.getInt("id"));
            income.setDate(resultSet.getString("date"));
            income.setAmount(resultSet.getDouble("amount"));
            income.setSource(resultSet.getString("source"));
            incomeList.add(income);
        }

        return incomeList;
    }
}
