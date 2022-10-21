CREATE TABLE MORTGAGE_RATE(
	ID BIGSERIAL PRIMARY KEY,
	MATURITY_PERIOD INTEGER NOT NULL,
	INTEREST_RATE FLOAT NOT NULL,
	LAST_UPDATE TIMESTAMP NOT NULL
);