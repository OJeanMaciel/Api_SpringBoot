package academy.devdojo.springboot.controller;

import academy.devdojo.springboot.model.User;
import academy.devdojo.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    // GET
    // POST
    // PUT
    // DELETE
    // PATCH

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id) {

        Optional<User> userFind = this.userRepository.findById(id);

        if (userFind.isPresent()) {
            return userFind.get();
        }

        return null;
    }

    @PostMapping("/")
    public User user(@RequestBody User user) {
        return this.userRepository.save(user);

    }

    @GetMapping("/list")
    public List<User> list() {
        return this.userRepository.findAll();
    }

    @GetMapping("/list/{id}")
    public List<User> listMoreThan(@PathVariable("id") Long id) {
        return this.userRepository.findByIdGreaterThan(id);
    }

    @GetMapping("/findByName/{name}")
    public List<User> findByName(@PathVariable("name") String name) {
        return this.userRepository.findByNameIgnoreCase(name);
    }

}
