
insert into account(id, number, type, balance,creation_date,is_active)values ('1', '01000251215', 'SAVING',4210.42,GETDATE(),1);
insert into account(id, number, type, balance,creation_date,is_active)values ('2', '01000251216', 'CURRENT',25.12,GETDATE(),0);


insert into transaction(id, account_id, number,balance)values ('1', '1', '12151885120',42.12);
insert into transaction(id, account_id, number,balance)values ('2', '1', '12151885121',456.00);		
insert into transaction(id, account_id, number,balance)values ('3', '1', '12151885122',12.12);






