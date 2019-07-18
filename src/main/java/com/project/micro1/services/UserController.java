package com.project.micro1.services;

import com.project.micro1.entities.User;
import com.project.micro1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class UserController {

    //private final Logger log = LoggerFactory.getLogger(EmployeeController.class):
    @Autowired
    private final UserRepository userRepository;
@Autowired
private  AccountService accountService ;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signUp")
    public User signUp (@RequestBody User userReq) {
            String login=userReq.getLogin();
            User user=accountService.findUserByLogin(login);
            if(user!=null) throw new RuntimeException("This user already exists, Try with an other login");
                    String mdp=userReq.getMdp(); // String remdp=user.getMdp();
            /*if(!mdp.equals(remdp))
                throw new RuntimeException("You must confirm your password");*/
           // User u=new User(userReq.); u.setLogin(login); u.setMdp(mdp);
        userReq.setMdp(mdp);
            accountService.saveUser(userReq);
            accountService.addRoleToUser(login, "USER");
            return userReq;
        }
        @GetMapping("/user")
        public User GetConnectedUser(@RequestParam String login){
        System.out.println(login);
        return this.userRepository.findDistinctByLogin(login) ;
        }
// System.out.println("aaaaa");
/*
return  accountService.saveUser(user) ;
   //     User result = this.userRepository.save(user);
     //   return ResponseEntity.created(new URI("/api/user/" + result.getID())).header("User " + result.getID()).body(result);
    }
    /*

     */

    @GetMapping("/users")
    public List<User> GetAllUsers() {

        return userRepository.findAll();
    }

}



