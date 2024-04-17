package com.lazyvic.messaging;


import com.lazyvic.TacoOrder;

public interface OrderMessagingService {
    void sendOrder(TacoOrder order);
}
