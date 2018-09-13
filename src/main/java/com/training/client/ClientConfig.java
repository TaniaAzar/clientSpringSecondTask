package com.training.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.client.message.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.net.Socket;
import java.util.function.Supplier;

@Configuration
public class ClientConfig {

    @Bean
    public ObjectMapper mapper(){
        return new ObjectMapper();
    }

    @Bean
    public String name(){
        return "Tom";
    };

    @Bean
    public Supplier<Request> supplier(String name) throws IOException {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        String message = inFromUser.readLine();
        return () -> new Request(name, message);
    }

    @Bean
    public Runnable executor(ObjectMapper mapper, Supplier<Request> supplier){
        return () ->{
            try {
                Socket clientSocket = new Socket("localhost", 8999);
                DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
                Request client = supplier.get();
                String clientString = mapper.writeValueAsString(client);
                outToServer.writeUTF(clientString);
                outToServer.flush();

                //from server answer
                DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
                String outServerLine = inFromServer.readUTF();

                System.out.println("FROM SERVER: " + outServerLine);

                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}
