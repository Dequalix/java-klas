package org.example.Labs.h7.Models;

import org.example.Labs.h7.Manager.BankAccountManager;
import org.example.Labs.h7.Manager.BankManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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


}