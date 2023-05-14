package com.BankAccount.BankAccountByAsma.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class CreditCardInfo {
    Integer cardNumber;
    String customerName;

    Boolean isActive;
}
