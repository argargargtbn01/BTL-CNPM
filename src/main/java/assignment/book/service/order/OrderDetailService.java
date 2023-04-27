package assignment.book.service.order;

import assignment.book.dto.request.OrderDetailRequestDto;
import assignment.book.entity.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {
    OrderDetail getOrder(Long id);

    List<OrderDetail> getOrderByCustomer (Long user_id);

    List<OrderDetail> getOrderBySeller (Long seller_id);

    void createOrder(OrderDetailRequestDto orderDetailRequestDto);
}
