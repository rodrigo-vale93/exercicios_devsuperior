package com.primeiro_exercicio.services;

import com.primeiro_exercicio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

    public double shipment(Order order) {

        double valor = order.getBasic() - (order.getBasic() * (order.getDiscount() / 100));
        double valorfinal;

        if (valor < 100) {
            valorfinal = 20.00;
        } else if (valor >= 100 && valor <= 200) {
            valorfinal = 12.00;
        } else {
            valorfinal = 0;
        }
        return valorfinal;
    }
}



