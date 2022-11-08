package com.develhope.java5.interceptorsreview.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import com.develhope.java5.interceptorsreview.service.SupplierService;

public class SupplierHeaderInterceptor implements HandlerInterceptor {
    @Autowired
    private SupplierService supplierService;

    Logger logger = Logger.getLogger(SupplierHeaderInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if(!request.getRequestURI().contains("/fruits"))
            return true;

        String supplierKey = request.getHeader("X-Supplier-Key");

        logger.info("Supplier key: " + supplierKey);

        if(supplierKey == null) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            logger.warn("Missing supplier key");
            return false;
        }

        if(!supplierService.exists(supplierKey)) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            logger.warn("Unknown supplier");
            return false;
        }

        return true;
    }
}
