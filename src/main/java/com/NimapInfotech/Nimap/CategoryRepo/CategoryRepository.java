package com.NimapInfotech.Nimap.CategoryRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.NimapInfotech.Nimap.CategoryEntity.Category;

@Repository()
public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
