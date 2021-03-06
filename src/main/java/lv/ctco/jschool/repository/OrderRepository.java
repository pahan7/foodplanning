package lv.ctco.jschool.repository;

import lv.ctco.jschool.entities.Order;
import lv.ctco.jschool.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.user = ?1")
    Order findByUser(User user);

    @Query("select o from Order o where o.user = ?1 and o.id = ?2")
    Order findByUserAndId(User user, int id);
}
