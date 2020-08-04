package com.estest3.demo.Controller;

import com.estest3.demo.Domain.ESbean;
import com.estest3.demo.Domain.ESbean2;
import com.estest3.demo.Domain.Info;
import com.estest3.demo.Utils.Filter;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estest3.demo.Utils.SearchES;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller
@RestController
public class CarnormController {

    @RequestMapping(path = "/carknowledge/paper/regulations",method = RequestMethod.POST)
    public Info search_es(@RequestBody String body) throws Exception {
//        String labelName = body.split("\"")[3];
        //用于得到post的值
        Gson gson = new Gson();
        Map<String, String> bodymap = new HashMap<String, String>();
        bodymap = gson.fromJson(body, bodymap.getClass());//jsonStr需要转换的值
        String labelName = bodymap.get("value");

        System.out.println(labelName);

        Map<String, Object> allInfo = new HashMap<>();

        SearchES searchES = new SearchES();
        List<ESbean> eSbeans = new ArrayList<>();  //ES相关信息列表

        eSbeans = searchES.search(labelName);

        System.out.println(eSbeans);
        //return "success";
        System.out.println(eSbeans.size());

        List<ESbean2> newESbeans = new ArrayList<>();
        newESbeans= Filter.filter(eSbeans);

        System.out.println(newESbeans);
        System.out.println(newESbeans.size());

        //allInfo.put("related",newESbeans);

        //return newESbeans.toString();
        return  Info.createOk(newESbeans);
    }

}
