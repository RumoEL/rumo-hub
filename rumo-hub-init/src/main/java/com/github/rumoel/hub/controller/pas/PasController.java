package com.github.rumoel.hub.controller.pas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PasController {
	@RequestMapping("/pas")
	public String homePas() {
		return "pas/IndexPas";
	}
}
