package com.primeiro_exercicio.services;

import com.primeiro_exercicio.entities.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private ShippingService shippingService;

    public OrderService(ShippingService shippingService){
        this.shippingService = shippingService;
    }

    public OrderService(){

    }

    public double total(Order order) {

        return order.getBasic() - (order.getBasic() * order.getDiscount()/100) + shippingService.shipment(order);

    }

}
