package com.njifanda.pagination.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.njifanda.pagination.Models.Ninja;
import com.njifanda.pagination.Repositories.NinjaRepository;

@Service
public class NinjaService {

	@Autowired
	private NinjaRepository ninjaRepository;

	private static final int PAGE_SIZE = 5;
	
	public void populateNinja() {

		Ninja findNinja = this.ninjaRepository.findById((long) 1);

		if (findNinja == null) {

			for(int i = 1; i < 13; i++) {
				
				Ninja ninja = new Ninja(i + " Coding", i +" Dojo");
				this.ninjaRepository.save(ninja);
			}
		}
	}

    public Page<Ninja> ninjasPerPage(int pageNumber) {

        PageRequest pageRequest = PageRequest.of(pageNumber, PAGE_SIZE, Sort.Direction.DESC, "lastName");
        Page<Ninja> ninjas = ninjaRepository.findAll(pageRequest);

        return ninjas;
    }
}
