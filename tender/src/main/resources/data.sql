insert into application_user (id, name, email, username)
values (1, 'Nemanja', 'nemanjaguzina@gmail.com', 'nemanjaguzina');
insert into tender (id, tender_name, description, fk_user_created)
values (1, 'TestTender', 'This is a test decription', 1);
insert into tender (id, tender_name, description, fk_user_created)
values (2, 'TestTender1', 'This is a test decription1', 1);
insert into offer (id, status, amount, currency, fk_tender, fk_user_created)
values (1, 0, 1.4, 'EUR', 2, 1);
insert into offer (id, status, amount, currency, fk_tender, fk_user_created)
values (2, 0, 1.4, 'EUR', 2, 1);
insert into offer (id, status, amount, currency, fk_tender, fk_user_created)
values (3, 0, 1.4, 'EUR', 2, 1);