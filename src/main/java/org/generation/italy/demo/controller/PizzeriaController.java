package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Pizzeria;
import org.generation.italy.demo.serv.PizzeriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class PizzeriaController {
    
    @Autowired
    PizzeriaService pizzeriaService;
	
	@GetMapping
	public String index(Model model) {
		
		List<Pizzeria> pizze = pizzeriaService.findAll();
		model.addAttribute("pizze", pizze);
		
		return "Pizze";
	}
	
	@GetMapping("/pizza/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		
		Optional<Pizzeria> optPizza = pizzeriaService.findPizzaId(id);
		Pizzeria pizza = optPizza.get();
		model.addAttribute("pizza", pizza);
		
		return "Pizza";
	}
	
	@GetMapping("/pizza/create")
	public String create(Model model) {
		
		Pizzeria pizza = new Pizzeria();
		model.addAttribute("pizza", pizza);
		
		return "PizzaCreate";
	}
	
	@PostMapping("/pizza/store")
	public String store(@Valid @ModelAttribute("pizza") Pizzeria pizza) {
		
		pizzeriaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		
		Optional<Pizzeria> optPizza = pizzeriaService.findPizzaId(id);
		Pizzeria pizza = optPizza.get();
		model.addAttribute("pizza", pizza);
		
		return "PizzaEdit";
	}
	
	@PostMapping("/pizza/update")
	public String update(@Valid Pizzeria pizza) {
		
		pizzeriaService.save(pizza);
		
		return "redirect:/";
	}
	
	@GetMapping("/pizza/delete{id}")
	public String delete(@PathVariable("id") int id) {
		
		Optional<Pizzeria> optPizza = pizzeriaService.findPizzaId(id);
		Pizzeria pizza = optPizza.get();
		pizzeriaService.delete(pizza);
		
		return "redirect:/";
	}
}
