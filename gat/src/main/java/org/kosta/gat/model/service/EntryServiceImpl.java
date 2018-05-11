package org.kosta.gat.model.service;

import javax.annotation.Resource;

import org.kosta.gat.model.dao.EntryDAO;
import org.springframework.stereotype.Service;

@Service
public class EntryServiceImpl implements EntryService {
	@Resource
	private EntryDAO entryDAO;
}
