package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/web3")
public class Web3Controller {
    Web3j web3j = Web3j.build(new HttpService("http://20.196.254.254:8588", new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(10, TimeUnit.SECONDS).build()));

    long balance;
    long currentBlock;

    @GetMapping
    public String getBalance() throws IOException {
        currentBlock = web3j.ethBlockNumber().send().getBlockNumber().longValue();
        System.out.println("currentBlock: " + currentBlock);

        return "true";
    }
}
