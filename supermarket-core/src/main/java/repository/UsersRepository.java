package repository;

import manager.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created By Supun Kavinda
 * Email naskavinda@gmail.com
 * Date  : 9/3/2018
 */
@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
}
