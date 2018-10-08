package com.example.bassel.Controller;


import com.example.bassel.Service.ServiceText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerText {

    @Autowired
    private ServiceText serviceText;


    @RequestMapping(value = "/text", method = RequestMethod.POST,consumes = MediaType.TEXT_PLAIN_VALUE)
    public String processText(@RequestBody String text){
        return  serviceText.processText(text);
    }
    
     @RequestMapping(value = "/text", method = RequestMethod.GET)
    public String DisplayText(){
        return  "Veuillez envoyer une requête POST vers cet url";
    }

}
