package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	@Query(nativeQuery = false, value = "select b from Book b where b.name  like %?1%")
	List<Book> findByBookName(String name);

}
