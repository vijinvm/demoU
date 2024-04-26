package com.example.demoU;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
@Autowired
private PersonRepository p;
@GetMapping("/categories")
public Page<Person> a1(@RequestParam int page,
		@RequestParam int size){
	return p.findAll(PageRequest.of(page, size));
}
@GetMapping("/sorting1")
public List<Person> a2(@RequestParam String sortBy){
	Sort sort =Sort.by(sortBy);
	return p.findAll(sort);
}
@GetMapping("/categories/{id}")
public Person  a3(@PathVariable int id) {
	return p.findById(id).orElse(null);
}
@PostMapping("/categories")
public Person a4(@RequestBody Person person) {
	return p.save(person);
}
@PutMapping("/categories/{id}")
public Person a5(@PathVariable int id,@RequestBody Person person) {
	return p.findById(id).map(e->{e.setName(person.getName());
	e.setAge(person.getAge());
	return p.save(e);
})
			.orElse(null);
}
@DeleteMapping("/categories/{id}")
public void a6(@PathVariable int id) {
	p.deleteById(id);
}
@Autowired
private ProductRepository q;
@GetMapping("/product")
public Page<Product> b1(@RequestParam int page,
		@RequestParam int size){
	return q.findAll(PageRequest.of(page, size));
}
@GetMapping("/sorting2")
public List<Product> b2(@RequestParam String sortBy){
	Sort sort =Sort.by(sortBy);
	return q.findAll(sort);
}
@GetMapping("/product/{id}")
public Product  b3(@PathVariable int id) {
	return q.findById(id).orElse(null);
}
@PostMapping("/product")
public Product b4(@RequestBody Product product) {
	return q.save(product);
}
@PutMapping("/product/{id}")
public Product b5(@PathVariable int id,@RequestBody Product product) {
	return q.findById(id).map(e->{e.setName(product.getName());
	e.setName(product.getName());
	return q.save(e);
})
			.orElse(null);
}
@DeleteMapping("/product/{id}")
public void b6(@PathVariable int id) {
	q.deleteById(id);
}
}
