package com.worldline.fpl.recruitment.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.worldline.fpl.recruitment.dao.TransactionRepository;
import com.worldline.fpl.recruitment.dao.TransactionRepositoryDb;
import com.worldline.fpl.recruitment.entity.Transaction;
import com.worldline.fpl.recruitment.mapper.TransacrionRowMapper;

/**
 * Implementation of {@link TransactionRepository}
 * 
 * @author A525125
 *
 */
@Repository
public class TransactionRepositoryDbImpl implements TransactionRepositoryDb {
	 @Autowired
	    private JdbcTemplate jdbcTemplate;
	private List<Transaction> transactions;

//	@Override
//	public void afterPropertiesSet() throws Exception {
//		transactions = new ArrayList<>();
//		{
//			Transaction transaction = new Transaction();
//			transaction.setAccountId("1");
//			transaction.setBalance(BigDecimal.valueOf(42.12));
//			transaction.setId("1");
//			transaction.setNumber("12151885120");
//			transactions.add(transaction);
//		}
//		{
//			Transaction transaction = new Transaction();
//			transaction.setAccountId("1");
//			transaction.setBalance(BigDecimal.valueOf(456.00));
//			transaction.setId("2");
//			transaction.setNumber("12151885121");
//			transactions.add(transaction);
//		}
//		{
//			Transaction transaction = new Transaction();
//			transaction.setAccountId("1");
//			transaction.setBalance(BigDecimal.valueOf(-12.12));
//			transaction.setId("3");
//			transaction.setNumber("12151885122");
//			transactions.add(transaction);
//		}
//	}

	@Override
	public Page<Transaction> getTransactionsByAccount(String accountId,
			Pageable p) {
		List<Transaction> transactions=jdbcTemplate.query(
	            "select * from transaction where account_id=?",
	            new Object[]{accountId}, new TransacrionRowMapper());
		return new PageImpl<Transaction>(transactions);
	}

	@Override
	public void updateTransaction(Transaction transaction) {
		int index = transactions.indexOf(transaction);
		transactions.set(index, transaction);
		this.jdbcTemplate.update(
                "update transaction set account_id=? number=?, balance=? where id = ?", 
                transaction.getAccountId(),transaction.getNumber(), transaction.getBalance(),transaction.getId());
	}
	@Override
	public Transaction findById(String transactionId) {
		return jdbcTemplate.queryForObject(
	            "select * from transaction where id=?",
	            new Object[]{transactionId}, new TransacrionRowMapper());
	}


}
