import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql:                                                   
            IncomeDAO incomeDAO = new IncomeDAO(connection);
            ExpenseDAO expenseDAO = new ExpenseDAO(connection);
            BudgetDAO budgetDAO = new BudgetDAO(connection);

                         
            Income income = new Income();
            income.setDate("//localhost:3306/finance", "username", "password");
            IncomeDAO incomeDAO = new IncomeDAO(connection);
            ExpenseDAO expenseDAO = new ExpenseDAO(connection);
            BudgetDAO budgetDAO = new BudgetDAO(connection);

            // Add income
            Income income = new Income();
            income.setDate("2023-03-01");
            income.setAmount(1000.0);
            income.setSource("Salary");
            incomeDAO.addIncome(income);

                          
            Expense expense = new Expense();
            expense.setDate("// Add expense
            Expense expense = new Expense();
            expense.setDate("2023-03-01");
            expense.setAmount(500.0);
            expense.setCategory("Rent");
            expenseDAO.addExpense(expense);

                         
            Budget budget = new Budget();
            budget.setCategory("// Add budget
            Budget budget = new Budget();
            budget.setCategory("Food");
            budget.setBudgetAmount(500.0);
            budgetDAO.addBudget(budget);
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
