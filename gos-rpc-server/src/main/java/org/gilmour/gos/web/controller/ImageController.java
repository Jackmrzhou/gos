package org.gilmour.gos.web.controller;

import org.gilmour.gos.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/image/{GosKey}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> GetImage(@PathVariable("GosKey") String GosKey) throws IOException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setCacheControl(CacheControl.noCache().getHeaderValue());
        httpHeaders.add("Content-Type", " application/octet-stream");
        ResponseEntity<byte[]> responseEntity =
                new ResponseEntity<>(imageService.GetImage(GosKey).ToByteArray(), httpHeaders, HttpStatus.OK);
        return responseEntity;
    }
}
