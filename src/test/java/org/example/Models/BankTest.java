package org.example.Models;

import org.example.Manager.BankAccountManager;
import org.example.Manager.BankManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class BankTest {
    private BankAccountManager mockAccountManager;

    @BeforeEach
    void setup() {
        mockAccountManager = mock(BankAccountManager.class);
    }


    @Test
    void getBankAccount() {
        // Given
        // When
        when(mockAccountManager.getBankAccount(anyInt())).thenReturn(mock(BankAccount.class));
        // Then
        verify(mockAccountManager.getBankAccount(anyInt()));
    }
}