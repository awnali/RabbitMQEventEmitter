package ontech.event.emitter;

import lombok.Value;

import java.util.Date;

@Value
public class EventMessage<T> {

    String senderServiceId;
    T body;
    String receiverQueueName;
    Date sentAt;
}
