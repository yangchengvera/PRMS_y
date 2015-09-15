
CREATE TABLE `phoenix`.`presenter-profile`
(
profileID int NOT NULL,
  photo BLOB NULL COMMENT '',
  sitelink VARCHAR(45) NULL COMMENT '',
PRIMARY KEY (profileID),
CONSTRAINT fk_PerOrders FOREIGN KEY (profileID)
REFERENCES phoenix.presenter(name)
)