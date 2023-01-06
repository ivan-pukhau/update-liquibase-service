package update.service;

import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import update.domain.User;
import org.springframework.stereotype.Service;

@Service
public class MainService {

  private static final int USERS_COUNT = 10000;

  private static final String FIRST_NAME_PREFIX = "FirstName_";

  private static final String LAST_NAME_PREFIX = "LastName_";

  @PostConstruct
  public void init() {
    createUsers();
  }

  private List<User> users = new ArrayList<>();

  public User getUser(String id) {
    return users.stream()
        .filter(user -> id.equals(user.getId()))
        .findFirst().get();
  }

  public List<User> getUsers() {
    return users;
  }

  private void createUsers() {
    for(int i = 0; i < USERS_COUNT; i++) {
      var user = new User(String.valueOf(i), FIRST_NAME_PREFIX + i, LAST_NAME_PREFIX + i);
      users.add(user);
    }
  }

}
