package org.hld.hugold.controller;

import org.hld.hugold.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerView {
    @Autowired
    private CustomerService service;

    @GetMapping("/show")
    public String htmlView(Model model){
        model.addAttribute("customers",service.getAllCustomerDto());

        return "show";
    }
}
