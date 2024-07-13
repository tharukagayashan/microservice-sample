package com.projects.paymentcenter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {

    @Id
    @BsonId
    @Field(name = "payment_id")
    private String paymentId;

    @Field(name = "type")
    private String type; // Credit Card, Debit Card, Net Banking, UPI, Wallet

    @Field(name = "status")
    private String status; // Success, Failure, Pending

    @Field(name = "amount")
    private double amount;

    @Field(name = "date")
    private String date;

    @Field(name = "time")
    private String time;

    @Field(name = "user_id")
    private Long userId;

    @Field(name = "description")
    private String description;

}