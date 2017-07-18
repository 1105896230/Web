package com.cxf;

import javax.jws.WebService;

/**
 * Created by 林其望 on 2017/7/18.
 */
@WebService
public interface HelloService {
     String sayHello(String name);
}
