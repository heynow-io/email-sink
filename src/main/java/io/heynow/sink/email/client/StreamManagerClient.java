package io.heynow.sink.email.client;

import io.heynow.sink.email.model.streammanager.Operator;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by k.lamparski on 07/09/16.
 */
@FeignClient("stream-manager")
public interface StreamManagerClient {

    @RequestMapping(value = "/operators/{id}", method = RequestMethod.GET)
    Operator getOperatorDefinition(String id);
}
