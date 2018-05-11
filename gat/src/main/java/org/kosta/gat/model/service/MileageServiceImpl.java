package org.kosta.gat.model.service;

import javax.annotation.Resource;

import org.kosta.gat.model.dao.MileageDAO;
import org.springframework.stereotype.Service;

@Service
public class MileageServiceImpl implements MileageService {
	@Resource
	private MileageDAO mileageDAO;
}
