insert into application_user (id, name, email, username)
values (1, 'Nemanja', 'nemanjaguzina@gmail.com', 'nemanjaguzina');
insert into tender (id, tender_name, fk_user_created)
values (1, 'TestTender', 1);
insert into tender (id, tender_name, fk_user_created)
values (2, 'TestTender1', 1);
insert into offer (id, status, fk_tender, fk_user_created)
values (1, 0, 2, 1);
insert into offer (id, status, fk_tender, fk_user_created)
values (2, 0, 2, 1);
insert into offer (id, status, fk_tender, fk_user_created)
values (3, 0, 2, 1);