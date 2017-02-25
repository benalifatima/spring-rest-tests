
CREATE TABLE account(id VARCHAR(50) ,number VARCHAR(50),type VARCHAR(50),balance
DECIMAL(130, 128),creation_date TIMESTAMP,is_active bit,PRIMARY KEY (id));

CREATE TABLE trasaction(id VARCHAR(50) ,account_id VARCHAR(50),number VARCHAR(50),balance
DECIMAL(130, 128),PRIMARY KEY (id));
