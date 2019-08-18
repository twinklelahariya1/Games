package com.booking.controller;


import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.booking.model.Seat;
import com.booking.service.OrderService;
import com.booking.service.SeatService;
import com.fasterxml.jackson.annotation.JsonView;


@Controller
public class SeatController {

    private final SeatService seatService;
    private final OrderService orderService;

    @Autowired
    public SeatController(SeatService seatService, OrderService orderService) {
        this.seatService = seatService;
        this.orderService = orderService;
    }

    @GetMapping(value = "/tickets")
    public String getAllSeats(Model model) {
        List<Seat> seats = seatService.getAllSeats();
        seats.sort(Comparator.comparing(Seat::getId));
        model.addAttribute("seats", seats);
        return "booking";
    }

    @PostMapping(value = "/reset")
    public String resetReservation(Model model) {
        List<Seat> seats = seatService.getAllSeats();
        model.addAttribute("seats", seats);
        seats.stream()
                .filter(Seat::isReserved)
                .forEach(seat -> {
                    seat.setReserved(false);
                    seat.setOrder(null);
                });
        seatService.updateSeats(seats);
        orderService.deleteAllOrders();
        return "redirect:tickets";
    }
}
