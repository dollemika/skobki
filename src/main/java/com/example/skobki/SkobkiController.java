package com.example.skobki;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.Scanner;

@Controller
public class SkobkiController {
    @GetMapping("/check")
    public String readfile(@RequestParam(name="filename") String fname, Model model){
        model.asMap().put("filename", fname);
        try {
            fname = "src//main//resources//files//"+fname;
            Skobki s = new Skobki();
            s.readFromFile(fname);
            model.addAttribute("skobki", s.allbrackets);
            int res = s.check();
            model.addAttribute("result", res);
            return "result";
        }
        catch (Exception e){
            model.addAttribute("error", e.getMessage());
            return "check";
        }
    }
}
