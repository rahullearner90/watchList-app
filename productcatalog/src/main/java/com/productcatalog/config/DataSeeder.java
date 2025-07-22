package com.productcatalog.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.productcatalog.model.Category;
import com.productcatalog.model.Product;
import com.productcatalog.repository.CategoryRepository;
import com.productcatalog.repository.ProductRepository;

@Component
public class DataSeeder implements CommandLineRunner{
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		productRepository.deleteAll();
		categoryRepository.deleteAll();

//		create categories
		Category electronics=new Category();
		electronics.setName("Electronics");

		Category clothing = new Category();
		clothing.setName("Clothing");

		Category home = new Category();
		home.setName("Home and Kitchen");

		categoryRepository.saveAll(Arrays.asList(electronics,clothing,home));

//		create products
		Product phone=new Product();
		phone.setName("Smart Phone");
		phone.setDescription("latest model smartphone with amazing features.");
		phone.setImageUrl("https://placehold.co/600x400");
		phone.setPrice(999.99);
		phone.setCategory(electronics);

		Product laptop=new Product();
		laptop.setName("Laptop");
		laptop.setDescription("High-Performance laptop for work and play.");
		laptop.setImageUrl("https://placehold.co/600x400");
		laptop.setPrice(999.99);
		laptop.setCategory(electronics);

		Product jacket=new Product();
		jacket.setName("Jacket");
		jacket.setDescription("Warm and cozy jacket for winter.");
		jacket.setImageUrl("https://placehold.co/600x400");
		jacket.setPrice(129.99);
		jacket.setCategory(clothing);

		Product blender=new Product();
		blender.setName("Blender");
		blender.setDescription("High-speed blender for smoothies and more.");
		blender.setImageUrl("https://placehold.co/600x400");
		blender.setPrice(99.99);
		blender.setCategory(home);

		productRepository.saveAll(Arrays.asList(blender, jacket, laptop, phone));

	}

}
