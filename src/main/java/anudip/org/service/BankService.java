package anudip.org.service;

import anudip.org.dao.BankDAO;
import anudip.org.model.Bank;

import java.sql.SQLException;

public class BankService {
    private BankDAO bankDAO;

    public BankService(BankDAO bankDAO) {
        this.bankDAO = bankDAO;
    }

    public void createBank(Bank bank) throws SQLException {
        bankDAO.createBank(bank);
    }

    // Other methods to manage Bank
}
