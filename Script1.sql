--<ScriptOptions statementTerminator=";"/>

ALTER TABLE member DROP CONSTRAINT member_pkey;

DROP INDEX member_pkey;

DROP TABLE member;

