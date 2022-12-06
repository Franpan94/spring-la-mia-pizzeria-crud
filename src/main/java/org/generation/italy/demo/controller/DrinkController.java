package org.generation.italy.demo.controller;

import java.util.List;
import java.util.Optional;

import org.generation.italy.demo.pojo.Drink;
import org.generation.italy.demo.serv.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/drink")
public class DrinkController {

	@Autowired
	DrinkService drinkService;
	
	@GetMapping
	public String index(Model model) {
		
		List<Drink> drinks = drinkService.findAll();
		model.addAttribute("drinks", drinks);
		
		return "Drinks";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") int id, Model model) {
		
		Optional<Drink> optDrink = drinkService.findById(id);
		Drink drink = optDrink.get();
		model.addAttribute("drink", drink);
		
		return "Drink";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		
		Drink drink = new Drink();
		model.addAttribute("drink", drink);
		
		return "DrinkCreate";
	}
	
	@PostMapping("/store")
	public String store(@Valid @ModelAttribute("drink") Drink drink, 
		BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
        if (bindingResult.hasErrors()) {
			
			System.err.println("ERROR ------------------------------------------");
			System.err.println(bindingResult.getAllErrors());
			System.err.println("------------------------------------------------");
			
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			return "redirect:/drink/create";
		}
		
		drinkService.save(drink);
		
		return "redirect:/drink";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		
		Optional<Drink> optDrink = drinkService.findById(id);
		Drink drink = optDrink.get();
		model.addAttribute("drink", drink);
		
		return "DrinkEdit";
	}
	
	@PostMapping("/update")
	public String update(@Valid Drink drink, 
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		
        if (bindingResult.hasErrors()) {
			
			System.err.println("ERROR ------------------------------------------");
			System.err.println(bindingResult.getAllErrors());
			System.err.println("------------------------------------------------");
			
			redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
			
			return "redirect:/drink/edit/" + drink.getId();
		}
       
		drinkService.save(drink);
		
		return "redirect:/drink";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		
		Optional<Drink> optDrink = drinkService.findById(id);
		Drink drink = optDrink.get();
		drinkService.delete(drink);
		
		return "redirect:/drink";
	}
}
