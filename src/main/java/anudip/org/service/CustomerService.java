package anudip.org.service;

import anudip.org.dao.CustomerDAO;
import anudip.org.model.Customer;

import java.sql.SQLException;

public class CustomerService {
    private CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void createCustomer(Customer customer) throws SQLException {
        customerDAO.createCustomer(customer);
    }

    // Other methods to manage Customer
}
