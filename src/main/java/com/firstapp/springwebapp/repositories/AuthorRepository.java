package com.firstapp.springwebapp.repositories;

import com.firstapp.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
