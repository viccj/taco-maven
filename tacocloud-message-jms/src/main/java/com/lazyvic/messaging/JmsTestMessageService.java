package com.lazyvic.messaging;

import com.lazyvic.TacoOrder;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class JmsTestMessageService implements TestMessageService {
    private JmsTemplate jms;

    @Autowired
    public JmsTestMessageService(JmsTemplate jms) {
        this.jms = jms;
    }

//    @Override
//    public void sendMessage(String message) {
//        jms.send(new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                return session.createObjectMessage(message);
//            }
//        });
//    }

    @Override
    public void sendMessage(String order) {
        jms.convertAndSend("tacocloud.order.queue", order,
                this::addOrderSource);
    }

    private Message addOrderSource(Message message) throws JMSException {
        message.setStringProperty("X_ORDER_SOURCE", "WEB");
        return message;
    }


}