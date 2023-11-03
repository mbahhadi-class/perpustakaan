package id.starter.perustakaan;

import id.starter.perustakaan.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;

@SpringBootApplication
public class PerustakaanApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerustakaanApplication.class, args);
    }

    public static User getCurrentUser(){
        try{
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return (User) principal;

        }catch (Exception ignore){
        }
        return null;
    }

}
