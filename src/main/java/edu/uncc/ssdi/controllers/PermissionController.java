package edu.uncc.ssdi.controllers;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uncc.ssdi.model.Permission;
import edu.uncc.ssdi.service.PermService;

@RestController	
@RequestMapping("/")
public class PermissionController {
	@Autowired
	private	PermService permService;

	@RequestMapping(value="/givePermission/", method = RequestMethod.PUT) // Map ONLY GET Requests
	public @ResponseBody int givePermission(HttpServletRequest request, HttpServletResponse response,
			@RequestBody Permission permObj) {
		int stat = permService.grantPermission(permObj);
		return stat;
	}
} // end of class