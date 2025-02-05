package com.primeiro_exercicio;

import com.primeiro_exercicio.entities.Order;
import com.primeiro_exercicio.services.OrderService;
import com.primeiro_exercicio.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
@ComponentScan({"com.primeiro_exercicio"})

public class PrimeiroExercicioApplication implements CommandLineRunner {

	private OrderService orderService;

	public PrimeiroExercicioApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args)	 {

		SpringApplication.run(PrimeiroExercicioApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Código :");
		Integer code = sc.nextInt();
		System.out.println("Valor :");
		double basic = sc.nextDouble();
		System.out.println("Desconto :");
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);

		double valorPed = orderService.total(order);

		System.out.println("Pedido código : " + code);
		System.out.println("Valor total : " + valorPed);

	}

	}
