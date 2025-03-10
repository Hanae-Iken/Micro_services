package ma.ensat.customerservice.web;

import ma.ensat.customerservice.entities.Customer;
import ma.ensat.customerservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {

    //customerRepository est une interface, donc il faut faire l'injection des dependances, pour ce faire
    //on peut soit faire @autowired ( mais n'est pas conseille, car il y aura la deprecation ( comme pour @Data
    // qui peut causer des problemes donc c'est mieux d'utiliser @Getter @Setter)) donc la meilleur facon
    // de faire l'injection des dependances et de la faire via le constructeur d'une maniere explicite ou bien
    // d'utiliser l'annotation @AllArgsConstructor

    private CustomerRepository customerRepository;  //pour ajouter un constructeur cliquer sur alt+Entree

    public CustomerRestController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/customers")   // Pour acceder a cette methode
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id).get();
    }
}
