package com.library.service.services;

import com.library.service.domain.Book;
import com.library.service.domain.Role;
import com.library.service.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BookService {

	@Autowired
  	BookRepository bookRepository;

    private final static Logger LOG = LoggerFactory.getLogger(BookService.class);

	//private final BookRepository bookRepository;
	//	public BookService(BookRepository movieRepository) {
	//		this.bookRepository = movieRepository;
	//	}

	private Map<String, Object> toD3Format(Collection<Book> movies) {
		List<Map<String, Object>> nodes = new ArrayList<>();
		List<Map<String, Object>> rels = new ArrayList<>();
		int i = 0;
		Iterator<Book> result = movies.iterator();
		while (result.hasNext()) {
			Book book = result.next();
			nodes.add(map("title", book.getTitle(), "label", "movie"));
			int target = i;
			i++;
			for (Role role : book.getRoles()) {
				Map<String, Object> actor = map("title", role.getPerson().getName(), "label", "actor");
				int source = nodes.indexOf(actor);
				if (source == -1) {
					nodes.add(actor);
					source = i++;
				}
				rels.add(map("source", source, "target", target));
			}
		}
		return map("nodes", nodes, "links", rels);
	}

	private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put(key1, value1);
		result.put(key2, value2);
		return result;
	}

    @Transactional(readOnly = true)
    public Book findByTitle(String title) {
        Book result = bookRepository.findByTitle(title);
        return result;
    }

	@Transactional(readOnly = true)
	public Collection<Book> findByTitleLike(String title) {
		Collection<Book> result = bookRepository.findByTitleLike(title);
		return result;
	}

	@Transactional(readOnly = true)
	public Map<String, Object>  graph(int limit) {
		Collection<Book> result = bookRepository.graph(limit);
		return toD3Format(result);
	}
}
