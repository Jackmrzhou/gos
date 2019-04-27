package org.gilmour.gos.web.controller;

import org.gilmour.gos.models.DefaultGImageImpl;
import org.gilmour.gos.services.ImageService;
import org.gilmour.gos.web.models.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        httpHeaders.add("Content-Disposition", "inline;filename=" + GosKey + ".jpg");
        ResponseEntity<byte[]> responseEntity =
                new ResponseEntity<>(imageService.GetImage(GosKey).ToByteArray(), httpHeaders, HttpStatus.OK);
        return responseEntity;
    }

    @RequestMapping(value = "/image", method = RequestMethod.POST)
    public CommonResponse PutImage(@RequestParam("image") MultipartFile image) throws IOException{
        String GosKey = imageService.PutImage(new DefaultGImageImpl(image.getBytes()));
        CommonResponse resp = new CommonResponse();
        resp.setCode(200);
        resp.setMsg("ok");
        resp.setData(GosKey);
        return resp;
    }
}
