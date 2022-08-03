package com.init.helloWorld.controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ConvertGrayScale {
    public byte[] convertToByteArray(BufferedImage inImg) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(inImg, "jpg", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] outImgByte = baos.toByteArray();

        System.out.println("img to byte array length: " + outImgByte.length);
        System.out.println("convert to byte array complete...");
        return outImgByte;
    }

    public static BufferedImage convertToBufferedImage(byte[] inImg) {
        BufferedImage outImg = null;
        try {
            outImg = ImageIO.read(new ByteArrayInputStream(inImg));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("convert byte array to image complete...");
        return outImg;
    }

    public static byte[] convertToGrayscale(byte[] inImg) {
        int r, g, b;
        int grayscale;
        // for loop to change each byte value into gray scale
        byte[] outImgByte = new byte[0];
        for(int i = 0; i < inImg.length; i++) {
            // first must get the value of RGB out from byte
            // array and get the average
            r = (inImg[i] >> 16) & 0xff;
            g = (inImg[i] >> 8) & 0xff;
            b = (inImg[i]) & 0xff;

            grayscale = (r + g + b) / 3;

            outImgByte[i] = (byte) (grayscale << 16 | grayscale << 8 |   grayscale);
        }

        return outImgByte;
    }
}
