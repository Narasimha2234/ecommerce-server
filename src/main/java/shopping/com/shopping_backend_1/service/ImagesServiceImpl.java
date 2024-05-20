package shopping.com.shopping_backend_1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import shopping.com.shopping_backend_1.entity.Images;
import shopping.com.shopping_backend_1.repository.ImagesRepository;

public class ImagesServiceImpl implements ImagesService {
	@Autowired
	ImagesRepository imagesRepository;
	@Override
	public List<Images> getAllImages() {
		
		return imagesRepository.findAll();
	}

	@Override
	public Images saveImages(Images image) {
		
		return imagesRepository.save(image);
	}

	@Override
	public Images getoneImage(long id) {
		// TODO Auto-generated method stub
		return imagesRepository.findById(id).get();
	}

}
