package com.levanov.busstations.controller;

import com.levanov.busstations.service.DirectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DirectController {
    @Autowired
    private DirectService directService;

    @GetMapping("/direct/{first}/{second}")
    public Map<String, String> findDirectFirstToSecond(@PathVariable Integer first, @PathVariable Integer second) {
        HashMap<String, String> response = new HashMap<>();

        response.put("from", Integer.toString(first));
        response.put("to", Integer.toString(second));
        response.put("direct", directService.findDirect(first, second));

        return response;
    }
}
