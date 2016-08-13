package com.nexters.neighborhood.controller;

import com.nexters.neighborhood.entity.Room;
import com.nexters.neighborhood.entity.Sample;
import com.nexters.neighborhood.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinhaengji on 2016. 8. 6..
 */

@RestController
@RequestMapping("/user") /** 웹페이지에서 127.0.0.1/user 로 접속 했을 때 **/
public class SampleController {

    @Autowired
    private SampleRepository sampleRepository;

    /** 웹페이지에서 127.0.0.1/user/signUp 으로 접속 했을 때 **/
    @RequestMapping(value = "/signUp", method = {RequestMethod.POST})
    public String signUp(String userId, String name) { /** /signUp으로 들어오면 이 함수를 실행 **/
        Sample sample = new Sample();
        sample.setUserId(userId);
        sample.setName(name);

        sampleRepository.save(sample); /** userid와 name을 가져와서 하나의 user로 저장 **/
        return "userId : " + userId + ", name : " + name;
    }

    @RequestMapping(value = "/signMod", method = {RequestMethod.POST})
    public String signMod(String userId, String name) {
        Room room = new Room();

        Sample savedSample = sampleRepository.findOne(userId); /** 현재 userid와 일치하는 user정보를 가져온다 **/
        savedSample.setName(name);  /** 새로운 name으로 변경 **/

        sampleRepository.save(savedSample);

        return "success!";
    }

    @RequestMapping(value = "/signDel", method = {RequestMethod.POST})
    public String signDel(String userId, String name) {

        Sample savedSample = sampleRepository.findOne(userId);

        sampleRepository.delete(savedSample);

        return "success!";
    }
}
