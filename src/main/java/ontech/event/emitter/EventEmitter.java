package ontech.event.emitter;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@NoArgsConstructor
public class EventEmitter {

    final String storeExchange = "events-store";

    @Autowired
    StreamBridge streamBridge;

    String senderServiceName;

    public EventEmitter(String senderServiceName) {
        this.senderServiceName = senderServiceName;
    }

    /*
        message: an object which client is sending on the queue
        queue: it's the name of the queue, where client is sending the message to
     */
//    @Async("taskExecutor")
    public <T> void emit(T message, String queue) {
        System.out.println("Current Thread Name- " + Thread.currentThread().getName());
        streamBridge.send(storeExchange, new EventMessage<>(senderServiceName, message, queue, new Date()));
    }
}
