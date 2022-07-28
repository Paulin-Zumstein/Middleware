package cvut.fel.dto;

import cvut.fel.entity.Account;
import cvut.fel.entity.Customer;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-28T10:53:32+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_312 (Private Build)"
)
@Component
public class DTOMapperImpl implements DTOMapper {

    @Override
    public AccountDTO accountToDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountDTO accountDTO = new AccountDTO();

        accountDTO.setId( account.getId() );
        accountDTO.setName( account.getName() );
        accountDTO.setAmount( account.getAmount() );
        accountDTO.setCreation( account.getCreation() );

        return accountDTO;
    }

    @Override
    public CustomerDTO customerToDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setId( customer.getId() );
        customerDTO.setName( customer.getName() );
        customerDTO.setPhonenumber( customer.getPhonenumber() );
        customerDTO.setAccount( customer.getAccount() );

        return customerDTO;
    }
}
