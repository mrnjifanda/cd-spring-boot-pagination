package com.njifanda.pagination.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.njifanda.pagination.Models.Ninja;
import com.njifanda.pagination.Services.NinjaService;

@Controller
public class PageController {

	@Autowired
	private NinjaService ninjaService;
	
	@GetMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {

	    Page<Ninja> ninjas = ninjaService.ninjasPerPage(pageNumber - 1);

	    int totalPages = ninjas.getTotalPages();
	    model.addAttribute("totalPages", totalPages);
	    model.addAttribute("ninjas", ninjas);

	    return "index";
	}

	@PostMapping("/fake-ninja")
	public String fakeNinja() {
		
		this.ninjaService.populateNinja();
		return "redirect:/pages/1";
	}
}
