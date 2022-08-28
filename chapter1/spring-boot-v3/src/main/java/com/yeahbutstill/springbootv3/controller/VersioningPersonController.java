package com.yeahbutstill.springbootv3.controller;

import com.yeahbutstill.springbootv3.entity.PersonV1;
import com.yeahbutstill.springbootv3.entity.PersonV2;
import com.yeahbutstill.springbootv3.entity.versioning.Name;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/persons")
    public PersonV1 getOfPersonV1() {
        return PersonV1.builder()
                .firstName("Dani Setiawan")
                .build();
    }

    @GetMapping("/v2/persons")
    public PersonV2 getOfPersonV2() {
        return PersonV2.builder()
                .name(new Name("Dani", "Setiawan"))
                .build();
    }

    @GetMapping(path = "/persons", params = "version=1")
    public PersonV1 getOfPersonV1ReqParam() {
        return PersonV1.builder()
                .firstName("Dani Setiawan")
                .build();
    }

    @GetMapping(path ="/persons", params = "version=2")
    public PersonV2 getOfPersonV2ReqParam() {
        return PersonV2.builder()
                .name(new Name("Dani", "Setiawan"))
                .build();
    }

//    @GetMapping(path = "/persons/header", headers = "X-API-VERSION=1")
//    public PersonV1 getOfPersonV1ReqHeader() {
//        return PersonV1.builder()
//                .firstName("Dani Setiawan")
//                .build();
//    }
//
//    @GetMapping(path ="/persons/header", headers = "X-API-VERSION=2")
//    public PersonV2 getOfPersonV2ReqHeader() {
//        return PersonV2.builder()
//                .name(new Name("Dani", "Setiawan"))
//                .build();
//    }
//
//    @GetMapping(path = "/persons/accept-header", produces = "application/vnd.company.app-v1+json")
//    public PersonV1 getOfPersonV1AcceptHeader() {
//        return PersonV1.builder()
//                .firstName("Dani Setiawan")
//                .build();
//    }
//
//    @GetMapping(path ="/persons/accept-header", produces = "application/vnd.company.app-v2+json")
//    public PersonV2 getOfPersonV2AcceptHeader() {
//        return PersonV2.builder()
//                .name(new Name("Dani", "Setiawan"))
//                .build();
//    }

}
