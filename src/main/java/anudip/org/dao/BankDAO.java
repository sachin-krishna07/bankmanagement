package anudip.org.dao;

import anudip.org.model.Bank;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankDAO {
    private Connection connection;

    public BankDAO(Connection connection) {
        this.connection = connection;
    }

    public void createBank(Bank bank) throws SQLException {
        String sql = "INSERT INTO Bank (Code, Name, Address) VALUES (?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, bank.getCode());
            ps.setString(2, bank.getName());
            ps.setString(3, bank.getAddress());
            ps.executeUpdate();
        }
    }

    // Other CRUD methods
}
