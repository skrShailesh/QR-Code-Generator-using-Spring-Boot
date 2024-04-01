package com.shailesh.qrcode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Controller
public class QRCodeController {

    // This method handles GET requests to "/generateQRCodeForm"
    @GetMapping("static/generateQRCodeForm.html")
    public String generateQRCodeForm() {
        // Return the name of the HTML file without extension
        return "static/generateQRCodeForm.html";
    }

    // This method handles POST requests to "/generateAndDisplayQRCode"
    @PostMapping("/generateAndDisplayQRCode")
    public ResponseEntity<byte[]> generateAndDisplayQRCode(
            @RequestParam("name") String name,
            @RequestParam("data") String data)
            throws WriterException, IOException {

        // Combine name and data to form the text for the QR code
        String text = name + ": " + data;

        // Generate the QR code image with fixed size of 350x350 pixels
        byte[] qrCode = QRCodeGenerator.getQRCodeImage(text, 350, 350);

        // Set response headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        headers.setContentLength(qrCode.length);

        // Return the QR code image as a response entity with OK status
        return new ResponseEntity<>(qrCode, headers, HttpStatus.OK);
    }
}
// run on http://localhost:8080/generateQRCodeForm.html