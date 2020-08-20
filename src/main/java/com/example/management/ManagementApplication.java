package com.example.management;

import com.example.management.controller.AskDayOffController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class, args);

    }


    @Bean
    public CommandLineRunner demo(AskDayOffController controller) {
        return (args) -> {
            //  controller.saveCEO(new Employee());
            //		controller.saveEmployee(new Employee());
            //     controller.saveCat(new Category());
            //     controller.saveCatElement(new Category_element());
            //   controller.printCategoryElements("role");
            //  controller.saveAskDayOff(new AskDayOff());
            //  controller.updateAskDayOffStatus(9L, "accepted");
            //  controller.check();
            //   controller.saveEmail(new Email());
            //    controller.printEmails();
            //   controller.deleteEmail(56L);
            //  controller.updateEmployee(15L);
            // controller.loadAskDayOff(9L);

        };
        }
    }


