package academy.devdojo.springboot.repository;

import academy.devdojo.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("Select u from User u where u.id > :id ")
    public List<User> findByIdGreaterThan(Long id);


    public List<User> findByNameIgnoreCase(String name);
}
