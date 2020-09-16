ALTER TABLE member DROP CONSTRAINT member_pkey;

DROP INDEX member_pkey;

drop sequence member_seq;

DROP TABLE member;

commit;