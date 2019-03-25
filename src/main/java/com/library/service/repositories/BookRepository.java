package com.library.service.repositories;

import com.library.service.domain.Book;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRepository extends Neo4jRepository<Book, Long> {
    Book findByTitle(@Param("title") String title);

    Collection<Book> findByTitleLike(@Param("title") String title);

    @Query("MATCH (m:Book)<-[r:WROTE]-(a:Person) RETURN m,r,a LIMIT {limit}")
    Collection<Book> graph(@Param("limit") int limit);
}
