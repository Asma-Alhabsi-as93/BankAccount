package com.BankAccount.BankAccountByAsma.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Data
public class UpdateCustomerInfo {
    Integer id;
    String name;
    String email;
    Integer phone;
    Boolean isActive;
    Date createdDate;
}
