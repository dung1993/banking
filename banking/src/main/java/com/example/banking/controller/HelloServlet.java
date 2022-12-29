package com.example.banking.controller;

import com.example.banking.service.ICustomerService;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CustomerServlet", urlPatterns = {"/customers",""})
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService;
}
