package anudip.org.dao;

import anudip.org.model.Branch;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BranchDAO {
    private Connection connection;

    public BranchDAO(Connection connection) {
        this.connection = connection;
    }

    public void createBranch(Branch branch) throws SQLException {
        String sql = "INSERT INTO Branch (BranchId, Name, Address, BankCode) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, branch.getBranchId());
            ps.setString(2, branch.getName());
            ps.setString(3, branch.getAddress());
            ps.setString(4, branch.getBankCode());
            ps.executeUpdate();
        }
    }

    // Other CRUD methods
}
