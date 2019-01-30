package com.example.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import com.example.demo.utils.CASUtil;


public class LocalUserInfoFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request_ = (HttpServletRequest)request;
        String loginName = CASUtil.getAccountNameFromCas(request_);
        if(loginName!=null && !"".equals(loginName)){
            request_.getSession().setAttribute("loginName", loginName);
        }

        chain.doFilter(request, response);

	}


	@Override  
    public void destroy() {  
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }    
}
