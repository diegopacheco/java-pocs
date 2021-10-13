package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.Book;
import com.github.diegopacheco.sandboxspring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

	@Autowired
	BookService service;

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping(method = RequestMethod.POST,value = "/book",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Book createBook(@RequestBody Book book){
		return service.save(book);
	}

	@RequestMapping(method = RequestMethod.GET,value = "/book/{title}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Book getBookByTitle(@PathVariable("title") String title){
		return service.getByTitle(title);
	}

	@RequestMapping(method = RequestMethod.GET,value = "/book",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Book> getAllBooks(){
		return service.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE,value = "/book/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void deleteBookById(@PathVariable("id") String id){
		service.deleteById(id);
	}

}