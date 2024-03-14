package com.tugcetasyildiz.restaurants.logging;

import com.tugcetasyildiz.restaurants.general.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class LogInterceptor implements HandlerInterceptor {

    private final KafkaProducerService kafkaProducerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String logMessage = String.format("%s => %s" ,
                request.getMethod(),
                request.getRequestURI());

        kafkaProducerService.sendMessage("requestLog", logMessage);
        return true;
    }
}
