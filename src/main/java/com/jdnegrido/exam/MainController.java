package com.jdnegrido.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.lang.Math;

@RestController
@RequestMapping("main")
public class MainController {

@Autowired
    private NumberRepository numberRepository;
@CrossOrigin
@PostMapping(path="/add")
    public @ResponseBody String addNewNumber (@RequestParam int number, @RequestParam String res) {
        Number n = new Number();
        n.setNumber(number);
        n.setResponse(checkIfPerfectSquare(number));
        numberRepository.save(n);
        return "Saved";
    }

@GetMapping(path="/all")
    public @ResponseBody Iterable<Number> getAllNumbers() {
        return numberRepository.findAllByOrderByIdDesc();
    }
@GetMapping("test")
	public String test() {
		return "success!";
	}

    static String checkIfPerfectSquare(int n)
    {
        for (int i = 1; i * i <= n; i++) {
            if ((n % i == 0) && (n / i == i)) {
                return sumSquare(n);
            }
        }
        return "{}";
    }
    static String sumSquare(int n)
    {
        int avg=0;
        long sq=0;
        for (long i = 1; i * i <= n; i++){
            for (long j = 1; j * j <= n; j++){
                if (i * i + j * j == n) {
                    sq=(long)Math.sqrt(n);
                    avg=(int)(sq+j+i)/3;
                    return "{a:"+i+", b:"+j+", c:"+sq+", avg:"+avg+"}";
                }
            }
        }
        return "{}";
    }
}