package com.worldline.fpl.recruitment.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.worldline.fpl.recruitment.dao.AccountRepository;
import com.worldline.fpl.recruitment.dao.AccountRepositoryDb;
import com.worldline.fpl.recruitment.entity.Account;
import com.worldline.fpl.recruitment.mapper.AccountRowMapper;

/**
 * Implementation of {@link AccountRepository}
 * 
 * @author A525125
 *
 */
@Repository
public class AccountRepositoryDbImpl implements AccountRepositoryDb {
	 @Autowired
	  private JdbcTemplate jdbcTemplate;



	@Transactional(readOnly=true)
	public Page<Account> findAll(Pageable p) {
		List<Account>accounts=  jdbcTemplate.query("select * from account", 
                new AccountRowMapper());
		return new PageImpl<Account>(accounts);
	}
	
	
	
	
	@Transactional(readOnly=true)
	public Account findById(String accountId) {
		
		return jdbcTemplate.queryForObject(
	            "select * from account where id=?",
	            new Object[]{accountId}, new AccountRowMapper());
	}

	public boolean exists(String accountId) {
		Account account=this.findById(accountId);
		if(account!=null)
		{
			return true;
		}
		else{
			return false;
		}
	}
}
