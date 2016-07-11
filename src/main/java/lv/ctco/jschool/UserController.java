package lv.ctco.jschool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Transactional
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> studentsPost(@RequestBody User user) {
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> students() {
        List<User> students = userRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
