package org.gilmour.gos.services;

import org.gilmour.gos.models.GImage;

import java.io.IOException;

public interface ImageService {
    // return key
    String PutImage(GImage image) throws IOException;
    GImage GetImage(String GosKey) throws IOException;
}
