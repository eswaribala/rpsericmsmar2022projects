package com.eric.paymentapi.channels;

import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(PaymentChannel.class)
public class StreamConfig {

}
