package dev.felipe.demo_kafka.consumer;

import dev.felipe.demo_kafka.dto.OrdemCompra;
import dev.felipe.demo_kafka.producer.KafkaProducerApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerApplication {

    private final Logger log = LoggerFactory.getLogger(KafkaProducerApplication.class);

    @KafkaListener(topics = "ordem-compra", groupId = "grupo_ordem_compra")
    public void consumirOrdemCompra(OrdemCompra ordemCompra, Acknowledgment ack) {
        try {
            log.info("Ordem de compra recebida: {}", ordemCompra);
            ack.acknowledge();

        } catch (Exception e) {
            log.error("Erro ao processar a ordem de compra: {}", e.getMessage());
        }
    }
}
