# QR Code Generator

The QR Code Generator is a simple Spring Boot application that allows users to generate QR codes based on input provided through a web form. The application accepts two inputs - name and data - and generates a QR code with a fixed size of 350x350 pixels representing the combined input text.

## Components

### 1. Spring Boot Application

- The main entry point of the application is the `QRcodeGeneraterApplication` class, which contains the `main` method to run the Spring Boot application.
- It uses Spring Boot's `@SpringBootApplication` annotation to enable auto-configuration and component scanning.

### 2. HTML Form

- The application provides an HTML form (`generateQRCodeForm.html`) that allows users to input their name and data.
- The form submits the input data to the `/generateAndDisplayQRCode` endpoint via a POST request.

### 3. Controller

- The `QRCodeController` class is a Spring MVC controller responsible for handling requests related to QR code generation.
- It contains two methods:
  - `generateQRCodeForm()`: This method handles GET requests to `/generateQRCodeForm` and returns the HTML form for generating QR codes.
  - `generateAndDisplayQRCode()`: This method handles POST requests to `/generateAndDisplayQRCode` and generates a QR code based on the input parameters (name and data). It then returns the QR code image as a response entity.

### 4. QR Code Generator

- The `QRCodeGenerator` class contains utility methods for generating QR code images using the ZXing library.
- It provides a method `getQRCodeImage()` to generate a QR code image based on the input text and dimensions.

## Usage

1. Start the Spring Boot application by running the `QRcodeGeneraterApplication` class.
2. Open a web browser and navigate to `http://localhost:8080/generateQRCodeForm`.
3. Enter your name and data in the provided form fields.
4. Click the "Generate QR Code" button.
5. The application will generate a QR code representing the combined input text (name: data) and display it in the browser.

## Dependencies

- Spring Boot: 2.5.0
- ZXing: 3.4.0


