package com.example.demo.utils;

import javax.servlet.http.HttpServletRequest;

import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.validation.Assertion;

public class CASUtil {
	public static String getAccountNameFromCas(HttpServletRequest request) {
        Assertion assertion = (Assertion) request.getSession().getAttribute(AbstractCasFilter.CONST_CAS_ASSERTION);
       if(assertion!= null){
           AttributePrincipal principal = assertion.getPrincipal();
           return principal.getName();
       }else return null;

    }

}
