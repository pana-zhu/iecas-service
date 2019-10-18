package com.pana.course.filter;

import com.pana.thrift.user.dto.UserDTO;
import com.pana.user.client.LoginFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class CourseFilter extends LoginFilter {

    @Value("${user.edge.service}")
    private String userEdgeServiceAddr;
    @Value("${user.edge.host.addr}")
    private String userHostAddr;

    @Override
    protected String userEdgeServiceAddr() {
        return userEdgeServiceAddr;
    }

    @Override
    protected void login(HttpServletRequest request, HttpServletResponse response, UserDTO userDTO) {
        request.setAttribute("user", userDTO);
    }

	@Override
	protected String userhostAddr() {
		// TODO Auto-generated method stub
		return userHostAddr;
	}
}
