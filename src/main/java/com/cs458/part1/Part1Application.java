package com.cs458.part1;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@SpringBootApplication
public class Part1Application {
	@Autowired
	UsersRepository repo;

	@GetMapping("getTest")
	public List<Users> get() {
		return repo.findAll().stream().collect(Collectors.toList());
	}
	
	@GetMapping("insertTest")
	public String insert() {
		Users user = new Users();
		user.setId(1);
		user.setEmail("ender@gmail.com");
		user.setName("Ender");
		user.setSurname("Utlu");
		user.setPhoneNumber("05448242002");
		user.setDateOfBirth(LocalDate.of(2002, 8, 1));
		return repo.save(user).toString();
	}
	
	@DeleteMapping("deleteTest/{id}")
	public void delete(@PathVariable int id) {
		repo.deleteById(id);
	}
	public static void main(String[] args) {
		SpringApplication.run(Part1Application.class, args);
	}

}
