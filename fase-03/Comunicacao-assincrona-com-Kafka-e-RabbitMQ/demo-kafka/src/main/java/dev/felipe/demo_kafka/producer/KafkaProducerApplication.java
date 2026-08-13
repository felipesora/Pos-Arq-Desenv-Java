package dev.felipe.demo_kafka.producer;

import dev.felipe.demo_kafka.dto.OrdemCompra;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class KafkaProducerApplication implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(KafkaProducerApplication.class);

    @Autowired
    private KafkaTemplate<String, OrdemCompra> kafkaTemplate;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            OrdemCompra ordemCompra = new OrdemCompra(1L, "Notebook: " + i, 2, 3500.00);
            kafkaTemplate.send("ordem-compra", ordemCompra);
            log.info("Ordem de compra enviada: {}", ordemCompra);
        }
    }
}
