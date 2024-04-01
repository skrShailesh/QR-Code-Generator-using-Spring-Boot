package com.shailesh.qrcode;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

// This class contains utility methods for generating QR code images
class QRCodeGenerator {
    // This method generates a QR code image and writes it to a file
    public static void generateQRCodeImage(String text, int width, int height, String filePath)
            throws WriterException, IOException {
        // Create a QRCodeWriter instance
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        // Encode the text into a BitMatrix representing the QR code
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        // Write the BitMatrix to a file as an image (PNG format)
        Path path = FileSystems.getDefault().getPath(filePath);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

    // This method generates a QR code image and returns it as a byte array
    public static byte[] getQRCodeImage(String text, int width, int height) throws WriterException, IOException {
        // Create a QRCodeWriter instance
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        // Encode the text into a BitMatrix representing the QR code
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        // Write the BitMatrix to a byte array as an image (PNG format)
        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        return pngData;
    }
}
