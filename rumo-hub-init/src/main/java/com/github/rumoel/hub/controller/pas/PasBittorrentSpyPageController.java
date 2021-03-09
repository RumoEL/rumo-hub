package com.github.rumoel.hub.controller.pas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.rumoel.hub.service.TorrentService;

@RestController
public class PasBittorrentSpyPageController {

	@Autowired
	TorrentService torrentService;

	@RequestMapping("/pas/btsp")
	public ModelAndView homePasBtsp() {
		ModelAndView mav = new ModelAndView("pas/btsp/bittorrentSpy");

		// table with torrents
		mav.addObject("torrentstable", torrentService.getAllTorrent());

		return mav;
	}
}
