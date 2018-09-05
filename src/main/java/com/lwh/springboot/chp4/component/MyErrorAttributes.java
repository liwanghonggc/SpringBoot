package com.lwh.springboot.chp4.component;

import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;

import java.util.Map;

/**
 * 给容器中加上我们自定义的ErrorAttribute,容器原本默认的就不会生效了
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(RequestAttributes requestAttributes, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(requestAttributes, includeStackTrace);
        map.put("company", "lwh");

        //我们的异常处理器携带的数据
        Map<String, Object> ext = (Map<String, Object>)requestAttributes.getAttribute("ext", RequestAttributes.SCOPE_REQUEST);
        map.put("ext", ext);
        return map;
    }
}
