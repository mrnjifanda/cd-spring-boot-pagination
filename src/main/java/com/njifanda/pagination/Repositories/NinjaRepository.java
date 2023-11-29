package com.njifanda.pagination.Repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.njifanda.pagination.Models.Ninja;

@Repository
public interface NinjaRepository extends PagingAndSortingRepository<Ninja, Long>{
	Ninja save(Ninja ninja);

	Ninja findById(Long id);
}
