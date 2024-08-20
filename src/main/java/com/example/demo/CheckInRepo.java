package com.example.demo;
import java.awt.print.Pageable;
import java.util.Optional;

import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CheckInRepo extends JpaRepository <CheckIn,Long>
{

	Page findById(Pageable page);

	void deleteById(int id);

	Optional<CheckIn> findById(int id);

}
