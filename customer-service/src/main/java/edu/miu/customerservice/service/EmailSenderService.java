package edu.miu.customerservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import edu.miu.customerservice.dto.request.EmailRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender javaMailSender;

    @HystrixCommand(fallbackMethod = "emailFallBack")
    public String sendEmail(EmailRequestDTO requestDTO) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(requestDTO.getSendTo());

        msg.setSubject("Order Confirmation");
        msg.setText("Dear " + requestDTO.getCustomerName() + "," + "\n" + requestDTO.getMessage());

        //TODO: Sending Email is not happening because of configuration issue
//        javaMailSender.send(msg);
        return "Email Sent....";
    }

    public String emailFallBack(EmailRequestDTO requestDTO) {
        return "Sorry, email cannot be sent to "+requestDTO.getCustomerName()+". But Order has been placed";
    }
}
