package com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.config.logging;

import com.tugcetasyildiz.n11TalentHubBackendBootcampFinalCase.general.KafkaProducerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class LogInterceptor implements HandlerInterceptor {

    private final KafkaProducerService kafkaProducerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String logMessage = String.format("%s => %s",
                request.getMethod(),
                request.getRequestURI());

        kafkaProducerService.sendMessage("requestLog", logMessage);
        return true;
    }
}
