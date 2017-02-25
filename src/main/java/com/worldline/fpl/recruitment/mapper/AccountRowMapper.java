package com.worldline.fpl.recruitment.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.worldline.fpl.recruitment.entity.Account;

public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum)  throws SQLException {
		Account account=new Account();
		account.setId(rs.getString("id"));
		account.setNumber(rs.getString("number"));
		account.setType(rs.getString("type"));
		account.setCreationDate(rs.getDate("creation_date"));
		account.setBalance(rs.getBigDecimal("balance"));
		account.setActive(rs.getBoolean("is_active"));
		return account;
	}


}
