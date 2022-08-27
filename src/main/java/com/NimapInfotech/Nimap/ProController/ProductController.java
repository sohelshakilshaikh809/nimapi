package com.NimapInfotech.Nimap.ProController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.NimapInfotech.Nimap.CategoryRepo.CategoryRepository;
import com.NimapInfotech.Nimap.Exception.ResourceNotFoundException;
import com.NimapInfotech.Nimap.ProductDto.ProductSer;
import com.NimapInfotech.Nimap.ProductEntity.Product;
import com.NimapInfotech.Nimap.ProductRepo.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductRepository productrepositroy;
	ProductSer productser;
	
	@PostMapping("/products")
	public Product insertCategory(@RequestBody Product product) {
		return productrepositroy.save(product);
	}
	
	@GetMapping("/products")
	public Iterable<Product> getAll(@RequestParam(value="pageNumber",defaultValue = "1",required = false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue = "5",required = false) Integer pageSize)
	{
		return productser.getAll(pageNumber, pageSize);
	}
	
	@GetMapping("/products/{ProductId}")
	public Product getProductById(@PathVariable(value = "ProductId") int id) {
	
		return productrepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found with Id: "+ id));
	}
	
	@PutMapping("/products/{ProductId}")
	public Product UpdateProduct(@RequestBody Product product,@PathVariable("ProductId") int id) {
		Product productexist = productrepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found with Id: "+id));
		productexist.setProductName(product.getProductName());
		productexist.setProductPrice(product.getProductPrice());
		return productrepositroy.save(productexist);
	}
	
	@DeleteMapping("/products/{ProductId}")
	public ResponseEntity<Product> DeleteProduct(@RequestBody Product product,@PathVariable("ProductId") int id) {
		Product productexist = productrepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found with Id: "+id));
		System.out.println(productexist);
	    productrepositroy.delete(productexist);
	    return ResponseEntity.ok().build();
	}
	
	
	
	
	
	
	@GetMapping("/product")
	public List<Product> getProduct(){
		return (List<Product>)productrepositroy.findAll();
	}
}
