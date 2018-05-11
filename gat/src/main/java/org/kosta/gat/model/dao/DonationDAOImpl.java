package org.kosta.gat.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DonationDAOImpl implements DonationDAO {
	@Autowired
	private SqlSessionTemplate template;
}
