package com.firstapp.springwebapp.repositories;

import com.firstapp.springwebapp.domain.Books;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Books, Long> {
}
