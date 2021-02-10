# Distributed Bank


## Repository
<https://github.com/philipjlin/Distributed_Bank>


## Description
Implementation of a server-client distributed system, where the server represents a bank and the clients are represented by individual accounts that the bank keeps track of. The server and clients can all be run on separate systems, and are connected to each other through sockets.


## High Level Components
Bank Server
Client Accounts
Client Services
Thread Manager
Error Manager
Test Cases

## Class Overview
Domain Objects <br>
    - BankServer - Contains main method to set up and connect a bank server socket to a port, which will then accept a number of client connections. <br>

    - BankImpl - Implements an object that keeps track of a map of accounts, and defines methods for adding accounts to the map, returning the accounts/balances. Also defines methods for depositing money to an account and transferring money between separate accounts. <br>

    - AccountImpl - Implements an object that defines an account object with an id and balance, and defines methods for withdrawals and deposits for the account. <br>

    - CommandExecutionThread - This threads run method allows actions defined for the bank or the accounts to be input and run continuously from each distributed system as long as the thread is running and the clients are connected to the server. <br>

Exceptions <br>
    - BankException <br>
    - DuplicateAccountException <br>
    - InsufficientFundsException <br>

Interfaces <br>
    - Bank - Interface implemented by a BankImpl object, with method headers to add accounts, delete accounts, deposit money, and transfer money. <br>

    - Account - Interface implemented by a AccountImpl object, with method headers to return account id or balance, and to withdraw or deposit money. <br>


## Tests
TestFile - Runs tests to set up connections between the server and clients, and execute commands.
