package edu.wgu.d288.services;

import edu.wgu.d288.dao.CustomerRepository;
import edu.wgu.d288.dto.Purchase;
import edu.wgu.d288.dto.PurchaseResponse;
import edu.wgu.d288.entities.Cart;
import edu.wgu.d288.entities.CartItem;
import edu.wgu.d288.entities.Customer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private final CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        Customer customer = purchase.getCustomer();
        Cart cart = purchase.getCart();
        Set<CartItem> cartItems = purchase.getCartItems();


        if (customer.getId() != null && customer.getId() == 0L) {
            customer.setId(null);
        }


        if (cart.getId() != null && cart.getId() == 0L) {
            cart.setId(null);
        }


        String orderTrackingNumber = generateOrderTrackingNumber();
        cart.setOrderTrackingNumber(orderTrackingNumber);


        if (cartItems != null) {
            cartItems.forEach(cart::add);
        }


        customer.add(cart);


        customerRepository.save(customer);

        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
