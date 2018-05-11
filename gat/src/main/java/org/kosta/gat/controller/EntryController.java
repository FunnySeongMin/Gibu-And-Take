package org.kosta.gat.controller;

import javax.annotation.Resource;

import org.kosta.gat.model.service.EntryService;
import org.springframework.stereotype.Controller;

@Controller
public class EntryController {
	@Resource
	private EntryService entryService;
}
