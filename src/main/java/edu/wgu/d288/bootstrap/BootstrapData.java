package edu.wgu.d288.bootstrap;

import edu.wgu.d288.dao.CustomerRepository;
import edu.wgu.d288.dao.DivisionRepository;
import edu.wgu.d288.entities.Customer;
import edu.wgu.d288.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootstrapData(CustomerRepository customerRepository,
                         DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) {


        if (customerRepository.count() > 0) {
            return;
        }


        List<Division> divisions = divisionRepository.findAll();

        if (divisions.size() < 3) {
            System.out.println("⚠️ Not enough divisions found. Customers not inserted.");
            return;
        }

        Division d1 = divisions.get(0);
        Division d2 = divisions.get(1);
        Division d3 = divisions.get(2);

        Customer c1 = new Customer("John", "Doe", "133 Main St", "30301", "4041234567", d1);
        Customer c2 = new Customer("Jane", "Smith", "456 Oak Ave", "30302", "4042345678", d2);
        Customer c3 = new Customer("Mike", "Brown", "389 Pine Rd", "30303", "4043456789", d3);
        Customer c4 = new Customer("Emily", "Johnson", "321 Maple St", "30304", "4044567890", d1);
        Customer c5 = new Customer("David", "Wilson", "654 Cedar Ln", "30305", "4045678901", d2);

        customerRepository.save(c1);
        customerRepository.save(c2);
        customerRepository.save(c3);
        customerRepository.save(c4);
        customerRepository.save(c5);

        System.out.println("Sample customers inserted");
    }
}
