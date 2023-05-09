package com.BankAccount.BankAccountByAsma.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Data
public class AccountRequest {
    Double balance;
    Integer accountNumber;
    Date createdDate;
    Boolean isActive;
    Integer phoneNumber;

}
