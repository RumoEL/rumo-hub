package com.github.rumoel.hub.header;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.boot.SpringApplication;

import com.github.rumoel.hub.config.RumoHubConfig;

import lombok.Getter;
import lombok.Setter;

public class RumoHubHeader {
	private RumoHubHeader() {
	}

	public static SpringApplication sa;
	@Getter
	private static final File ROOTDIR = new File("RUMOEL_HUB");
	@Getter
	private static final File CONFIGFILE = new File(getROOTDIR(), "config.yml");
	@Getter
	@Setter
	private static RumoHubConfig config = new RumoHubConfig();

	// PAS-BITTORRENT-SPY
	@Getter
	private static ScheduledExecutorService pasBittorrentSpyExecutorServiceFiles = Executors.newScheduledThreadPool(10);
	@Getter
	private static ScheduledExecutorService pasBittorrentSpyExecutorServiceDB = Executors.newScheduledThreadPool(10);
	@Getter
	private ExecutorService pasBittorrentSpyExecutorServiceParse = Executors.newFixedThreadPool(10);
	@Getter
	private ExecutorService pasBittorrentSpyExecutorServiceSender = Executors.newFixedThreadPool(5);
}
