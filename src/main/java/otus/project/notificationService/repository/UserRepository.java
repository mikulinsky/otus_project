package otus.project.notificationService.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import otus.project.notificationService.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    public Optional<User> findUserByUsername(String username);

}
