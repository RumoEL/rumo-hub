package com.github.rumoel.hub.controller.pas;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.rumoel.hub.service.FileStorage;
import com.github.rumoel.hub.service.TorrentService;

@Controller
@RequestMapping("/pas/btsp")
public class PBSpyPageController {
	@Autowired
	TorrentService torrentService;

	@Autowired
	FileStorage fileStorage;

	@RequestMapping("")
	public ModelAndView homePasBtsp() {
		ModelAndView mav = new ModelAndView("pas/btsp/index");

		// table with torrents
		mav.addObject("torrentstable", torrentService.getAllTorrent());

		return mav;
	}

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("pas/btsp/bittorrentSpy");
		// table with torrents
		mav.addObject("torrentstable", torrentService.getAllTorrent());

		return mav;
	}

	@RequestMapping("/add")
	public ModelAndView homePasBtspAddTorrentPage() {
		return new ModelAndView("pas/btsp/tr/TorrentAdd");
	}

	@PostMapping("/add")
	public ModelAndView uploadMultipartFile(@RequestParam("uploadfile") MultipartFile[] multipartFiles) {
		ModelAndView mav = new ModelAndView("pas/btsp/tr/TorrentAdd");
		ArrayList<String> msgsOK = new ArrayList<>();
		ArrayList<String> msgsF = new ArrayList<>();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		for (MultipartFile multipartFile : multipartFiles) {
			try {
				fileStorage.store(multipartFile, username, "torrents");
				msgsOK.add(multipartFile.getOriginalFilename());
			} catch (Exception e) {
				msgsF.add(multipartFile.getOriginalFilename());
				e.printStackTrace();
			}
		}
		mav.addObject("message",
				"Status: OK:" + Arrays.toString(msgsOK.toArray()) + " FAIL:" + Arrays.toString(msgsF.toArray()));
		return mav;
	}

}
