package com.worldline.fpl.recruitment.controller.impl;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.worldline.fpl.recruitment.controller.TransactionController;
import com.worldline.fpl.recruitment.controller.TransactionsController;
import com.worldline.fpl.recruitment.entity.Transaction;
import com.worldline.fpl.recruitment.service.TransactionService;

/**
 * Implementation of {@link TransactionController}
 * 
 * @author A525125
 * 
 */

// Exercice 4
@Slf4j
@RestController
public class TransactionsControllerImpl implements TransactionsController {

	private TransactionService transactionService;

	@Autowired
	public TransactionsControllerImpl(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@Override
	public ResponseEntity<Void> addTransactionToAccount(
			@PathVariable("accountId") String accountId,
			@PathVariable("transactionId") String transactionId) {

		transactionService.addTransactiontoAccount(accountId, transactionId);
		return new ResponseEntity(HttpStatus.OK);

	}
	
	@Override
	public ResponseEntity<Void> updateTransaction(@RequestBody Transaction transaction) {

		transactionService.updateTransaction(transaction);
		return new ResponseEntity(HttpStatus.OK);

	}
	

}
