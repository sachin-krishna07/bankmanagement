package anudip.org;

import anudip.org.dao.BankDAO;
import anudip.org.model.Bank;
import anudip.org.service.BankService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/banking_system";
        String jdbcUsername = "root";
        String jdbcPassword = "root_password";

        try (Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword)) {
            // Create DAOs and Services
            BankDAO bankDAO = new BankDAO(connection);
            BankService bankService = new BankService(bankDAO);

            // Create a new bank
            Bank bank = new Bank();
            bank.setCode("001");
            bank.setName("Test Bank");
            bank.setAddress("123 Test St");
            bankService.createBank(bank);

            System.out.println("Bank created successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
