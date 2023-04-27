package assignment.book.repository;

import assignment.book.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
    @Query("SELECT o FROM OrderDetail o WHERE o.user.id = :user_id")
    List<OrderDetail> getOrderByCustomer (Long user_id);

    @Query("SELECT o FROM OrderDetail o where o.book.owner_id =:seller_id")
    List<OrderDetail> getOrderBySeller (Long seller_id);
}
