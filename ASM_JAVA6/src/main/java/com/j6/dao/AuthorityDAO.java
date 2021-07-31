package com.j6.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.j6.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer> {

}
