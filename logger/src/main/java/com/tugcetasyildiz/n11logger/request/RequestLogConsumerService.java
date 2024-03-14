package com.tugcetasyildiz.n11logger.request;

import com.tugcetasyildiz.n11logger.error.ErrorLog;
import com.tugcetasyildiz.n11logger.error.ErrorLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class RequestLogConsumerService {

    private final RequestLogRepository requestLogRepository;


    @KafkaListener(topics = "requestLog", groupId = "log-consumer-group")
    public void consumeInfos(String message){

        RequestLog requestLog = new RequestLog();
        requestLog.setDate(LocalDateTime.now());
        requestLog.setMessage(message);
        requestLog.setDescription("Request");

        requestLogRepository.save(requestLog);
    }
}