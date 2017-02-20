package com.dufeng.goal;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application implements CommandLineRunner
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }
    
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot: ");
            
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for(String beanName : beanNames) {
                System.out.println(beanName);
            }
        };
        
    }

    /**
     * 当applicatoin context加载之后，会执行这个方法
     */
    @Override
    public void run(String... strings) throws Exception {
        for(int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
