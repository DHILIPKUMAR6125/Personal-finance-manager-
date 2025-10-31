import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BudgetDAO {
    private Connection connection;

    public BudgetDAO(Connection connection) {
        this.connection = connection;
    }

    public void addBudget(Budget budget) throws SQLException {
        String query = "INSERT INTO budget (category, budget_amount) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, budget.getCategory());
        statement.setDouble(2, budget.getBudgetAmount());
        statement.executeUpdate();
    }

    public List<Budget> getAllBudgets() throws SQLException {
        String query = "SELECT * FROM budget";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<Budget> budgetList = new ArrayList<>();

        while (resultSet.next()) {
            Budget budget = new Budget();
            budget.setId(resultSet.getInt("id"));
            budget.setCategory(resultSet.getString("category"));
            budget.setBudgetAmount(resultSet.getDouble("budget_amount"));
            budgetList.add(budget);
        }

        return budgetList;
    }
}
