package com.init.helloWorld.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@RestController
public class helloWorldController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello world";
    }
    @PostMapping(path = "/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] postImage(@RequestBody byte[] res){
        return ConvertGrayScale.convertToGrayscale(res);
    }
}
