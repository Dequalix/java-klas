package org.example.Labs.h7.Models;

import org.example.Labs.h7.Manager.BankAccountManager;
import org.example.Labs.h7.Manager.BankManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BankTest {

    @Mock
    private BankAccountManager mockAccountManager;
    @Mock
    private BankManager mockBankManager;
    @Mock
    private BankAccount mockBankAccount;
    @InjectMocks
    private Bank sut;

    @BeforeEach
    void setup() {

    }


    @Test
    void getBankAccount() {
        when(mockAccountManager.getBankAccount(anyInt())).thenReturn(new BankAccount(sut));

        verify(mockAccountManager.getBankAccount(anyInt()));
    }

    @Test
    void createBackAccount() {
        when(mockAccountManager.createBankAccount(any())).thenReturn(mockBankAccount);
        verify(mockAccountManager.createBankAccount(any()));
    }


    @Test
    void transferMoney() {
        when(mockAccountManager.createBankAccount(any())).thenReturn(new BankAccount(sut));
        BankAccount a = mockAccountManager.createBankAccount(sut) ;
        BankAccount b = mockAccountManager.createBankAccount(sut);
        a.addBalance(BigDecimal.valueOf(200));

        sut.sendMoneyFromTo(a, b, BigDecimal.valueOf(100));

        verify(mockAccountManager.createBankAccount(any()));
        Assertions.assertEquals(BigDecimal.valueOf(100), a.getBalance());
    }
}