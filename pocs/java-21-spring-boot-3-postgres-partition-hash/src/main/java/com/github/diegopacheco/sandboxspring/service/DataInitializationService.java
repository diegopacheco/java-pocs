package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.domain.User;
import com.github.diegopacheco.sandboxspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializationService implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.count() < 20) {
            System.out.println("Adding additional sample users for partitioning demonstration...");
            
            String[] names = {
                "Michael Scott", "Dwight Schrute", "Jim Halpert", "Pam Beesly",
                "Ryan Howard", "Andy Bernard", "Kevin Malone", "Oscar Martinez",
                "Angela Martin", "Phyllis Vance", "Stanley Hudson", "Meredith Palmer",
                "Creed Bratton", "Kelly Kapoor", "Toby Flenderson"
            };
            
            String[] domains = {"company.com", "office.com", "business.org", "work.net"};
            
            for (int i = 0; i < names.length; i++) {
                String email = names[i].toLowerCase().replace(" ", ".") + "@" + domains[i % domains.length];
                if (userRepository.findByEmail(email) == null) {
                    User user = new User(names[i], email);
                    userRepository.save(user);
                }
            }
            
            System.out.println("Sample data initialization completed. Total users: " + userRepository.count());
        } else {
            System.out.println("Database already contains sample data. Total users: " + userRepository.count());
        }
    }
}