# Bank Card Service API

Bank Card Service API is a software application for managing bank cards. It provides functionalities to register a bank card, withdraw money from a card, deposit money, and search for cards by card number and CIF.

## Technologies and Tools

- Java programming language
- REST API
- Gradle
- Spring Boot
- H2 Database
- Lombok
- Spring Data JPA

## Installation

1. Clone the project to your computer.
2. Navigate to the project's root directory.
3. Run the following command to install the necessary dependencies:

   ```shell
   gradle build
4. To start the application, run the following command:

   ```shell
   gradle bootRun 

## Usage
You can use the API by sending the following example requests:

1. Register a bank card:
   ```http
   POST /register
	 Content-Type: application/json
	 {
	 "cardNumber": 1234567890,
	 "cardholderName": "John Doe",
	 "cardExpirationDate": "2023-12",
	 "cif": 123456,
	 "balance": 1000
	 }


2. Deposit money:
   ```http
   POST /deposit
	Content-Type: application/json

	{
	  "cardNumber": 1234567890,
	  "amount": 1000
	}



3. Withdraw money from a card:
	```http
	POST /withdraw
	Content-Type: application/json
	
 	{
 	  "cardNumber": 1234567890,
 	  "amount": 500
	 }

	```

4. Search for a card by card number and CIF::
	```http
 	GET /cards?cardNumber=1234567890&cif=123456

	```

## Contributing
Contributions to this project are currently accepted.

## License
This project is owned by Yusif Shirinzada.
