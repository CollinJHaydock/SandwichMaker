package com.example.sandwichmaker;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "DisplaySandwich", urlPatterns ={"/DisplaySandwich"})
public class DisplaySandwich extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.println("<html><head><title>Display Sandwich</title></head><body>");

        String bread = request.getParameter("bread");
        String meat = request.getParameter("meat");
        String cheese = request.getParameter("cheese");

        List<String> breadOptions = new ArrayList<>();
        breadOptions.add("White");
        breadOptions.add("Rye");
        breadOptions.add("Wheat");

        if (bread.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(breadOptions.size());
            bread = breadOptions.get(randomIndex);
        }

        List<String> meatOptions = new ArrayList<>();
        meatOptions.add("Ham");
        meatOptions.add("Turkey");
        meatOptions.add("Roast Beef");

        if (meat.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(meatOptions.size());
            meat = meatOptions.get(randomIndex);
        }

        List<String> cheeseOptions = new ArrayList<>();
        cheeseOptions.add("Cheddar");
        cheeseOptions.add("Swiss");
        cheeseOptions.add("Provolone");

        if (cheese.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(cheeseOptions.size());
            cheese = cheeseOptions.get(randomIndex);
        }

        out.println("<h1>Simple Sandwich Maker</h1>");
        out.println("The sandwich that you created is a " + cheese + " " + bread + " " + meat + " sandwich.  Great choice!");
        out.println("</body></html>");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("This is currently a work in progress.");

    }
}