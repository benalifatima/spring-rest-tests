package com.worldline.fpl.recruitment.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.worldline.fpl.recruitment.entity.Transaction;

public class TransacrionRowMapper implements RowMapper<Transaction> {

	@Override
	public Transaction mapRow(ResultSet rs, int rowNum)  throws SQLException {
		Transaction transaction=new Transaction();
		transaction.setId(rs.getString("id"));
		transaction.setAccountId(rs.getString("account_id"));
		transaction.setNumber(rs.getString("number"));
		transaction.setBalance(rs.getBigDecimal("balance"));
		return transaction;
	}


}
