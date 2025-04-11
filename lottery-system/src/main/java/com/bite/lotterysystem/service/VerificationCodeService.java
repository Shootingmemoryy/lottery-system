package com.bite.lotterysystem.service;


public interface VerificationCodeService {


    void sendVerificationCode(String phoneNumber);

    String getVerificationCode(String phoneNumber);

}
