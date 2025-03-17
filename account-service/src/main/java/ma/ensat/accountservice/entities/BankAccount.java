package ma.ensat.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.ensat.accountservice.enums.AccountType;
import ma.ensat.accountservice.model.Customer;

import java.time.LocalDate;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING) // ORDINAL : Stocker 0 pour la 1er valeur 1 pour la deuxieme // STRING: il va stocker les valeurs existants
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;

}
