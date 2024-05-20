package shopping.com.shopping_backend_1.service;

import java.util.List;

import shopping.com.shopping_backend_1.entity.Images;

public interface ImagesService {
	List<Images> getAllImages();
	Images saveImages(Images image);
	Images getoneImage(long id);
}
