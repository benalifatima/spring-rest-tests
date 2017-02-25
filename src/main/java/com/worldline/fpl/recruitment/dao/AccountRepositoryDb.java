package com.worldline.fpl.recruitment.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.worldline.fpl.recruitment.entity.Account;
import com.worldline.fpl.recruitment.json.AccountResponse;

/**
 * Account repository
 * 
 * @author A525125
 *
 */
public interface AccountRepositoryDb {

	/**
	 * Get account by user
	 * 
	 * @param p
	 *            the pageable information
	 * @return the account list
	 */
	Page<Account> findAll(Pageable p);

	/**
	 * Get account
	 * 
	 * @param accountId
	 *            the account id
	 * @return
	 */
	Account findById(String accountId);

	/**
	 * Check if an account exists
	 * 
	 * @param accountId
	 *            the account id
	 * @return true if the account exists
	 */
	boolean exists(String accountId);
}
