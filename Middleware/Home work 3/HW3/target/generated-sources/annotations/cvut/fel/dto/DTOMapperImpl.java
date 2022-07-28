package cvut.fel.dto;

import cvut.fel.entity.Account;
import cvut.fel.entity.Contract;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-28T19:01:51+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 18.0.1.1 (Oracle Corporation)"
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
        accountDTO.setDepositAmount( account.getDepositAmount() );

        return accountDTO;
    }

    @Override
    public ContractDTO contractDto(Contract contract) {
        if ( contract == null ) {
            return null;
        }

        ContractDTO contractDTO = new ContractDTO();

        contractDTO.setId( contract.getId() );
        contractDTO.setName( contract.getName() );
        contractDTO.setNumber( contract.getNumber() );
        contractDTO.setAccount( contract.getAccount() );

        return contractDTO;
    }
}
