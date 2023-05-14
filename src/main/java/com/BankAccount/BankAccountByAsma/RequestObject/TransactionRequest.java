package com.BankAccount.BankAccountByAsma.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@Data
public class TransactionRequest {
     Double amount;
     Integer accountNumber;
     Boolean isActive;


}
