package org.kosta.gat.model.service;

import javax.annotation.Resource;

import org.kosta.gat.model.dao.AdminDAO;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
	@Resource
	private AdminDAO adminDAO;
}
