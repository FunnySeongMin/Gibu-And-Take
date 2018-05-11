package org.kosta.gat.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EntryDAOImpl implements EntryDAO {
	@Autowired
	private SqlSessionTemplate template;
}
