package org.coffee.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class CoffeeOrderBoard {

    private static final Logger logger = LoggerFactory.getLogger(CoffeeOrderBoard.class);

    private final List<Order> orders = new ArrayList<>();
    private int nextOrderNumber = 1;

    public void add(String clientName) {
        Order order = new Order(nextOrderNumber, clientName);
        orders.add(order);
        logger.info("Додано замовлення №{} для {}", nextOrderNumber, clientName);
        nextOrderNumber++;
    }

    public void deliver() {
        if (!orders.isEmpty()) {
            Order order = orders.remove(0);
            logger.info("Видано замовлення №{} для {}", order.getOrderNumber(), order.getClientName());
        } else {
            logger.warn("Спроба видати замовлення з порожньої черги");
        }
    }

    public void deliver(int orderNumber) {
        Order foundOrder = null;

        for (Order order : orders) {
            if (order.getOrderNumber() == orderNumber) {
                foundOrder = order;
                break;
            }
        }

        if (foundOrder != null) {
            orders.remove(foundOrder);
            logger.info("Видано замовлення №{} для {}", foundOrder.getOrderNumber(), foundOrder.getClientName());
        } else {
            logger.warn("Замовлення з номером {} не знайдено у черзі", orderNumber);
        }
    }

    public void draw() {
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.printf("%-4d| %s%n", order.getOrderNumber(), order.getClientName());
        }
        logger.info("Стан черги виведено у консоль: {} замовлень", orders.size());
    }
}