package com.worldline.fpl.recruitment.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.worldline.fpl.recruitment.entity.Transaction;

/**
 * Transaction repository
 * 
 * @author A525125
 *
 */
/**
 * @author candidat_awl
// *
 */
/**
 * @author candidat_awl
// *
 */
public interface TransactionRepository {

	/**
	 * Get transactions by account
	 * 
	 * @param accountId
	 *            the account id
	 * @param p
	 *            the pageable information
	 * @return
	 */
	Page<Transaction> getTransactionsByAccount(String accountId, Pageable p);

	void updateTransaction(Transaction transaction);

	Optional<Transaction> findById(String transactionId);

	void deleteTransaction(String idTransaction);
}
