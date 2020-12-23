package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.contract.model.Book;
import com.github.diegopacheco.sandboxspring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookController {

	@Autowired
	private BookService service;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@GetMapping("/book")
	@ResponseBody
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> books = service.getAll();
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}

	@PostMapping("/book")
	@ResponseBody
	public ResponseEntity<Book> addBook(@RequestBody Book b){
		service.addBook(b);
		return new ResponseEntity<Book>(b,HttpStatus.OK);
	}

}

