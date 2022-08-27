package com.NimapInfotech.Nimap.CategoryDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.NimapInfotech.Nimap.CategoryEntity.Category;
import com.NimapInfotech.Nimap.CategoryRepo.CategoryRepository;

@Service
public class CategorySer {

	@Autowired
	private CategoryRepository categoryRepository;  
	
	

	public Iterable<Category> getAll(Integer pageNumber,Integer pageSize)
	{
		Pageable pageable=PageRequest.of(pageNumber, pageSize);
		
		Page<Category> page=categoryRepository.findAll(pageable);
		Iterable<Category> cat=page.getContent();
		return cat;
	
	}
}
