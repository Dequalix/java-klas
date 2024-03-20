package org.example.Models;

import org.example.Manager.BankAccountManager;
import org.example.Manager.BankManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BankTest {
//    private Bank sut;
    private Bank sut;
    private BankAccountManager mockAccountManager;

    @BeforeEach
    void setup() {
        sut = new Bank("ABN");
        mockAccountManager = mock(BankAccountManager.class);


    }


    @Test
    void getBankAccount() {
        // Given
        when(mockAccountManager.createBackAccount(sut)).then(mockAccountManager.getBankAccount(1));
        // When
        when(mockAccountManager.getBankAccount(1)).getMock();
        // Then
        verify(mockAccountManager.getBankAccount(1));

    }
}