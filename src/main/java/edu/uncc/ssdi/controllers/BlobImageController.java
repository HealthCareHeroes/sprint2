package edu.uncc.ssdi.controllers;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uncc.ssdi.model.BlobFileStorage;
import edu.uncc.ssdi.service.BlobService;

@RestController
@RequestMapping("/")
public class BlobImageController {

	@Autowired
	private BlobService blobService;

	@RequestMapping(value = "/getStorageFile/{id}", method = RequestMethod.GET)
	private @ResponseBody List<BlobFileStorage> showFiles(@PathVariable Long id) {
		
		
		return blobService.findByMedId(id);

	}

	@RequestMapping(value = "getImage/{id}", method = RequestMethod.GET)
	public void getImage(@PathVariable Long id, HttpServletResponse response) throws IOException, SQLException {
		response.setContentType("image/jpeg"); // "image/png" ... you may need to present the right content type here
		Blob image = blobService.getContent(id);
		int blobLength = (int) image.length();
		if (image != null) {
			response.getOutputStream().write(image.getBytes(1, blobLength));
		}
	}

}
