package org.kosta.gat.model.service;

import javax.annotation.Resource;

import org.kosta.gat.model.dao.DonationDAO;
import org.springframework.stereotype.Service;

@Service
public class DonationServiceImpl implements DonationService {
	@Resource
	private DonationDAO donationDAO;
}
