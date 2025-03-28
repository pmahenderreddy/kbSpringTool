package com.mahi.first_rest_api.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "users", collectionResourceRel = "users", exported = true)
public interface UserDetailsRestRepository
		extends JpaRepository<UserDetails, Long>, PagingAndSortingRepository<UserDetails, Long> {
	List<UserDetails> findByRole(String role);
}
