package org.gilmour.gos.repository.impl;

import org.gilmour.gos.models.GImage;
import org.gilmour.gos.repository.ImageRepo;
import org.springframework.stereotype.Repository;

@Repository
public class ImageRepoImpl implements ImageRepo {
    @Override
    public GImage Get(String key) {
        return null;
    }

    @Override
    public String Add(GImage image) {
        return null;
    }
}
