package com.exemplo.jeff.sqs.poc.springbootsqs.config;


import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SQSConfiguration {


    @Value("${cloud.aws.credentials.access-key}")
    private String accesssKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String secretyKey;

    @Bean
    public QueueMessagingTemplate queueMessagingTemplate(AmazonSQSAsync amazonSQSAsync){
        return new QueueMessagingTemplate(amazonSQSAsync());
    }

    private AmazonSQSAsync amazonSQSAsync() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(accesssKey, secretyKey);
                return AmazonSQSAsyncClientBuilder
                        .standard()
                        .withRegion(Regions.US_EAST_2)
                        .withCredentials(new AWSStaticCredentialsProvider(credentials))
                        .build();
    }


}
