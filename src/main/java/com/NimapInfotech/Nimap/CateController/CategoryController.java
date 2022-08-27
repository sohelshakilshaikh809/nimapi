package com.NimapInfotech.Nimap.CateController;

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

import com.NimapInfotech.Nimap.CategoryDto.CategorySer;
import com.NimapInfotech.Nimap.CategoryEntity.Category;
import com.NimapInfotech.Nimap.CategoryRepo.CategoryRepository;
import com.NimapInfotech.Nimap.Exception.ResourceNotFoundException;
import com.NimapInfotech.Nimap.ProductEntity.Product;

@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	CategoryRepository categoryrepositroy;
	CategorySer categoryser;
	
	@PostMapping("/categories")
	public Category insertCategory(@RequestBody Category category) {
		return categoryrepositroy.save(category);
	}
	
	@GetMapping("/categories")
	public Iterable<Category> getAll(@RequestParam(value="pageNumber",defaultValue = "1",required = false) Integer pageNumber,
			@RequestParam(value="pageSize",defaultValue = "5",required = false) Integer pageSize)
	{
		return categoryser.getAll(pageNumber, pageSize);
	}
	
	@GetMapping("/categories/{CategoryId}")
	public Category getCategoryById(@PathVariable(value = "CategoryId") int id) {
	
		return categoryrepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category Not Found with Id: "+ id));
	}
	
	@PutMapping("/categories/{CategoryId}")
	public Category UpdateCategory(@RequestBody Category category,@PathVariable("CategoryId") int id) {
		Category categoryexist = categoryrepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category Not Found with Id: "+id));
		categoryexist.setCategoryName(category.getCategoryName());
		categoryexist.setCategoryDescription(category.getCategoryDescription());
		return categoryrepositroy.save(categoryexist);
	}
	
	@DeleteMapping("/categories/{CategoryId}")
	public ResponseEntity<Product> DeleteProduct(@RequestBody Category category,@PathVariable("CategoryId") int id) {
		Category categoryexist = categoryrepositroy.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Not Found with Id: "+id));
	    categoryrepositroy.delete(categoryexist);
	    return ResponseEntity.ok().build();
	}
	
	
	
	
	
	
	
	
	@GetMapping("/category")
	public List<Category> getCategory(){
		return (List<Category>)categoryrepositroy.findAll();
	}
}
