package ma.ensat.customerservice;

import ma.ensat.customerservice.entities.Customer;
import ma.ensat.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {

        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean //chaque methode qui va s'utiliser avec l'annotation @Bean, elle va s'executee au demmarrage
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {  // C'est une interface fonctionnelle qui contient la methode run
        return args -> {
            // il y a 3 facons pour creer un customer ( utiliser constructeur sans parametre avec setid, set.... ,
            // (ex : Customer customer = new Customer(); customer.setId(); ) ou bien d'utiliser un constructeur
            // avec param ( ex : Customer customer = new Customer (null, "", "");) ou bien d'utiliser @Builder ( design pattern qui fournie une
            // facon pour creer et configuer les obj(surtout obj complexe)

            Customer customer1 = Customer.builder()
                    .firstName("Hassan")
                    .lastName("Elhoumi")
                    .email("hassan@gmail.com")
                    .build();
            customerRepository.save(customer1);

            Customer customer2 = Customer.builder()
                    .firstName("Mohammed")
                    .lastName("Elhannaoui")
                    .email("mohammed@gmail.com")
                    .build();
            customerRepository.save(customer2);

            // ou bien de faire cette meth de list de customers
//            List<Customer> customerList = List.of(
//                    Customer.builder()
//                            .firstName("Hassan")
//                            .lastName("Elhoumi")
//                            .email("hassan@gmail.com")
//                            .build(),
//                    Customer.builder()
//                            .firstName("Mohammed")
//                            .lastName("Elhannaoui")
//                            .email("mohammed@gmail.com")
//                            .build()
//            );
//            customerRepository.saveAll(customerList);

        };
    }

}
