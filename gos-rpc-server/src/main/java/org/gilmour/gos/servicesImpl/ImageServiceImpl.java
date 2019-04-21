package org.gilmour.gos.servicesImpl;

import org.gilmour.gos.models.GImage;
import org.gilmour.gos.repository.ImageRepo;
import org.gilmour.gos.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepo imageRepo;

    @Override
    public String PutImage(GImage image) {
        return null;
    }

    @Override
    public GImage GetImage(String GosKey) {
        return null;
    }
}
