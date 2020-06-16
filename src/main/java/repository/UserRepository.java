package repository;

import model.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTest, Integer> {
    public UserTest findByUsername(String username);
}