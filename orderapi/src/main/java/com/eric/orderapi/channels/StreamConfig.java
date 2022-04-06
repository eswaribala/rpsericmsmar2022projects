package com.eric.orderapi.channels;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(OrderChannel.class)
public class StreamConfig {

}
