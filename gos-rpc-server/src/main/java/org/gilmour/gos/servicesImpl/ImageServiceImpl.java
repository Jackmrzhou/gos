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
        try {
            return imageRepo.Put(image);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GImage GetImage(String GosKey) {
        try {
            return imageRepo.Get(GosKey);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
