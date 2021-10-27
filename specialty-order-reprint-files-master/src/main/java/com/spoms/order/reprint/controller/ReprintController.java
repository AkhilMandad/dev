package com.spoms.order.reprint.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;
import com.spoms.order.reprint.model.OrderDetailsBO;
import com.spoms.order.reprint.service.OrderDetailsService;
import com.spoms.order.reprint.util.ExportPDF;

@RestController
public class ReprintController {

	@Autowired
	private OrderDetailsService orderService;

	@PostMapping("/getOrderDetails")
	public ResponseEntity<?> getOrderDetails(@RequestParam("shipment_num") String shipment_num) {
		OrderDetailsBO output_data = orderService.getOrderDetailsService(shipment_num);
		return new ResponseEntity<Object>("", HttpStatus.ACCEPTED);
	}

	@GetMapping("/users/export/pdf/{shipment_num}")
	public void exportToPDF(HttpServletResponse response, @PathParam("shipment_num") String shipment_num)
			throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		OrderDetailsBO output_data = orderService.getOrderDetailsService(shipment_num);

		ExportPDF exporter = new ExportPDF(output_data);
		exporter.export(response);

	}
}
