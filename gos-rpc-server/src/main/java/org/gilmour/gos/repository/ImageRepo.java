package org.gilmour.gos.repository;

import org.gilmour.gos.models.GImage;

public interface ImageRepo {
    String Put(GImage image) throws Exception;
    GImage Get(String key) throws Exception;
}
