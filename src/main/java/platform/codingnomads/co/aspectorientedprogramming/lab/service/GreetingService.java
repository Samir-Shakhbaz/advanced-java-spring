package platform.codingnomads.co.aspectorientedprogramming.lab.service;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class GreetingService {

    public String greeting() {
        return "Hello Spring Developer!";
    }


    public String print2() {return "This prints first";}

}