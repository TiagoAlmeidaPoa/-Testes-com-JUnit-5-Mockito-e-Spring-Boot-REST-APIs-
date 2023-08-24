package br.com.almeidatiago.api.repositories;

import br.com.almeidatiago.api.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
}
