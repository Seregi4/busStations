package com.levanov.busstations.controller;

import com.levanov.busstations.service.DirectServiceH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/apih2")
public class DirectControllerH2 {
    @Autowired
    DirectServiceH2 directServiceH2;

    @GetMapping("/direct/{firstStation}/{secondStation}")
    public Map<String, String> findDirectFirstToSecond(@PathVariable Integer firstStation, @PathVariable Integer secondStation) {
        HashMap<String, String> response = new HashMap<>();

        response.put("from", Integer.toString(firstStation));
        response.put("to", Integer.toString(secondStation));
        response.put("direct", directServiceH2.findDirectH2(firstStation, secondStation));

        return response;
    }
}
