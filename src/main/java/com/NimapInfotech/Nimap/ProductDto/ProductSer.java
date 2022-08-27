package com.NimapInfotech.Nimap.ProductDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.NimapInfotech.Nimap.ProductEntity.Product;
import com.NimapInfotech.Nimap.ProductRepo.ProductRepository;

@Service
public class ProductSer {

	@Autowired
	private ProductRepository productRepository;
		
	public List<Product> getAll(int pageNumber,int pageSize)
	{
		Pageable pageable=PageRequest.of(pageNumber, pageSize);
		
		Page<Product> page=productRepository.findAll(pageable);
        //Iterable<Product> cat=page.getContent();
		return page.toList();
		//return productRepository.findAll();
	}
}
