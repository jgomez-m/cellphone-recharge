CREATE TABLE consume(
	consume_id INT NOT NULL AUTO_INCREMENT,
	mobile_phone VARCHAR(15) NOT NULL,
	number_seconds INT NOT NULL,
	PRIMARY KEY (consume_id)
);

CREATE TABLE refill(
	refill_id INT NOT NULL AUTO_INCREMENT,
	mobile_phone VARCHAR(15) NOT NULL,
	price INT NOT NULL,
	PRIMARY KEY (refill_id)
);

CREATE TABLE params(
	params_id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(30) NOT NULL,
	param_value VARCHAR(50) NOT NULL,
	PRIMARY KEY (params_id)
);	
