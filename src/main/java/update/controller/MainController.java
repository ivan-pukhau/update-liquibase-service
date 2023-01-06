package update.controller;

import java.util.List;
import update.domain.User;
import update.service.MainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  private MainService mainService;

  public MainController(MainService mainService) {
    this.mainService = mainService;
  }

  @GetMapping("/test")
  public String testData() {
    return "Test Data";
  }

  @GetMapping("/user/{id}")
  public User getUser(@PathVariable String id) {
    return mainService.getUser(id);
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return mainService.getUsers();
  }

}
