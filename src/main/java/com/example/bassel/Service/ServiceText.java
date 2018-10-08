package com.example.bassel.Service;


import org.springframework.stereotype.Service;

@Service
public class ServiceText {


    public String processText(String text){

        StringAlignUtil util = new StringAlignUtil(StringAlignUtil.Alignment.LEFT, 80 );
        return util.format(text);
    }

}
