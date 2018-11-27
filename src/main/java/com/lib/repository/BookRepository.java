package com.lib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lib.BO.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	@Query(value = "SELECT * FROM BOOK WHERE lower(TITLE) = lower(?1)", nativeQuery = true)
    public List<Book> find(String bookTitle);
}
