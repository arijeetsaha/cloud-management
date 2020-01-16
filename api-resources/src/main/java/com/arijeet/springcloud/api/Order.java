package com.arijeet.springcloud.api;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    String orderId;

}
