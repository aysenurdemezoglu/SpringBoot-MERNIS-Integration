package com.example.FirstTask.endpoint;
import com.example.FirstTask.model.Person;
import com.example.FirstTask.service.PersonService;
import com.example.FirstTask.service.TcService;
import com.example.firsttask.service.TcnodogrulaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TcEndpoint
{
    private static final String NAMESPACE_URI = "http://example.com/FirstTask/service";
    private final TcService tcService;
    private PersonService personService;

    @Autowired
    public TcEndpoint(TcService tcService) {
        this.tcService = tcService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "tcnodogrulaRequest")
    @ResponsePayload
    public TcnodogrulaResponse getStudent(@RequestPayload com.example.FirstTask.service.TcnodogrulaRequest request) {
        TcnodogrulaResponse response = new TcnodogrulaResponse();
        boolean result = tcService.tcnodogrula(request.getTc(), request.getAd(), request.getSoyad(), request.getDogumyili());
        response.setResult(result);
        return response;
    }

}