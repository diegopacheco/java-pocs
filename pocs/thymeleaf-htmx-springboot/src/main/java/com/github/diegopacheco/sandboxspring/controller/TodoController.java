package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.TodoItemNotFoundException;
import com.github.diegopacheco.sandboxspring.model.TodoItem;
import com.github.diegopacheco.sandboxspring.model.TodoItemFormData;
import com.github.diegopacheco.sandboxspring.repository.TodoItemRepository;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HtmxResponse;
import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class TodoController {

    private TodoItemRepository repository;

    @Autowired
    public TodoController(TodoItemRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String index(Model model) {
        addAttributesForIndex(model, ListFilter.ALL);
        return "index";
    }

    @GetMapping("/active")
    public String indexActive(Model model) {
        addAttributesForIndex(model, ListFilter.ACTIVE);
        return "index";
    }

    @GetMapping("/completed")
    public String indexCompleted(Model model) {
        addAttributesForIndex(model, ListFilter.COMPLETED);
        return "index";
    }

    @PostMapping
    public String addNewTodoItem(@Valid @ModelAttribute("item") TodoItemFormData formData) {
        repository.save(new TodoItem(formData.getTitle(), false));
        return "redirect:/";
    }

    @PutMapping("/{id}/toggle")
    public String toggleSelection(@PathVariable("id") Long id) {
        TodoItem todoItem = repository.findById(id)
                .orElseThrow(() -> new TodoItemNotFoundException(id));
        todoItem.setCompleted(!todoItem.isCompleted());
        repository.save(todoItem);
        return "redirect:/";
    }

    @PutMapping("/toggle-all")
    public String toggleAll() {
        List<TodoItem> todoItems = repository.findAll();
        for (TodoItem todoItem : todoItems) {
            todoItem.setCompleted(!todoItem.isCompleted());
            repository.save(todoItem);
        }
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteTodoItem(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/";
    }

    @DeleteMapping("/completed")
    public String deleteCompletedItems() {
        List<TodoItem> items = repository.findAllByCompleted(true);
        for (TodoItem item : items) {
            repository.deleteById(item.getId());
        }
        return "redirect:/";
    }

    @PostMapping
    @HxRequest
    public HtmxResponse htmxAddTodoItem(TodoItemFormData formData, Model model) {
        TodoItem item = repository.save(new TodoItem(formData.getTitle(), false));
        return getHtmxResponseForTodoItem(model, item);
    }

    @PutMapping("/{id}/toggle")
    @HxRequest
    public HtmxResponse htmxToggleTodoItem(@PathVariable("id") Long id, Model model) {
        TodoItem todoItem = repository.findById(id)
                .orElseThrow(() -> new TodoItemNotFoundException(id));
        todoItem.setCompleted(!todoItem.isCompleted());
        repository.save(todoItem);
        return getHtmxResponseForTodoItem(model, todoItem);
    }

    @DeleteMapping("/{id}")
    @HxRequest
    public HtmxResponse htmxDeleteTodoItem(@PathVariable("id") Long id, Model model) {
        repository.deleteById(id);
        return activeItemsCountFragment(model);
    }

    @GetMapping("/active-items-count")
    @HxRequest
    public String htmxActiveItemsCount(Model model) {
        model.addAttribute("numberOfActiveItems", getNumberOfActiveItems());
        return "fragments :: active-items-count";
    }

    private HtmxResponse getHtmxResponseForTodoItem(Model model, TodoItem item) {
        model.addAttribute("item", toDto(item));
        return new HtmxResponse()
                .addTemplate("fragments :: todoItem")
                .and(activeItemsCountFragment(model));
    }

    private HtmxResponse activeItemsCountFragment(Model model) {
        model.addAttribute("numberOfActiveItems", getNumberOfActiveItems());
        return new HtmxResponse().addTemplate("fragments :: active-items-count");
    }

    private void addAttributesForIndex(Model model, ListFilter listFilter) {
        model.addAttribute("item", new TodoItemFormData());
        model.addAttribute("filter", listFilter);
        model.addAttribute("todos", getTodoItems(listFilter));
        model.addAttribute("totalNumberOfItems", repository.count());
        model.addAttribute("numberOfActiveItems", getNumberOfActiveItems());
        model.addAttribute("numberOfCompletedItems", getNumberOfCompletedItems());
    }

    private List<TodoItemDto> getTodoItems(ListFilter filter) {
        return switch (filter) {
            case ALL -> convertToDto(repository.findAll());
            case ACTIVE -> convertToDto(repository.findAllByCompleted(false));
            case COMPLETED -> convertToDto(repository.findAllByCompleted(true));
        };
    }

    private List<TodoItemDto> convertToDto(List<TodoItem> todoItems) {
        return todoItems
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    private TodoItemDto toDto(TodoItem todoItem) {
        return new TodoItemDto(todoItem.getId(),
                todoItem.getTitle(),
                todoItem.isCompleted());
    }

    private int getNumberOfActiveItems() {
        return repository.countAllByCompleted(false);
    }

    private int getNumberOfCompletedItems() {
        return repository.countAllByCompleted(true);
    }

    public static record TodoItemDto(long id, String title, boolean completed) {
    }

    public enum ListFilter {
        ALL,
        ACTIVE,
        COMPLETED
    }
}