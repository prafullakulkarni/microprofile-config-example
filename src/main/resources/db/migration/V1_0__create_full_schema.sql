CREATE TABLE member (ID BIGINT NOT NULL, FIRST_NAME VARCHAR(255) NOT NULL, LAST_NAME VARCHAR(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE status (ID BIGINT NOT NULL, MEMBER_ID BIGINT, NAME VARCHAR(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE role (ID BIGINT NOT NULL, ROLE_NAME VARCHAR(255) NOT NULL, PRIMARY KEY (ID));
CREATE TABLE MEMBER_ROLE (ROLE_ID BIGINT NOT NULL, MEMBER_ID BIGINT NOT NULL, PRIMARY KEY (ROLE_ID, MEMBER_ID));
ALTER TABLE status ADD CONSTRAINT FK_status_MEMBER_ID FOREIGN KEY (MEMBER_ID) REFERENCES member (ID);
ALTER TABLE MEMBER_ROLE ADD CONSTRAINT FK_MEMBER_ROLE_MEMBER_ID FOREIGN KEY (MEMBER_ID) REFERENCES role (ID);
ALTER TABLE MEMBER_ROLE ADD CONSTRAINT FK_MEMBER_ROLE_ROLE_ID FOREIGN KEY (ROLE_ID) REFERENCES member (ID);
CREATE SEQUENCE role_seq INCREMENT BY 50 START WITH 50;
CREATE SEQUENCE status_seq INCREMENT BY 50 START WITH 50;
CREATE SEQUENCE member_seq INCREMENT BY 50 START WITH 50;