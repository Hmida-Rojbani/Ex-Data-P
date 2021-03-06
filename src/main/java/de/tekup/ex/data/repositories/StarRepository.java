package de.tekup.ex.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tekup.ex.data.models.Star;

public interface StarRepository extends JpaRepository<Star, Long> {
	Optional<Star> findByName(String name);
}
