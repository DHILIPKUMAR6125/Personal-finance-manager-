import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {
    private Connection connection;

    public ExpenseDAO(Connection connection) {
        this.connection = connection;
    }

    public void addExpense(Expense expense) throws SQLException {
        String query = "INSERT INTO expenses (date, amount, category) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, expense.getDate());
        statement.setDouble(2, expense.getAmount());
        statement.setString(3, expense.getCategory());
        statement.executeUpdate();
    }

    public List<Expense> getAllExpenses() throws SQLException {
        String query = "SELECT * FROM expenses";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        List<Expense> expenseList = new ArrayList<>();

        while (resultSet.next()) {
            Expense expense = new Expense();
            expense.setId(resultSet.getInt("id"));
            expense.setDate(resultSet.getString("date"));
            expense.setAmount(resultSet.getDouble("amount"));
            expense.setCategory(resultSet.getString("category"));
            expenseList.add(expense);
        }

        return expenseList;
    }
}
