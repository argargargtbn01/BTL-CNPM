package assignment.book.service.order;

import assignment.book.dto.request.OrderDetailRequestDto;
import assignment.book.entity.Book;
import assignment.book.entity.OrderDetail;
import assignment.book.entity.SavedBook;
import assignment.book.entity.User;
import assignment.book.exception.NotFoundException;
import assignment.book.repository.BookRepository;
import assignment.book.repository.OrderDetailRepository;
import assignment.book.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    private final BookRepository bookRepository;

    private final UserRepository userRepository;
    @Override
    public OrderDetail getOrder(Long id) {
        Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);
        OrderDetail order = optionalOrderDetail.orElseThrow(()-> new NotFoundException("order with id = " + id + " not found"));
        return order;
    }

    @Override
    public List<OrderDetail> getOrderByCustomer(Long user_id) {
        List<OrderDetail> orderDetails = orderDetailRepository.getOrderByCustomer(user_id);
        return orderDetails;
    }

    @Override
    public List<OrderDetail> getOrderBySeller(Long seller_id) {
        List<OrderDetail> orderDetails = orderDetailRepository.getOrderBySeller(seller_id);
        return orderDetails;
    }

    @Override
    public void createOrder(OrderDetailRequestDto orderDetailRequestDto) {
        Book book = bookRepository.findById(orderDetailRequestDto.getBook_id()).orElseThrow(() -> new NotFoundException("book not found"));
        User user = userRepository.findById(orderDetailRequestDto.getUser_id()).orElseThrow(() -> new NotFoundException("user not found"));
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setBook(book);
        orderDetail.setUser(user);
        orderDetailRepository.save(orderDetail);
    }
}
