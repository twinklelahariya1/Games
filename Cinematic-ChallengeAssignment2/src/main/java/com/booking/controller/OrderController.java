package com.booking.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.model.Order;
import com.booking.model.Seat;
import com.booking.service.OrderService;
import com.booking.service.SeatService;
import com.fasterxml.jackson.annotation.JsonView;


@Controller
public class OrderController {

    private final SeatService seatService;
    private final OrderService orderService;

    @Autowired
    public OrderController(SeatService seatService, OrderService orderService) {
        this.seatService = seatService;
        this.orderService = orderService;
    }

    @PostMapping(value = "/tickets" )
    public String updateSeats(@RequestParam(value = "seat") List<Long> seatsId,
                              @RequestParam(value = "email") String email,
                              @RequestParam(value = "name") String name) {

        Collections.sort(seatsId);
        List<Seat> seats = seatService.getSeatsByIds(seatsId);
        Order order = new Order();
        Integer sum = seats.stream().mapToInt(Seat::getPrice).sum();
        seats.forEach(seat -> seat.setOrder(order));
        seats.forEach(seat -> seat.setReserved(true));
        order.setEmail(email);
        order.setName(name);
        order.setTotal(sum);
        order.setSeatsList(seats);
        orderService.makeOrder(order);
        System.out.println(seats);
        return "redirect:tickets";
    }


}
