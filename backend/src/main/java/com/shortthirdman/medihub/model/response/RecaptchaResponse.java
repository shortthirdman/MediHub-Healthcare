package com.shortthirdman.medihub.model.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class RecaptchaResponse implements Serializable {

    private String recaptchaResponse;
}
