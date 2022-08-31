INSERT INTO users (username, password, employee_id, active)
VALUES ('admin'::character varying, '{bcrypt}$2a$10$aKgYJnZjeYtg2EyseiXgPuoujnF.1eg0d8RIufsynUjFucA9RJ1eC'::character varying, null::bigint, true::boolean);

INSERT INTO directorates (directorate_name, directorate_description, active)
VALUES ('Sofia', 'Sofia directorate description', true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Default department'::character varying, 'Special department for Director of Direction'::character varying,1::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (1::bigint, true::boolean, 'DIRECTORS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Yovkov'::character varying, '100000001'::character varying, 55::integer, true::boolean, 1::bigint, 'DIRECTOR_OF_DIRECTORATE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000001'::character varying, '{bcrypt}$2a$10$1h6THMpJDCr9gXyNVPZyVuO0ExpHAhKAO90XDgPepBcuJw.XJf80.'::character varying, 1::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Sales', 'Sales department description', 1::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (2::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Yovkov'::character varying, '100000002'::character varying, 21::integer, true::boolean, 2::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000002'::character varying, '{bcrypt}$2a$10$AbyCaKiZFnQmFzie8P2Nt.TMlteT0Wl0yQm/UeNC47geBw3PksQRy'::character varying, 2::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (2::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Argirov'::character varying, '100000003'::character varying, 46::integer, true::boolean, 3::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000003'::character varying, '{bcrypt}$2a$10$y2LL/tFmlRrMGvYLwnZgqedHvb4XA85dErjyNs0ZR3O5uufFg0VBq'::character varying, 3::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Tanasov'::character varying, '100000004'::character varying, 32::integer, true::boolean, 3::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000004'::character varying, '{bcrypt}$2a$10$tHYdBWlvyPwB1Lfqlp493upi90XF64OJ/p/RPkyG.MGgKLLPCXUOK'::character varying, 4::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Emilov'::character varying, '100000005'::character varying, 30::integer, true::boolean, 3::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000005'::character varying, '{bcrypt}$2a$10$2B9cR4AeMJRDUSMrl/.T1O6kbxIkPoilxGhQ.o4X3aIExi4NA0Re.'::character varying, 5::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Bonchev'::character varying, '100000006'::character varying, 31::integer, true::boolean, 3::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000006'::character varying, '{bcrypt}$2a$10$dfFUYVr7huv/3FFSPGaMyuG/Gv/RW.SYOrjA2JhO3IThoN8/S4qQG'::character varying, 6::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Emilov'::character varying, '100000007'::character varying, 52::integer, true::boolean, 3::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000007'::character varying, '{bcrypt}$2a$10$spmiGOeRUJs1uT6Bo99qeOkumcH/awUkTQmR/JOUfwrqAg6OfIlEq'::character varying, 7::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Goranov'::character varying, '100000008'::character varying, 35::integer, true::boolean, 3::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000008'::character varying, '{bcrypt}$2a$10$dsm7gpjEBXr2Ju6Drt2oNO2N2C467GsL.hAvTc2ELmbfG6dJVEI/e'::character varying, 8::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Argirov'::character varying, '100000009'::character varying, 35::integer, true::boolean, 3::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000009'::character varying, '{bcrypt}$2a$10$m3kkNxGXdQVVgzKfNltMUO8JjrRD0Qp2JWB7jCT33VNZboGiKKBqK'::character varying, 9::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Vasev'::character varying, '100000010'::character varying, 32::integer, true::boolean, 3::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000010'::character varying, '{bcrypt}$2a$10$iTbLTbtoWvO11gqWp9AmzOaEdsG93uhLKxuQlzbdKblTD9.tW4sGm'::character varying, 10::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Bozhilov'::character varying, '100000011'::character varying, 58::integer, true::boolean, 3::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000011'::character varying, '{bcrypt}$2a$10$qOP18uEPIZavzdSOczjd..XOLYC4ZZfNoRKFhzafIPMdVTa817Lua'::character varying, 11::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Goranov'::character varying, '100000012'::character varying, 20::integer, true::boolean, 3::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000012'::character varying, '{bcrypt}$2a$10$PjoFh25ZmZ0D9fF0LRageeKX8OA5y8Ay0DjMKzEsfHYmvvGfH820O'::character varying, 12::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('IT', 'IT department description', 1::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (3::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Vasev'::character varying, '100000013'::character varying, 59::integer, true::boolean, 4::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000013'::character varying, '{bcrypt}$2a$10$q9AuZTVpiFJO2HfD2N2H7u8HHlM4qNugPUJ4uFL1d9.Uzt9pG05RK'::character varying, 13::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (3::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Bozhilov'::character varying, '100000014'::character varying, 53::integer, true::boolean, 5::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000014'::character varying, '{bcrypt}$2a$10$HSMILnXOVgcfU1KDq/STkOFVTk0o5GVbbQceUsgjFOzKTSWgJphK6'::character varying, 14::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Goranov'::character varying, '100000015'::character varying, 40::integer, true::boolean, 5::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000015'::character varying, '{bcrypt}$2a$10$uQHzSLMuEG00GxZKPpEZYuFCTjHSXh4qXLOQ.A8DJhImgPZ.aHztW'::character varying, 15::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Argirov'::character varying, '100000016'::character varying, 51::integer, true::boolean, 5::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000016'::character varying, '{bcrypt}$2a$10$/N9IRw8aWOqKaP/31EaNQuie4CRgF9SYRjhheeq18Ee1UDBLKJPKO'::character varying, 16::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Yovkov'::character varying, '100000017'::character varying, 54::integer, true::boolean, 5::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000017'::character varying, '{bcrypt}$2a$10$bTMyxeqXbybR/tk1SGQ49eRgHusWJyIGKS6OuWvS6rZ22XUGgfU4S'::character varying, 17::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Yovkov'::character varying, '100000018'::character varying, 25::integer, true::boolean, 5::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000018'::character varying, '{bcrypt}$2a$10$Deo7nHHksP5NqBmFPaTOk.YD9moJaZ8eTqiknukCuPjSiFQf0HE3y'::character varying, 18::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Vasev'::character varying, '100000019'::character varying, 55::integer, true::boolean, 5::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000019'::character varying, '{bcrypt}$2a$10$/5TzRRDm2YMQsSHR4Fw9Le42lkzf5zEucogBLKl9TsX5ATTPtlGPO'::character varying, 19::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Bonchev'::character varying, '100000020'::character varying, 44::integer, true::boolean, 5::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000020'::character varying, '{bcrypt}$2a$10$fHOkxwCdhdm7.LBtCOfpHeER4WV9DAZW4DqwulO03eGRV0L55wDou'::character varying, 20::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Vasev'::character varying, '100000021'::character varying, 37::integer, true::boolean, 5::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000021'::character varying, '{bcrypt}$2a$10$535KScdUVyo7EBrl3.NXTeASz1/rymfwgr.PeUlQGOLdt8RfF8MTS'::character varying, 21::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Bonchev'::character varying, '100000022'::character varying, 41::integer, true::boolean, 5::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000022'::character varying, '{bcrypt}$2a$10$O4BvxLHuWF14GOcR4L1tleqTgvTAeMC0NTBt8nFwM0onQAqN7hnUm'::character varying, 22::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Tanasov'::character varying, '100000023'::character varying, 49::integer, true::boolean, 5::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000023'::character varying, '{bcrypt}$2a$10$R1B60YO1AFT5LZQOldyF/uW0zEgic1T/12yVNRh4TNRVDzQ0OhCBy'::character varying, 23::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Finance', 'Finance department description', 1::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (4::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Goranov'::character varying, '100000024'::character varying, 41::integer, true::boolean, 6::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000024'::character varying, '{bcrypt}$2a$10$uewpYBI.8uejNJb8hlEpx.6Z1TXT5Y5iHlGPeoyQJV9ch8JYcgt6.'::character varying, 24::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (4::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Tanasov'::character varying, '100000025'::character varying, 54::integer, true::boolean, 7::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000025'::character varying, '{bcrypt}$2a$10$s1hNNjazdRU2TXVGtBsPBetFnxFqIiUudp3Jqe.BojpilwoUkK2w2'::character varying, 25::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Argirov'::character varying, '100000026'::character varying, 40::integer, true::boolean, 7::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000026'::character varying, '{bcrypt}$2a$10$9mAPceMNrnMIZahkjHQJWOqryupeNJWKB1CHwJLRdZIQ5t0JWL10O'::character varying, 26::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Tanasov'::character varying, '100000027'::character varying, 36::integer, true::boolean, 7::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000027'::character varying, '{bcrypt}$2a$10$mFmhssJjsGvGhYCa4xbSv.df46ibxy9h9d/89DLEXbogPhXgOSIpe'::character varying, 27::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Goranov'::character varying, '100000028'::character varying, 40::integer, true::boolean, 7::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000028'::character varying, '{bcrypt}$2a$10$brk8ND3AskBv418gecv8L.2M7ZpxeS5A.uGLvmJx1nyrIYPPVwsvC'::character varying, 28::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Goranov'::character varying, '100000029'::character varying, 34::integer, true::boolean, 7::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000029'::character varying, '{bcrypt}$2a$10$6DduahtRgvDp3rKXcNSKjuFPkpOml.kk7nDRFVrKAPWfu3tvsYKkG'::character varying, 29::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Vasev'::character varying, '100000030'::character varying, 59::integer, true::boolean, 7::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000030'::character varying, '{bcrypt}$2a$10$4i.8wtBdj1KDNDuodaOxs.alEwMlGeXtSur0caKohQJX6Exriz7cO'::character varying, 30::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Emilov'::character varying, '100000031'::character varying, 55::integer, true::boolean, 7::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000031'::character varying, '{bcrypt}$2a$10$hPQhMHVnPkLvq5IEvH0IzepijWmHHv8GQ4nhO0A/sNImEwkSSPiMK'::character varying, 31::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Vasev'::character varying, '100000032'::character varying, 49::integer, true::boolean, 7::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000032'::character varying, '{bcrypt}$2a$10$7lIjpk1IEH069FoNSDtSaejwVTrrF5v5rj2SGRSnnRvSCkN1B3mXW'::character varying, 32::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Goranov'::character varying, '100000033'::character varying, 46::integer, true::boolean, 7::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000033'::character varying, '{bcrypt}$2a$10$qPZUqgD.lEqIW2hWauHHAeEzEN0Qmn4hTIL9nh39bCdFQf6otLnpS'::character varying, 33::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Bonchev'::character varying, '100000034'::character varying, 34::integer, true::boolean, 7::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000034'::character varying, '{bcrypt}$2a$10$VHoofxL2GsHl1K8UQWAOf.Vfw5Ffq0VKU7iyRe9/KkdwJbSEcnKGq'::character varying, 34::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Legal', 'Legal department description', 1::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (5::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Emilov'::character varying, '100000035'::character varying, 38::integer, true::boolean, 8::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000035'::character varying, '{bcrypt}$2a$10$xLK.LY3mX1/Kh3Djg2DdwewUdPmUt83NabJf74tHnaX3EYYEQGRPq'::character varying, 35::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (5::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Tanasov'::character varying, '100000036'::character varying, 23::integer, true::boolean, 9::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000036'::character varying, '{bcrypt}$2a$10$.QWKJolUNdqgpjiKzNl2beEo08oou6LaEcQhBejNZ6z/EM2Z6zQ0C'::character varying, 36::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Goranov'::character varying, '100000037'::character varying, 30::integer, true::boolean, 9::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000037'::character varying, '{bcrypt}$2a$10$EoUBZUfaMYt.lyII91i4xeYr4p3rI1g7V2i7DCCQNYVd4qPGwIDsi'::character varying, 37::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Emilov'::character varying, '100000038'::character varying, 45::integer, true::boolean, 9::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000038'::character varying, '{bcrypt}$2a$10$AP2teqHUKWtSS4.OM//ISum76OhnuTbQCSIgJIaQs2wW.Dr5BkMim'::character varying, 38::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Bozhilov'::character varying, '100000039'::character varying, 41::integer, true::boolean, 9::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000039'::character varying, '{bcrypt}$2a$10$cC9sJWNLRtW/Uja0D59yX.kvFgDtWNEjeTC4kHm6qUh1DadjZ4zVi'::character varying, 39::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Bonchev'::character varying, '100000040'::character varying, 33::integer, true::boolean, 9::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000040'::character varying, '{bcrypt}$2a$10$w1h6c.LYW/hOdIdYLir9.eHfK7M3rr3cKj7.L67ZLcKiUD4ZuZpm6'::character varying, 40::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Yovkov'::character varying, '100000041'::character varying, 31::integer, true::boolean, 9::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000041'::character varying, '{bcrypt}$2a$10$OCWraIGn.IZBBldFgRJ/PuECcfwAOK9qxPLLBWOHgBCXRT9NlIpw2'::character varying, 41::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Tanasov'::character varying, '100000042'::character varying, 39::integer, true::boolean, 9::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000042'::character varying, '{bcrypt}$2a$10$pD/QohY8DGljwREh0tZb5.tYzd.2pR8/H1VZ6iym4haWWI2POsFmK'::character varying, 42::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Bonchev'::character varying, '100000043'::character varying, 50::integer, true::boolean, 9::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000043'::character varying, '{bcrypt}$2a$10$lzceFXPpGBdscalNCO/O1OAIXwAZMrtUous0se2ZqamXCp7spxdTW'::character varying, 43::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Tanasov'::character varying, '100000044'::character varying, 30::integer, true::boolean, 9::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000044'::character varying, '{bcrypt}$2a$10$YUXzcFKMxGQhYfLGyb3ADu3UxNeMkG7h8ry6aILTgykH3LhhiYofS'::character varying, 44::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Bonchev'::character varying, '100000045'::character varying, 51::integer, true::boolean, 9::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000045'::character varying, '{bcrypt}$2a$10$w4CVpLgfpX.D1A88eDPofeq4Ue.jdBwAtCy9S.tugzCErXwTakTi6'::character varying, 45::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Provision', 'Provision department description', 1::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (6::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Goranov'::character varying, '100000046'::character varying, 41::integer, true::boolean, 10::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000046'::character varying, '{bcrypt}$2a$10$HtlgYreAe3xh/UIwtfXuRuu6XSjBSiX6aLDc3oHGvHKB9flVPpFK2'::character varying, 46::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (6::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Goranov'::character varying, '100000047'::character varying, 59::integer, true::boolean, 11::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000047'::character varying, '{bcrypt}$2a$10$fV7etVS8Ehap/9F.SfhfFOFte57qFekTuiRrNikC4t7yJK8iqSwPi'::character varying, 47::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Goranov'::character varying, '100000048'::character varying, 58::integer, true::boolean, 11::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000048'::character varying, '{bcrypt}$2a$10$aDmSGJGRFvM04WRQkUhfreWBvq3h7IVQLoicaDW/9hIxYsxcABlCa'::character varying, 48::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Yovkov'::character varying, '100000049'::character varying, 31::integer, true::boolean, 11::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000049'::character varying, '{bcrypt}$2a$10$6hbcPKQHRO9k7JgVaROZb.Fbz/mLDSqrV5JSdJ41lXCVL0nC.l2Yi'::character varying, 49::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Goranov'::character varying, '100000050'::character varying, 29::integer, true::boolean, 11::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000050'::character varying, '{bcrypt}$2a$10$yDfZJxxw5rrWG6HxRq1OouN9dEDtpWVJxYHG7XVytNs9aQIOd2VY2'::character varying, 50::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Vasev'::character varying, '100000051'::character varying, 46::integer, true::boolean, 11::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000051'::character varying, '{bcrypt}$2a$10$vO3GcyM.7rraFBFJSaL9BuLSLTtahVV3M2ScsBYt.AmVrO0Cli3Oq'::character varying, 51::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Tanasov'::character varying, '100000052'::character varying, 40::integer, true::boolean, 11::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000052'::character varying, '{bcrypt}$2a$10$CJ/fI8LsZAAjtO3d.6FBhuWPHmBMxsATypbtURV4Ra4tBC.kerg36'::character varying, 52::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Vasev'::character varying, '100000053'::character varying, 47::integer, true::boolean, 11::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000053'::character varying, '{bcrypt}$2a$10$7hV1YjRC2mPOq4h1CvjxFOIW0j.9Bn7iddTxdofHU8BHYLMFiQRvS'::character varying, 53::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Bonchev'::character varying, '100000054'::character varying, 30::integer, true::boolean, 11::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000054'::character varying, '{bcrypt}$2a$10$c7rm1B9Zjjbjwb/nJ.pjkeyCkorh8qCg8hpSEiaR.OCvX.HEQmAna'::character varying, 54::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Yovkov'::character varying, '100000055'::character varying, 38::integer, true::boolean, 11::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000055'::character varying, '{bcrypt}$2a$10$uF5eQdUPZ/SI7993iJSSeugP82flzDAM8DFGS4r2qjqavCaONvG/q'::character varying, 55::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Tanasov'::character varying, '100000056'::character varying, 53::integer, true::boolean, 11::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000056'::character varying, '{bcrypt}$2a$10$w.lk8CQFIH/AePLuYpMbTePqYt6J1gA8aPmiSbGklODQjUFTy14M2'::character varying, 56::bigint, true::boolean);
INSERT INTO directorates (directorate_name, directorate_description, active)
VALUES ('Varna', 'Varna directorate description', true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Default department'::character varying, 'Special department for Director of Direction'::character varying,2::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (7::bigint, true::boolean, 'DIRECTORS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Bonchev'::character varying, '100000057'::character varying, 59::integer, true::boolean, 12::bigint, 'DIRECTOR_OF_DIRECTORATE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000057'::character varying, '{bcrypt}$2a$10$Er3k3bHJIKoYcs.nNBmmqejD7Hy6SUxEoc63jF6.XOAe8PO2A7R9i'::character varying, 57::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Sales', 'Sales department description', 2::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (8::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Emilov'::character varying, '100000058'::character varying, 25::integer, true::boolean, 13::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000058'::character varying, '{bcrypt}$2a$10$tvvDWssCjK3NwXkmLdQoD..8rHc93k70OwydUKxqsakf7WOUYYNEC'::character varying, 58::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (8::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Argirov'::character varying, '100000059'::character varying, 44::integer, true::boolean, 14::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000059'::character varying, '{bcrypt}$2a$10$mW9yLH4/ELbBNbcC.pOPnuxrI.o138xs32Lu.DeQjAvwflAJkqbrG'::character varying, 59::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Bozhilov'::character varying, '100000060'::character varying, 38::integer, true::boolean, 14::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000060'::character varying, '{bcrypt}$2a$10$e11kXo5D96KYEMzI2NpEzOr4GI.PVYJNkOQBXXI8l0qxlaTsXOPS2'::character varying, 60::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Tanasov'::character varying, '100000061'::character varying, 27::integer, true::boolean, 14::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000061'::character varying, '{bcrypt}$2a$10$R51YtkyHLrgl7eNOgkAl3.LULJd2t3La7.oNovRp9aPWO1ybX5s5q'::character varying, 61::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Bonchev'::character varying, '100000062'::character varying, 58::integer, true::boolean, 14::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000062'::character varying, '{bcrypt}$2a$10$THeZOrrDRCHecJVVpFznqOdwEroTqgTsxSqJUxekaIWbhK.9FlVm.'::character varying, 62::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Bozhilov'::character varying, '100000063'::character varying, 21::integer, true::boolean, 14::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000063'::character varying, '{bcrypt}$2a$10$x0CLzgfU24uOKgahmBMgCuBvTQxLVD0Wz4pdm.A2d8.MLv2jt06fe'::character varying, 63::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Bozhilov'::character varying, '100000064'::character varying, 46::integer, true::boolean, 14::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000064'::character varying, '{bcrypt}$2a$10$ZmOW42Vsgk9iOKSF40K6w.vxytXF.17ier.yw.nbCKrCi38PowXuG'::character varying, 64::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Emilov'::character varying, '100000065'::character varying, 45::integer, true::boolean, 14::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000065'::character varying, '{bcrypt}$2a$10$pdvweYrpWEbg47dskG7m7.1VL.crqr/tpdiJtyO.mJnCSqpR2pxa.'::character varying, 65::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Emilov'::character varying, '100000066'::character varying, 21::integer, true::boolean, 14::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000066'::character varying, '{bcrypt}$2a$10$vzkL8hVElJJOxNbitt19je4NsgWp7kDJaL6PSTec3v1WmYtq0vT8q'::character varying, 66::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Tanasov'::character varying, '100000067'::character varying, 55::integer, true::boolean, 14::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000067'::character varying, '{bcrypt}$2a$10$npt2KpRRhESndOw7cYHreugmvU5q5jlkXbCNqMFr6oTfzu0UGL2NO'::character varying, 67::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Bonchev'::character varying, '100000068'::character varying, 39::integer, true::boolean, 14::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000068'::character varying, '{bcrypt}$2a$10$9hXzeWyHLed6Slj3oGI5zOwqX7l0wGCfpCE.f0kSK.VL39yXptYUm'::character varying, 68::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('IT', 'IT department description', 2::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (9::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Yovkov'::character varying, '100000069'::character varying, 47::integer, true::boolean, 15::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000069'::character varying, '{bcrypt}$2a$10$W0clMSXdEtHrV/29kjq6bOd3qiQ//jLYvCFS0gborDY4XjeaD1Pma'::character varying, 69::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (9::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Bonchev'::character varying, '100000070'::character varying, 55::integer, true::boolean, 16::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000070'::character varying, '{bcrypt}$2a$10$wC.9Q25JM3nCrytQHXB.AeQHopyZFyRxqNJ5uZBLP7wVy3YuSUEq6'::character varying, 70::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Yovkov'::character varying, '100000071'::character varying, 43::integer, true::boolean, 16::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000071'::character varying, '{bcrypt}$2a$10$bH5PaC2jxRrMgW1AXzEm0uhTDS3tmLyFBL60a0nlcgedzRMuJtye.'::character varying, 71::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Emilov'::character varying, '100000072'::character varying, 52::integer, true::boolean, 16::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000072'::character varying, '{bcrypt}$2a$10$Rzs0Bv0m34/2DflsFNnHBOMzbFa8DcxLLBSAZmEMpMLvyEgVQ3KZi'::character varying, 72::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Vasev'::character varying, '100000073'::character varying, 55::integer, true::boolean, 16::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000073'::character varying, '{bcrypt}$2a$10$APGK80RO7Q5cNBvcNu/18eduDGSv97M3s23iIogsoCDSLHrOvpMb6'::character varying, 73::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Bozhilov'::character varying, '100000074'::character varying, 34::integer, true::boolean, 16::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000074'::character varying, '{bcrypt}$2a$10$P.MRH4rvNU1IXR3l0V7OyOvhAJKLlhwFaJku7m.k9sM1Kk/pihcbe'::character varying, 74::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Argirov'::character varying, '100000075'::character varying, 36::integer, true::boolean, 16::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000075'::character varying, '{bcrypt}$2a$10$uyeg.16S50pPSW74rr5pA.66E4GxFLNiQMrfiDVBu.qi/OH9C5vZS'::character varying, 75::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Tanasov'::character varying, '100000076'::character varying, 31::integer, true::boolean, 16::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000076'::character varying, '{bcrypt}$2a$10$TwJ5EwQXf2KhAcWbYsuR/uP9Wjms5cuPcnwYVSfhPkvJV0WmenRrK'::character varying, 76::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Vasev'::character varying, '100000077'::character varying, 47::integer, true::boolean, 16::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000077'::character varying, '{bcrypt}$2a$10$ZnbDYrJR9oVmjJd9ecIy7uhUpm1zgoqw94ni1kPraPS2fTSE3K4N2'::character varying, 77::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Yovkov'::character varying, '100000078'::character varying, 57::integer, true::boolean, 16::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000078'::character varying, '{bcrypt}$2a$10$WvG7vh05PW4cyrILrNBzJuIiflsyX4W0BACm74q86muOmd33LrJpO'::character varying, 78::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Argirov'::character varying, '100000079'::character varying, 46::integer, true::boolean, 16::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000079'::character varying, '{bcrypt}$2a$10$5g6kqa4BPrfW0YkXWBLL4Oo9O/Jc4Yin4HmWEwj9UJYlvQJIO0fMi'::character varying, 79::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Finance', 'Finance department description', 2::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (10::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Goranov'::character varying, '100000080'::character varying, 53::integer, true::boolean, 17::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000080'::character varying, '{bcrypt}$2a$10$ql9N7XiDtsVrAlYqXEz3nOfujvASWGI0hXOb1q0ZwWuWZYlQCo23m'::character varying, 80::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (10::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Yovkov'::character varying, '100000081'::character varying, 30::integer, true::boolean, 18::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000081'::character varying, '{bcrypt}$2a$10$BaA1ZICHLxkS379R8FE.wuMTlDiwptWbTf6udNcO2Mt4OSV4IKxBi'::character varying, 81::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Argirov'::character varying, '100000082'::character varying, 22::integer, true::boolean, 18::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000082'::character varying, '{bcrypt}$2a$10$rz3UZoQiriOtOQoZ79Aq.eUgkliU4lCElyWLtjOGoIWh96jD1jLJq'::character varying, 82::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Yovkov'::character varying, '100000083'::character varying, 50::integer, true::boolean, 18::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000083'::character varying, '{bcrypt}$2a$10$EW/BFn31/jwhcjhjqzbiZe1M5rpTmp6ZPT/m6qAmHkcsLcOVruZP6'::character varying, 83::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Emilov'::character varying, '100000084'::character varying, 51::integer, true::boolean, 18::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000084'::character varying, '{bcrypt}$2a$10$f98ha4pFb/5UNPTdYic9DO4x9C8sx5HkeP/U5PgJfHLDrYgC1e4Qa'::character varying, 84::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Goranov'::character varying, '100000085'::character varying, 41::integer, true::boolean, 18::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000085'::character varying, '{bcrypt}$2a$10$fNV/ll.uPo5SHkDei0rZMe22BIjl1N3LefqdhDEUIpegdoDiH00Oi'::character varying, 85::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Goranov'::character varying, '100000086'::character varying, 37::integer, true::boolean, 18::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000086'::character varying, '{bcrypt}$2a$10$nISngt53EFoWbS.JFvddjOlu.V7EUutsnQZjjbL0kSp9Jx1yaH8F2'::character varying, 86::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Goranov'::character varying, '100000087'::character varying, 31::integer, true::boolean, 18::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000087'::character varying, '{bcrypt}$2a$10$lA.8Xh1tdpsGgr7foV8kluppHG9HR6zYaDbSxKF5BXJpoUWRYUH0q'::character varying, 87::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Yovkov'::character varying, '100000088'::character varying, 20::integer, true::boolean, 18::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000088'::character varying, '{bcrypt}$2a$10$uZPCLr1yERyP4JgftwUf3.98ErZubOoGNA9KqmUwO3FQesruS3XTq'::character varying, 88::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Bozhilov'::character varying, '100000089'::character varying, 49::integer, true::boolean, 18::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000089'::character varying, '{bcrypt}$2a$10$v2aonAd9lHCJou7Y1695/eVmiO3v1dKBRS9uBMPAX5qIStXKZZdHe'::character varying, 89::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Bonchev'::character varying, '100000090'::character varying, 44::integer, true::boolean, 18::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000090'::character varying, '{bcrypt}$2a$10$AJWTEYVg13N3GUkH8djmjOg0YobZHlAP7KJdMe/J.Y2zOW5iezPh6'::character varying, 90::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Legal', 'Legal department description', 2::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (11::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Tanasov'::character varying, '100000091'::character varying, 52::integer, true::boolean, 19::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000091'::character varying, '{bcrypt}$2a$10$xLl0NcZXHnpD.IrWgbtFSuFP5Pk/Lxq3w3S5EXvfTesib7EsUQ2Ya'::character varying, 91::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (11::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Argirov'::character varying, '100000092'::character varying, 57::integer, true::boolean, 20::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000092'::character varying, '{bcrypt}$2a$10$D7v1UNopvNxXUtkUm9CdFu6YU3e/rqUHz.IlpOEWBgs3VoIt7m1ES'::character varying, 92::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Emilov'::character varying, '100000093'::character varying, 21::integer, true::boolean, 20::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000093'::character varying, '{bcrypt}$2a$10$QEqFAZ34yxi7bQIxRQ1jgOXLKFbVSTYjLHlCFmYq4BGZKkvE/25TC'::character varying, 93::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Tanasov'::character varying, '100000094'::character varying, 27::integer, true::boolean, 20::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000094'::character varying, '{bcrypt}$2a$10$wbJXaOZxZfRTd5rx/mMiguVoHhkK0XjMpqPqd5Cmn9b61Wmi7hklm'::character varying, 94::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Tanasov'::character varying, '100000095'::character varying, 24::integer, true::boolean, 20::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000095'::character varying, '{bcrypt}$2a$10$Rn.tUgdMe2qSTLaCsxvEfeFXOaUOW7Txj3y1wkJKYFLdhyqssJw7a'::character varying, 95::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Argirov'::character varying, '100000096'::character varying, 45::integer, true::boolean, 20::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000096'::character varying, '{bcrypt}$2a$10$s3tgixpBqOFUdXV.ondwaOI4VCqxJUmDF53hee8PK5T/DYL1Bjyqi'::character varying, 96::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Argirov'::character varying, '100000097'::character varying, 32::integer, true::boolean, 20::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000097'::character varying, '{bcrypt}$2a$10$BPEgZ3vWQXeKniKQGZFmqeni27CqLra8diHNl6r96r5xcnH7HL8UC'::character varying, 97::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Emilov'::character varying, '100000098'::character varying, 42::integer, true::boolean, 20::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000098'::character varying, '{bcrypt}$2a$10$zGuiSGtWV3KFZTq0XMH2XOcKTGHBJW2yP5QA3TYs1ndc1VSCNMPPO'::character varying, 98::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Argirov'::character varying, '100000099'::character varying, 27::integer, true::boolean, 20::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000099'::character varying, '{bcrypt}$2a$10$DnPXrNzWm5A/K.S69dZJ0eZGeztkyizrsqzxJp6d4dpXUvREOG5Ai'::character varying, 99::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Goranov'::character varying, '100000100'::character varying, 59::integer, true::boolean, 20::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000100'::character varying, '{bcrypt}$2a$10$XDW5.HSHpKyGaTkRkUxWkOJJOFnax5ofjguOVAcoSal2Y.tt8iiB.'::character varying, 100::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Bonchev'::character varying, '100000101'::character varying, 29::integer, true::boolean, 20::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000101'::character varying, '{bcrypt}$2a$10$Epy19OBwf04K5Jf4v2fMqOBxFC4Q/wGuOmQJdKYAJj1J7cneTpO9a'::character varying, 101::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Provision', 'Provision department description', 2::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (12::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Goranov'::character varying, '100000102'::character varying, 51::integer, true::boolean, 21::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000102'::character varying, '{bcrypt}$2a$10$8ChS686ze/xWWWP7cFgq1uT.aFBBf6jleVV6AJZF9DoEHa/b2LNYm'::character varying, 102::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (12::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Yovkov'::character varying, '100000103'::character varying, 30::integer, true::boolean, 22::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000103'::character varying, '{bcrypt}$2a$10$rIGDVKH3/iF8frlltq2gIusULrqNB/PNpk/Etc6oEgSMLoYDrZNPu'::character varying, 103::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Bonchev'::character varying, '100000104'::character varying, 22::integer, true::boolean, 22::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000104'::character varying, '{bcrypt}$2a$10$YPGoq.SW1U2nT4vrZq0XTOsSNzGZ2Y5.Y0k2BO6Vl4oHtU0lcl6Uu'::character varying, 104::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Bonchev'::character varying, '100000105'::character varying, 22::integer, true::boolean, 22::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000105'::character varying, '{bcrypt}$2a$10$e4VlbzJqKe.lpKZjvOaWyOHB1U5NWvtDillDVRoYCNpFNrCL0QKi6'::character varying, 105::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Bonchev'::character varying, '100000106'::character varying, 45::integer, true::boolean, 22::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000106'::character varying, '{bcrypt}$2a$10$0p6icpM87mANYB6feXJrru7/Pb1q5rPSnZYQwG0OAYoVop/vXEq/i'::character varying, 106::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Tanasov'::character varying, '100000107'::character varying, 53::integer, true::boolean, 22::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000107'::character varying, '{bcrypt}$2a$10$WvJ.M6zHW2OcGWMgdKHhE.QZslRHOEvB2P/uu1IDwT7kUzM9NIUCe'::character varying, 107::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Bonchev'::character varying, '100000108'::character varying, 36::integer, true::boolean, 22::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000108'::character varying, '{bcrypt}$2a$10$yGSPBqhvQRmOOigBY3xlU.HHZj63qpKyzuFDqscs2ZHnyPnt3WgAi'::character varying, 108::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Bozhilov'::character varying, '100000109'::character varying, 43::integer, true::boolean, 22::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000109'::character varying, '{bcrypt}$2a$10$jlxs2bzLSMXMJNLKmziZOuP53.SCCZTFQUcPHeJCDRo3PxNvGHL/S'::character varying, 109::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Argirov'::character varying, '100000110'::character varying, 42::integer, true::boolean, 22::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000110'::character varying, '{bcrypt}$2a$10$vEbLmwGCv3Rs6Teauu/QgeBapE15bUY87iHip138IWf0dOnkM5ylq'::character varying, 110::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Yovkov'::character varying, '100000111'::character varying, 29::integer, true::boolean, 22::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000111'::character varying, '{bcrypt}$2a$10$U2C1TiwpV/AHUZgAt4VcZ.W470IlVXjRfdVsniRxMTx8b3z5uo06G'::character varying, 111::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Bozhilov'::character varying, '100000112'::character varying, 22::integer, true::boolean, 22::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000112'::character varying, '{bcrypt}$2a$10$rbtgzrvLin/YMEXbUp63JuX2nCkSGUKtqUJRoAxxvFBTjCL9Xk.T6'::character varying, 112::bigint, true::boolean);
INSERT INTO directorates (directorate_name, directorate_description, active)
VALUES ('Plovdiv', 'Plovdiv directorate description', true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Default department'::character varying, 'Special department for Director of Direction'::character varying,3::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (13::bigint, true::boolean, 'DIRECTORS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Bonchev'::character varying, '100000113'::character varying, 39::integer, true::boolean, 23::bigint, 'DIRECTOR_OF_DIRECTORATE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000113'::character varying, '{bcrypt}$2a$10$Wf5NXd1/MvBdqABiBgS0j.iQEvquchMKDs7tXjhDQaZX759P/9nMC'::character varying, 113::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Sales', 'Sales department description', 3::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (14::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Yovkov'::character varying, '100000114'::character varying, 46::integer, true::boolean, 24::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000114'::character varying, '{bcrypt}$2a$10$QIPN.lPlNS7f6Bs80r7oMu6HK998qkFBPRfmpAht4mhcvoPommaVe'::character varying, 114::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (14::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Bozhilov'::character varying, '100000115'::character varying, 49::integer, true::boolean, 25::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000115'::character varying, '{bcrypt}$2a$10$dxSSLWJITTo2DUl3nOK5jeg2Jbz9pUvdbETacgdSgO1VyRu52XA0y'::character varying, 115::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Goranov'::character varying, '100000116'::character varying, 24::integer, true::boolean, 25::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000116'::character varying, '{bcrypt}$2a$10$BUfmOsAI35R5SNVE0sdT5egWQzW76PCc9Vioao9B66WRJ.KVPuhL.'::character varying, 116::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Emilov'::character varying, '100000117'::character varying, 31::integer, true::boolean, 25::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000117'::character varying, '{bcrypt}$2a$10$Stzq7fBT4xps0i0Q7qASDuedWO408zLvD8/onNkkKQH9N1aLGgGMy'::character varying, 117::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Vasev'::character varying, '100000118'::character varying, 52::integer, true::boolean, 25::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000118'::character varying, '{bcrypt}$2a$10$JpENlT9RND2YAY7qqCsACOb1eGf7RrZAXP2BMPROzrTLkRpA5O8Pi'::character varying, 118::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Goranov'::character varying, '100000119'::character varying, 39::integer, true::boolean, 25::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000119'::character varying, '{bcrypt}$2a$10$CI2fkldnMyjKENwd.YhnlO1xzELTIpQauaZAreCFr50tUpaK4/c/G'::character varying, 119::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Vasev'::character varying, '100000120'::character varying, 48::integer, true::boolean, 25::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000120'::character varying, '{bcrypt}$2a$10$bi23hWyadnptmkBYERBDPewQHjx9U29ALsBLttD1OuvezSWIBcq6K'::character varying, 120::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Emilov'::character varying, '100000121'::character varying, 51::integer, true::boolean, 25::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000121'::character varying, '{bcrypt}$2a$10$ri7A.g9lYKhW/ozg4fEsbOb131rfqD/cwJy7N.ETEsyF/Gecd6.lO'::character varying, 121::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Emilov'::character varying, '100000122'::character varying, 39::integer, true::boolean, 25::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000122'::character varying, '{bcrypt}$2a$10$ejm2u7by5F3Kdc76bwPzTeAF54gNCibzNGVCuITTiaKaJR0edVRcO'::character varying, 122::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Yovkov'::character varying, '100000123'::character varying, 57::integer, true::boolean, 25::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000123'::character varying, '{bcrypt}$2a$10$X3Bk25tSHHV/v93mzokzu.6eaiJTkDyr3JzggnKeE0Su5uImExFuq'::character varying, 123::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Tanasov'::character varying, '100000124'::character varying, 30::integer, true::boolean, 25::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000124'::character varying, '{bcrypt}$2a$10$6oqkcVoJQx.4kbzhEvz0uOE3NuGpsa0m.9YEeHhrTG5ScFGJEvOzm'::character varying, 124::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('IT', 'IT department description', 3::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (15::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Emilov'::character varying, '100000125'::character varying, 39::integer, true::boolean, 26::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000125'::character varying, '{bcrypt}$2a$10$vZgIOrs8fzSKIZzD1XcZZ.Se8o3/bwP3Chl5LVT7/8PSoewKPOcV2'::character varying, 125::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (15::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Yovkov'::character varying, '100000126'::character varying, 26::integer, true::boolean, 27::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000126'::character varying, '{bcrypt}$2a$10$7pLllkbGZX29lZ.rs.PK8O53a10ODcC6fOZaoIvJ2WgPJS/D1/jdi'::character varying, 126::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Bozhilov'::character varying, '100000127'::character varying, 46::integer, true::boolean, 27::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000127'::character varying, '{bcrypt}$2a$10$qQ3v7oFSBDdedUpMICy2T.R933yfnsXM4KVLVYJbpN/e1Nnofme8a'::character varying, 127::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Bozhilov'::character varying, '100000128'::character varying, 32::integer, true::boolean, 27::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000128'::character varying, '{bcrypt}$2a$10$6X4DL5.n9yXWCa8yu7VHDuooWdHp08kyfZR2kLE4cesCN9fiQV5Cm'::character varying, 128::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Argirov'::character varying, '100000129'::character varying, 42::integer, true::boolean, 27::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000129'::character varying, '{bcrypt}$2a$10$DmX9BIiG74STqhdQtrBOheLq/Ej5nwWd6fCCvdzgwDua.gh0S4EaC'::character varying, 129::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Goranov'::character varying, '100000130'::character varying, 21::integer, true::boolean, 27::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000130'::character varying, '{bcrypt}$2a$10$v4lMhnmnoQeQo95299/ZT.x.XaVoQ5yU9x3xLrLFiPE69mvLjMdLm'::character varying, 130::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Yovkov'::character varying, '100000131'::character varying, 47::integer, true::boolean, 27::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000131'::character varying, '{bcrypt}$2a$10$OZjye4A7TCexTgaQHut5o.chXWejyr1U7WjSLgkHbDVNlqfH9IS16'::character varying, 131::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Tanasov'::character varying, '100000132'::character varying, 32::integer, true::boolean, 27::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000132'::character varying, '{bcrypt}$2a$10$0/kvKovuyyNgVAMX6VrG8usl9nw4ym/Tw7j5b4KZo0s8nbSxjIPFG'::character varying, 132::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Bonchev'::character varying, '100000133'::character varying, 29::integer, true::boolean, 27::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000133'::character varying, '{bcrypt}$2a$10$4TxZc1.5fsfhmX4IMoUvfeZq4ZHrzEonO6iJ1vE2/o01DGY6yx9O.'::character varying, 133::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Tanasov'::character varying, '100000134'::character varying, 52::integer, true::boolean, 27::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000134'::character varying, '{bcrypt}$2a$10$1n33llug8L.wkkTDzVHVZObmgZeIy0fnloaaZ.N6V/K0n7MT5qSeO'::character varying, 134::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Bonchev'::character varying, '100000135'::character varying, 46::integer, true::boolean, 27::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000135'::character varying, '{bcrypt}$2a$10$rcz2BcszdO2z.NQsNorN5OMAGgE3dKqo6UieQu3RXT3bQneT3gCuq'::character varying, 135::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Finance', 'Finance department description', 3::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (16::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Bonchev'::character varying, '100000136'::character varying, 43::integer, true::boolean, 28::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000136'::character varying, '{bcrypt}$2a$10$yab3VZIlUxyHg5.VRQTJC.OsPfhyLHnRoJYDyHAtNwboZZavOEH/a'::character varying, 136::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (16::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Yovkov'::character varying, '100000137'::character varying, 39::integer, true::boolean, 29::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000137'::character varying, '{bcrypt}$2a$10$35uVFuiHvLlsEa4LewoxJ.Hc19sCGB.Y.n1YFcw9/ksaGEknt8ckW'::character varying, 137::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Bonchev'::character varying, '100000138'::character varying, 29::integer, true::boolean, 29::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000138'::character varying, '{bcrypt}$2a$10$bVsCWHoDOqGjcUAUJGckC.jihBxUUp8EljCK4XgaEvZAatJO34OvS'::character varying, 138::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Goranov'::character varying, '100000139'::character varying, 25::integer, true::boolean, 29::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000139'::character varying, '{bcrypt}$2a$10$oDA7O0VyQxs9YMjwwFOrqOCop1siRnKZKbE2/HXKF8I5Fq6NGxsna'::character varying, 139::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Yovkov'::character varying, '100000140'::character varying, 56::integer, true::boolean, 29::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000140'::character varying, '{bcrypt}$2a$10$4m7RPSvKr6wMjqArs.NTe.R69F.K/7DsicJHBzCLuRxXk2nQu49/u'::character varying, 140::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Bonchev'::character varying, '100000141'::character varying, 53::integer, true::boolean, 29::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000141'::character varying, '{bcrypt}$2a$10$BlngjVWRiFBO2sMfjjcnvuerVoR4Z5GOUM4RrwSlA96SGqiz97riS'::character varying, 141::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Argirov'::character varying, '100000142'::character varying, 55::integer, true::boolean, 29::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000142'::character varying, '{bcrypt}$2a$10$sEqExaaIqPtTW1zBFCXP6OwVfpHSXkoImRRNPkdrwoXgP3sQezbG6'::character varying, 142::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Vasev'::character varying, '100000143'::character varying, 29::integer, true::boolean, 29::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000143'::character varying, '{bcrypt}$2a$10$ROPdl0nBmvvYwU8uks6ygOI38TeUEWbI1oXPIG1g7UaZfyPJ7.SfO'::character varying, 143::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Goranov'::character varying, '100000144'::character varying, 34::integer, true::boolean, 29::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000144'::character varying, '{bcrypt}$2a$10$6tt22NUBBxJFWzBAEHF7ZerGjttQLH50JrmPCsVT76ZYNMHxP.1xO'::character varying, 144::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Yovkov'::character varying, '100000145'::character varying, 31::integer, true::boolean, 29::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000145'::character varying, '{bcrypt}$2a$10$SdtftUHg2gnTNRsy6BD1K.zS892uaPA9Y9qiU75nCEhvAkHj/7ANC'::character varying, 145::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Bozhilov'::character varying, '100000146'::character varying, 34::integer, true::boolean, 29::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000146'::character varying, '{bcrypt}$2a$10$5taSQDwi7E8Gho9TzAN3Vu38I9jnYt.T.VwfnjvaIdYx.B2ytSyuW'::character varying, 146::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Legal', 'Legal department description', 3::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (17::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Goranov'::character varying, '100000147'::character varying, 53::integer, true::boolean, 30::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000147'::character varying, '{bcrypt}$2a$10$8NV2GqNh2gumHY6aA3Z4Fee1zC4m2ukjDIqpQ/pOCze7b4/xw8eOu'::character varying, 147::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (17::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Yovkov'::character varying, '100000148'::character varying, 43::integer, true::boolean, 31::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000148'::character varying, '{bcrypt}$2a$10$rKJhgEaw5x7lyaeF1NLNTuEq4nKGyoy47dNxvikcftAZSRxgQDMKu'::character varying, 148::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Bonchev'::character varying, '100000149'::character varying, 28::integer, true::boolean, 31::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000149'::character varying, '{bcrypt}$2a$10$EC3duZ0JTAWk9XfXijT1nO6Sw2Q.n1nusUc7Xgsgr/0rzkde8njsC'::character varying, 149::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Argirov'::character varying, '100000150'::character varying, 55::integer, true::boolean, 31::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000150'::character varying, '{bcrypt}$2a$10$NgbaJSguP/s3QDn5eSOSPOYp2RaBtc7m2SBjdLER3wCb0LtetCFnO'::character varying, 150::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Emilov'::character varying, '100000151'::character varying, 51::integer, true::boolean, 31::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000151'::character varying, '{bcrypt}$2a$10$ZZub/r17OXTQyARuCsyn9eANcYAdoQFxPYvx.5CNdNz62VQC967nS'::character varying, 151::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Argirov'::character varying, '100000152'::character varying, 47::integer, true::boolean, 31::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000152'::character varying, '{bcrypt}$2a$10$0YIJDc5fJkQ.j6fLpf2l0ON82aHqZ1CmaD/buNDMNdrzhskEwvbqi'::character varying, 152::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Bozhilov'::character varying, '100000153'::character varying, 39::integer, true::boolean, 31::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000153'::character varying, '{bcrypt}$2a$10$c/Tl.eIBdCqgQ3nHawi9bucrJrEr7AtbFWtwe69tWnrpck1VALAMW'::character varying, 153::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Argirov'::character varying, '100000154'::character varying, 28::integer, true::boolean, 31::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000154'::character varying, '{bcrypt}$2a$10$Xaxe6baBqwi8iEdBx6thyelnhcDOR6ho7LvtBqw2GqWtnT2VH1amW'::character varying, 154::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Tanasov'::character varying, '100000155'::character varying, 30::integer, true::boolean, 31::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000155'::character varying, '{bcrypt}$2a$10$TfiVY.9vmocmaz0ORluy8uBfkcec6T7CntRx/5HppUyytkVenYUQS'::character varying, 155::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Vasev'::character varying, '100000156'::character varying, 57::integer, true::boolean, 31::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000156'::character varying, '{bcrypt}$2a$10$t1gznXhpy7j8cOUtpNWjLu01kVWDUBWlAU8Sfwp2y2v0DXvulVhnq'::character varying, 156::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Goranov'::character varying, '100000157'::character varying, 59::integer, true::boolean, 31::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000157'::character varying, '{bcrypt}$2a$10$MhkheULQulzw.wZYO4Yfhe4WY.OybhuiBB.xl9MpBfBbAvIIO8Bdi'::character varying, 157::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Provision', 'Provision department description', 3::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (18::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Vasev'::character varying, '100000158'::character varying, 51::integer, true::boolean, 32::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000158'::character varying, '{bcrypt}$2a$10$NnKtfSdrDkm651T9jzGOqew0JHaPoI0K04iapRHeza4EoOaHDNmk2'::character varying, 158::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (18::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Vasev'::character varying, '100000159'::character varying, 58::integer, true::boolean, 33::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000159'::character varying, '{bcrypt}$2a$10$WsJRrqx.1.0G3H3lYmtXy.k8U5JtGJLKVShKkbAZJ1qRqKj79cWpC'::character varying, 159::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Bonchev'::character varying, '100000160'::character varying, 44::integer, true::boolean, 33::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000160'::character varying, '{bcrypt}$2a$10$xXg61SYkfMU3U52YdEn./ue2Be4mtI./rH8N3rxG.xrz1gTIZU9t2'::character varying, 160::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Bozhilov'::character varying, '100000161'::character varying, 33::integer, true::boolean, 33::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000161'::character varying, '{bcrypt}$2a$10$CP4yVCB0CGShdEsMLQRvR.u0ryLppQIcIAkxDW1APNr3a6mfNQ9Dm'::character varying, 161::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Argirov'::character varying, '100000162'::character varying, 25::integer, true::boolean, 33::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000162'::character varying, '{bcrypt}$2a$10$d2eHAGkp..VMhCooG39rOuTbtIEHaTe/dLScL/Hcl5Fv7rIf99Gky'::character varying, 162::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Argirov'::character varying, '100000163'::character varying, 46::integer, true::boolean, 33::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000163'::character varying, '{bcrypt}$2a$10$ERNLHOa7NFCIF0m4b3zv0OsEL4GA0ISYFDVRtmz/KC4EPEf7bzB6y'::character varying, 163::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Vasev'::character varying, '100000164'::character varying, 41::integer, true::boolean, 33::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000164'::character varying, '{bcrypt}$2a$10$/eepDuWKG2vZV0Wb036uLuiuSXvVXud1qYQ7zXZrimbZn4bRwQo6G'::character varying, 164::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Argirov'::character varying, '100000165'::character varying, 50::integer, true::boolean, 33::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000165'::character varying, '{bcrypt}$2a$10$k1yLlCoDQqiN0bhyVGHv3eS.L128GOK3nzf4y3ZJ4swvIGbkyK.gu'::character varying, 165::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Emilov'::character varying, '100000166'::character varying, 23::integer, true::boolean, 33::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000166'::character varying, '{bcrypt}$2a$10$5NY5AfgoyiyBOfVbV8iUau/HrSVcEi/3HuPNuApLkTQhg2jec80mW'::character varying, 166::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Goranov'::character varying, '100000167'::character varying, 23::integer, true::boolean, 33::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000167'::character varying, '{bcrypt}$2a$10$4K03ABObfOXxciW3omWKced.g/66Vhuf7BSC/eHAgLC5QGcqluOe6'::character varying, 167::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Vasev'::character varying, '100000168'::character varying, 49::integer, true::boolean, 33::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000168'::character varying, '{bcrypt}$2a$10$W67W7Ko7.JjZxv19pWAba.F5jYklgDaNVtORxBl6/xRuQ3Jq7qu9O'::character varying, 168::bigint, true::boolean);
INSERT INTO directorates (directorate_name, directorate_description, active)
VALUES ('Burgas', 'Burgas directorate description', true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Default department'::character varying, 'Special department for Director of Direction'::character varying,4::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (19::bigint, true::boolean, 'DIRECTORS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Emilov'::character varying, '100000169'::character varying, 24::integer, true::boolean, 34::bigint, 'DIRECTOR_OF_DIRECTORATE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000169'::character varying, '{bcrypt}$2a$10$F5Z8XxFt10RXD36cFhDle.HdIjhWdFiFPEI9xgqoHi0FOYUlrsfSy'::character varying, 169::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Sales', 'Sales department description', 4::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (20::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Emilov'::character varying, '100000170'::character varying, 54::integer, true::boolean, 35::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000170'::character varying, '{bcrypt}$2a$10$creY8Wl6MzT9.1CzVfNWDee/.IlEJ3I2x0GlFQDIUl5JcY2HqTFTi'::character varying, 170::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (20::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Yovkov'::character varying, '100000171'::character varying, 27::integer, true::boolean, 36::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000171'::character varying, '{bcrypt}$2a$10$JAjKxEcCqmfZhExHKSv6cODsheDHpJNqkRBVkGpvzove6zZqEaMJa'::character varying, 171::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Bozhilov'::character varying, '100000172'::character varying, 56::integer, true::boolean, 36::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000172'::character varying, '{bcrypt}$2a$10$ce0Q.H/YoEi8iii205lJeutpzQsYUub4Mwejy1A5.WfzrUxHdCfR.'::character varying, 172::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Tanasov'::character varying, '100000173'::character varying, 30::integer, true::boolean, 36::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000173'::character varying, '{bcrypt}$2a$10$6/poiTMy0.9xIMBERt.rOufHj6faKQig9Hmmrrem3spsAKs3AOBnm'::character varying, 173::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Tanasov'::character varying, '100000174'::character varying, 36::integer, true::boolean, 36::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000174'::character varying, '{bcrypt}$2a$10$gUyCCTEfRxUbfBEU3XS15emEFHEZwYIq0zKXybaVrnoRd6yklu8jW'::character varying, 174::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Vasev'::character varying, '100000175'::character varying, 32::integer, true::boolean, 36::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000175'::character varying, '{bcrypt}$2a$10$7wKniP.wVB.kTNtNmIPH5OBwZntjCu9/n7gjJNC0vyBwHg2wwxktu'::character varying, 175::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Bozhilov'::character varying, '100000176'::character varying, 21::integer, true::boolean, 36::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000176'::character varying, '{bcrypt}$2a$10$pEdFhfHyaH4mI8b9jZIaiec1MjGXU/aJ8xM9h85YjwCotdheQg53q'::character varying, 176::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Argirov'::character varying, '100000177'::character varying, 48::integer, true::boolean, 36::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000177'::character varying, '{bcrypt}$2a$10$xWeo8xb2lFypceaTVjXfBOf5Q40rhkLMigARqnJrUTtB06oN73f5i'::character varying, 177::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Bonchev'::character varying, '100000178'::character varying, 21::integer, true::boolean, 36::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000178'::character varying, '{bcrypt}$2a$10$LXRNLHnm2YeyF5l6bXGm7.xlpCRz/Mo8VV6wJr/j7muaIu4M7B0b2'::character varying, 178::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Goranov'::character varying, '100000179'::character varying, 43::integer, true::boolean, 36::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000179'::character varying, '{bcrypt}$2a$10$XOJNInLySiul4.v6ShjZz.C19GgvDYHRQ0mMxdrbq2korSKwA8hPq'::character varying, 179::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Bonchev'::character varying, '100000180'::character varying, 33::integer, true::boolean, 36::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000180'::character varying, '{bcrypt}$2a$10$dApMUj4UZapMMEOOppc87ObE3XfNwGHjYo/NrZSEdbxL5vshueoD.'::character varying, 180::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('IT', 'IT department description', 4::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (21::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Goranov'::character varying, '100000181'::character varying, 21::integer, true::boolean, 37::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000181'::character varying, '{bcrypt}$2a$10$K8SEYKj7BT7Neh4bbSxseuNxHr8e1RXxYCsjmZ5sTNIVq4k5lFpVS'::character varying, 181::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (21::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Emilov'::character varying, '100000182'::character varying, 40::integer, true::boolean, 38::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000182'::character varying, '{bcrypt}$2a$10$3COiduDriX.L9vCF/AoMFuKjVLKKCX2peCHrienaEos.U4Oedb1si'::character varying, 182::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Vasev'::character varying, '100000183'::character varying, 21::integer, true::boolean, 38::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000183'::character varying, '{bcrypt}$2a$10$EBy3gh/6Mpo6KPXR3ZveU.rs8dtcgqaHZokYRm2O6T6IygxWYd852'::character varying, 183::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Vasev'::character varying, '100000184'::character varying, 27::integer, true::boolean, 38::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000184'::character varying, '{bcrypt}$2a$10$wf8MnQJcWVVbp8Kz3t8IgeuIUaOtuWP4.GeqfrwDT5qQ/Lc1s1y7e'::character varying, 184::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Yovkov'::character varying, '100000185'::character varying, 40::integer, true::boolean, 38::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000185'::character varying, '{bcrypt}$2a$10$Z0fh8f62TazJEbtUbd6O8.0V4Bs05FDSyVmJYwlFRjzbzpbHSqxWa'::character varying, 185::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Goranov'::character varying, '100000186'::character varying, 40::integer, true::boolean, 38::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000186'::character varying, '{bcrypt}$2a$10$IXt0s.mGTh0LA5d9CFnGKOjYvdmjeX/pq1Wzjl0Z5kPGxnsXHL.q.'::character varying, 186::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Goranov'::character varying, '100000187'::character varying, 57::integer, true::boolean, 38::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000187'::character varying, '{bcrypt}$2a$10$.Yoo1gJIFABOwTkhn/tmNOIeecFjl47mlYi05t.9.oRxvwLuanFg6'::character varying, 187::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Emilov'::character varying, '100000188'::character varying, 28::integer, true::boolean, 38::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000188'::character varying, '{bcrypt}$2a$10$Ohg2NM8RO5IOavDzZxVmkuRleXs7dPlIQKlqFXg35YkofX4nKFeRG'::character varying, 188::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Argirov'::character varying, '100000189'::character varying, 29::integer, true::boolean, 38::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000189'::character varying, '{bcrypt}$2a$10$k2I4D1440vH4i0T1GOgC9OMhrm/WjdK7Q0nECkIIrXisrLdTMKqN6'::character varying, 189::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Tanasov'::character varying, '100000190'::character varying, 43::integer, true::boolean, 38::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000190'::character varying, '{bcrypt}$2a$10$GLQ07uZ5Rc4UjaQprS72SuU/o6ihkLZsSBVLtx0PO2.vuwi8Lenj2'::character varying, 190::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Emilov'::character varying, '100000191'::character varying, 25::integer, true::boolean, 38::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000191'::character varying, '{bcrypt}$2a$10$JxJCglObuGoPmq08hUlxXOZbueLjYyHXnPtEfAApXtbTYLKdOwf72'::character varying, 191::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Finance', 'Finance department description', 4::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (22::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Tanasov'::character varying, '100000192'::character varying, 37::integer, true::boolean, 39::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000192'::character varying, '{bcrypt}$2a$10$9OFge8UvePIKJAGFlbz53Ohl8EfjSViTC0wdVBTOtQE8xMIBycxau'::character varying, 192::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (22::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Goranov'::character varying, '100000193'::character varying, 32::integer, true::boolean, 40::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000193'::character varying, '{bcrypt}$2a$10$fp2/bSUAq7vEGtltmPawkOcer0SDlgRfsQCmwBZtMeAyYh6O.wJha'::character varying, 193::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Tanasov'::character varying, '100000194'::character varying, 50::integer, true::boolean, 40::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000194'::character varying, '{bcrypt}$2a$10$rmjeVBHtO2eibn8p4wd4O.H3lqGSTN52ZnI2adhzM2hkrxDMyDsLa'::character varying, 194::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Vasev'::character varying, '100000195'::character varying, 30::integer, true::boolean, 40::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000195'::character varying, '{bcrypt}$2a$10$kewMJnQzXDHfqAK9h24i9uaYoTkgQKxiY2Y7UsI3FzdMG9QZLQXg2'::character varying, 195::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Vasev'::character varying, '100000196'::character varying, 27::integer, true::boolean, 40::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000196'::character varying, '{bcrypt}$2a$10$crVpHAXBNm0mziNgW9HuBuptiEH7e9PbMNtgTbIbgLhuPLu603/mW'::character varying, 196::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Yovkov'::character varying, '100000197'::character varying, 49::integer, true::boolean, 40::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000197'::character varying, '{bcrypt}$2a$10$dO9Ig3r0TDL/8GVbWvj2tONFQqVIXB7XNMOgPdOnJsgqusd.CsyZO'::character varying, 197::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Yovkov'::character varying, '100000198'::character varying, 46::integer, true::boolean, 40::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000198'::character varying, '{bcrypt}$2a$10$9zppDB3cUsKaHvhExospSOveRJPl1l/JTyOtCBUryxwzAX8FgZ4T2'::character varying, 198::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Bozhilov'::character varying, '100000199'::character varying, 38::integer, true::boolean, 40::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000199'::character varying, '{bcrypt}$2a$10$JNBvAIFKfwKdaZcrVKwVx.OyoChmvjfZleLMYDTy40Jd6UDJ6xR62'::character varying, 199::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Vasev'::character varying, '100000200'::character varying, 51::integer, true::boolean, 40::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000200'::character varying, '{bcrypt}$2a$10$uEae4JiMOGIk6DL6v21EZ.Ba/j21FG/HVtgVemIF2R5r9VW6dTchK'::character varying, 200::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Emilov'::character varying, '100000201'::character varying, 52::integer, true::boolean, 40::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000201'::character varying, '{bcrypt}$2a$10$PGl7kwl4Ac2etWsrApR5.eCvXSp6qcntnhlykh30rneSJVSTb4l2i'::character varying, 201::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Goranov'::character varying, '100000202'::character varying, 52::integer, true::boolean, 40::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000202'::character varying, '{bcrypt}$2a$10$zVRT6pwgs99Ty8iFxyjwN.rMBsWol1WryWTMmMn2RZY1QlOErfada'::character varying, 202::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Legal', 'Legal department description', 4::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (23::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Vasev'::character varying, '100000203'::character varying, 24::integer, true::boolean, 41::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000203'::character varying, '{bcrypt}$2a$10$H2tFfwxw0Yq7l6DGWryVMeoVBnTcxfJzx.AZz4P42titHZKnKmuf6'::character varying, 203::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (23::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Bozhilov'::character varying, '100000204'::character varying, 46::integer, true::boolean, 42::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000204'::character varying, '{bcrypt}$2a$10$irGvej10OgETUVUjYEN6OuZ5XbuV1G/ZmM.2FuazGu5bo8TSwGAl2'::character varying, 204::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Argirov'::character varying, '100000205'::character varying, 29::integer, true::boolean, 42::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000205'::character varying, '{bcrypt}$2a$10$aCpTM7.4ghquhX2ofvvIsOvIoFuwtJ28lGoFkJjGGCWVwv8YApyCa'::character varying, 205::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Goranov'::character varying, '100000206'::character varying, 45::integer, true::boolean, 42::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000206'::character varying, '{bcrypt}$2a$10$fSm9RxUT5O3O9AyAZlNF7.cf/kL7wN7P5D.2b0Nsdp7KRUObjckB6'::character varying, 206::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Tanasov'::character varying, '100000207'::character varying, 36::integer, true::boolean, 42::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000207'::character varying, '{bcrypt}$2a$10$irdZ2iVMqPF/quCUMkKCROUzaQLRRPm3MvlRt.hzFI1kZm..sU4jG'::character varying, 207::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Goranov'::character varying, '100000208'::character varying, 52::integer, true::boolean, 42::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000208'::character varying, '{bcrypt}$2a$10$u4kalPgfjp0B/kjmjTcQ8.lgFwfqTj4UFq7DpMlyFY9n4K9BPGhNa'::character varying, 208::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Goranov'::character varying, '100000209'::character varying, 23::integer, true::boolean, 42::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000209'::character varying, '{bcrypt}$2a$10$VhTczQRWLo6zVVQZYbHHiOgcB51xn283grwQvF12ebb1mU0.wfdA.'::character varying, 209::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Emilov'::character varying, '100000210'::character varying, 20::integer, true::boolean, 42::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000210'::character varying, '{bcrypt}$2a$10$j/M.eo82r63sAu6H2w8Z5eAoWoEPCbj.tLMJNPSB9ibkh8eVEvVce'::character varying, 210::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Yovkov'::character varying, '100000211'::character varying, 47::integer, true::boolean, 42::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000211'::character varying, '{bcrypt}$2a$10$3ukUrTyzCxqmPgYbmLM9fOp4WX6rqzB6K1JdhmzvIilskCRVz2fDy'::character varying, 211::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Bozhilov'::character varying, '100000212'::character varying, 45::integer, true::boolean, 42::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000212'::character varying, '{bcrypt}$2a$10$CwEJ/N9Dym9zbkhTUE2PRO1eSi.0Y/3rbmI9.bn/lgl3yWB2JNbh6'::character varying, 212::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Vasev'::character varying, '100000213'::character varying, 53::integer, true::boolean, 42::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000213'::character varying, '{bcrypt}$2a$10$7G0ZH8ynSZdKrZLnxki4JOf2N7pqpoESXOqOp8fxl6c0LosHi6uKC'::character varying, 213::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Provision', 'Provision department description', 4::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (24::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Tanasov'::character varying, '100000214'::character varying, 20::integer, true::boolean, 43::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000214'::character varying, '{bcrypt}$2a$10$VHGD5aagUqmPN.eN7TxUXuAm5JLM3ue46EX0JgP4/8ZQ5y1KGwoHG'::character varying, 214::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (24::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Bozhilov'::character varying, '100000215'::character varying, 27::integer, true::boolean, 44::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000215'::character varying, '{bcrypt}$2a$10$jleDbwr.tbE7HaPbiHvlx.dBmFaWl.4DRMRRhKaGjfblyO18nHmOq'::character varying, 215::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Tanasov'::character varying, '100000216'::character varying, 33::integer, true::boolean, 44::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000216'::character varying, '{bcrypt}$2a$10$RmZganRIJKGQ.DEWPalrZuz7GemaKko59PNt5aBm7dBQUQPhNtpYa'::character varying, 216::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Bonchev'::character varying, '100000217'::character varying, 33::integer, true::boolean, 44::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000217'::character varying, '{bcrypt}$2a$10$uQcIUEE2fagN9jfkfGIRleMj.gRE5zgcadrAkpnNdJyWifEEcse3m'::character varying, 217::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Yovkov'::character varying, '100000218'::character varying, 22::integer, true::boolean, 44::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000218'::character varying, '{bcrypt}$2a$10$5AO8k.GSeN16FSOXmVD3Y.RDhR0LxZF/0pvMZoH25TD8hm1LqtdcG'::character varying, 218::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Bozhilov'::character varying, '100000219'::character varying, 52::integer, true::boolean, 44::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000219'::character varying, '{bcrypt}$2a$10$aGxCDM7UHX97zO4QVEytYemkHVH6.xWiD37Q0nUwYFuYl9KhM.Z8C'::character varying, 219::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Emilov'::character varying, '100000220'::character varying, 53::integer, true::boolean, 44::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000220'::character varying, '{bcrypt}$2a$10$HyxxTZ9NYG7rGCrnT5tL/OY5piUfp5XHAZsppUKiLZp8lTQcrLi..'::character varying, 220::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Tanasov'::character varying, '100000221'::character varying, 34::integer, true::boolean, 44::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000221'::character varying, '{bcrypt}$2a$10$vtivQD8SgEE1sExkTArH..ZX3xBYP7Uf/xJrIX2OHNOO6syFu2.jK'::character varying, 221::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Yovkov'::character varying, '100000222'::character varying, 29::integer, true::boolean, 44::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000222'::character varying, '{bcrypt}$2a$10$6kqBUgjvT2MlOeRo7wvUzeNGvnp.nwetG3Z25H0Q5yw73iR7D/YTq'::character varying, 222::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Yovkov'::character varying, '100000223'::character varying, 29::integer, true::boolean, 44::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000223'::character varying, '{bcrypt}$2a$10$b1IV7b/e.PqWy0i9ee79B.1brvnTfNPTknAYg8eIDKwjoWvHHRK76'::character varying, 223::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Bonchev'::character varying, '100000224'::character varying, 55::integer, true::boolean, 44::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000224'::character varying, '{bcrypt}$2a$10$sB7j2B8Ul4Xlf3YAwH/4d.EFVfBJUSFACyctHbcNL4.h.SY8VUSEu'::character varying, 224::bigint, true::boolean);
INSERT INTO directorates (directorate_name, directorate_description, active)
VALUES ('Ruse', 'Ruse directorate description', true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Default department'::character varying, 'Special department for Director of Direction'::character varying,5::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (25::bigint, true::boolean, 'DIRECTORS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Vasev'::character varying, '100000225'::character varying, 35::integer, true::boolean, 45::bigint, 'DIRECTOR_OF_DIRECTORATE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000225'::character varying, '{bcrypt}$2a$10$u/Ufl3qLXb8zWKrWDepX7.fijvZvOZrpceQ4N2X6snbuoujh4mb/q'::character varying, 225::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Sales', 'Sales department description', 5::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (26::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Bozhilov'::character varying, '100000226'::character varying, 46::integer, true::boolean, 46::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000226'::character varying, '{bcrypt}$2a$10$WKGKs.BJiHvzrMxN.jWc5eA152XwlYVqbfkYr6C0CMVtxLCVKZNye'::character varying, 226::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (26::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Bonchev'::character varying, '100000227'::character varying, 25::integer, true::boolean, 47::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000227'::character varying, '{bcrypt}$2a$10$ODml97xeLy9d6E5IrOMKWuw1W.CM/cJji8Y.WesB.UfpaDL8SPRq2'::character varying, 227::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Bozhilov'::character varying, '100000228'::character varying, 40::integer, true::boolean, 47::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000228'::character varying, '{bcrypt}$2a$10$ux0AEJmdFLporZ8/DY/QNOThKbFkxZYYrz39ejxcdDkFFaLF5d3I.'::character varying, 228::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Goranov'::character varying, '100000229'::character varying, 46::integer, true::boolean, 47::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000229'::character varying, '{bcrypt}$2a$10$O06t3kRpqzPOXDgDJwZR0.vUE.sVz.NwAJOrFHPRB2sFaV.4Uw5zK'::character varying, 229::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Bonchev'::character varying, '100000230'::character varying, 31::integer, true::boolean, 47::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000230'::character varying, '{bcrypt}$2a$10$12tAHkUS..u1RQDGlCKbieGuw5DmXJl/Lcltd2wL7.xJlRwiaE1Du'::character varying, 230::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Bonchev'::character varying, '100000231'::character varying, 46::integer, true::boolean, 47::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000231'::character varying, '{bcrypt}$2a$10$1c7YsymMFrLlIhNX3ZiY3OPCdcsKhGFNyRen1KHi2GdcpR/sO5kru'::character varying, 231::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Yovkov'::character varying, '100000232'::character varying, 21::integer, true::boolean, 47::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000232'::character varying, '{bcrypt}$2a$10$7cVf88oTzLjei3Nhj05/H.vivKn3B7fdkg9ODQAUqEGibiCGY8vZW'::character varying, 232::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Yovkov'::character varying, '100000233'::character varying, 39::integer, true::boolean, 47::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000233'::character varying, '{bcrypt}$2a$10$TRbK7PPtA0YUMSJKX8i1OebBEbaY7apWUC1fgXNqnITqh3HYTAh3K'::character varying, 233::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Argirov'::character varying, '100000234'::character varying, 34::integer, true::boolean, 47::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000234'::character varying, '{bcrypt}$2a$10$LJLI7ImZ3EVVfapg7bojZuqScsZghNyj74PqDhakiTlB3ZzBvA.de'::character varying, 234::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Emilov'::character varying, '100000235'::character varying, 21::integer, true::boolean, 47::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000235'::character varying, '{bcrypt}$2a$10$vh0H5XFliRM3VYGn/l9jku8PtvweTKDbJLS2m7JoitJ8GhtP3U70O'::character varying, 235::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Bonchev'::character varying, '100000236'::character varying, 33::integer, true::boolean, 47::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000236'::character varying, '{bcrypt}$2a$10$ALy5.PFDbnNLchvC2rIT1u4LG0t24sWHO925oBpI8wIsGfd7U.fJm'::character varying, 236::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('IT', 'IT department description', 5::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (27::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Vasev'::character varying, '100000237'::character varying, 35::integer, true::boolean, 48::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000237'::character varying, '{bcrypt}$2a$10$zp1teeMmyNw92XGcKXe8hOSkl3UKLYbkkzCAjrO4OPJoXQkYTeQA.'::character varying, 237::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (27::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Bozhilov'::character varying, '100000238'::character varying, 38::integer, true::boolean, 49::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000238'::character varying, '{bcrypt}$2a$10$pta1YCfDliv2ytR2VuXGquU2uwyoEAKGc0THhsHXHIUY8GQi28Hxy'::character varying, 238::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Emilov'::character varying, '100000239'::character varying, 37::integer, true::boolean, 49::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000239'::character varying, '{bcrypt}$2a$10$1RfEU8./zwpNseFCpYkIDe2asftE99g3myusC.EqrXfOdsOxwE3mG'::character varying, 239::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Emilov'::character varying, '100000240'::character varying, 24::integer, true::boolean, 49::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000240'::character varying, '{bcrypt}$2a$10$lAHi/AOS/FtYPhhdyc1upeF71y.X8v/23d4I./22cbd6xI/a9UDD.'::character varying, 240::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Bozhilov'::character varying, '100000241'::character varying, 41::integer, true::boolean, 49::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000241'::character varying, '{bcrypt}$2a$10$JpEtXOeNiKdsOZ45BGO6me0C0.xUsaUV7ka34ht0DeoYsFbZLBB62'::character varying, 241::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Emilov'::character varying, '100000242'::character varying, 51::integer, true::boolean, 49::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000242'::character varying, '{bcrypt}$2a$10$8hWMYrxftwQ9MVXs6fcJhewev2vs7uIJBLz1i7LsTSLRN2sUWeVgG'::character varying, 242::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Bozhilov'::character varying, '100000243'::character varying, 29::integer, true::boolean, 49::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000243'::character varying, '{bcrypt}$2a$10$XmSp7I.vlnP/sXjmNgR67uTSe559Nks3J0Hf/xY0T/7JdYFvoEChG'::character varying, 243::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Goranov'::character varying, '100000244'::character varying, 36::integer, true::boolean, 49::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000244'::character varying, '{bcrypt}$2a$10$70JSAbAJE1nknbNe/K8Cd.F7lnGiLecu5frKs4x6/DxzfQ1fMChlO'::character varying, 244::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Yovkov'::character varying, '100000245'::character varying, 41::integer, true::boolean, 49::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000245'::character varying, '{bcrypt}$2a$10$Nw8jkHrVJoYmCPYyC5oqveHkUXqDn4Uo99wXOwDCSB4wwnC4Sx.qu'::character varying, 245::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Goranov'::character varying, '100000246'::character varying, 32::integer, true::boolean, 49::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000246'::character varying, '{bcrypt}$2a$10$6VS6A62Rg.LZXvH.fIc.C.b6tUzeU3uPqPBlPdy9vFANOeGJ1/1p.'::character varying, 246::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Goranov'::character varying, '100000247'::character varying, 49::integer, true::boolean, 49::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000247'::character varying, '{bcrypt}$2a$10$xJfX1UGh6hccwMkWoNRVAuISQeLNtVZ7HcEbDod7BB9mUx1QGlck6'::character varying, 247::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Finance', 'Finance department description', 5::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (28::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Bozhilov'::character varying, '100000248'::character varying, 53::integer, true::boolean, 50::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000248'::character varying, '{bcrypt}$2a$10$GOU/ZDs6nZWiLfF7/W/.fuPzVsIWJktIUnOHx3MSBc0beYjbK2yvW'::character varying, 248::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (28::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Vasev'::character varying, '100000249'::character varying, 40::integer, true::boolean, 51::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000249'::character varying, '{bcrypt}$2a$10$kx8oAvg3XZ3ed.bb8qIRBuT5ytyH1rlvVydjK98nGBRds19LpFYBa'::character varying, 249::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Goranov'::character varying, '100000250'::character varying, 59::integer, true::boolean, 51::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000250'::character varying, '{bcrypt}$2a$10$aJkwyEYNc0hdTyT58nJf8O6PUsKq6SMydDJB.rSbQlew0wfpO/a6e'::character varying, 250::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Bozhilov'::character varying, '100000251'::character varying, 20::integer, true::boolean, 51::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000251'::character varying, '{bcrypt}$2a$10$FsB9vF4JAnJkmtTCM44ZoesoMvv/bbqY4fOwHXpInTdQhxLf02toK'::character varying, 251::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Bonchev'::character varying, '100000252'::character varying, 56::integer, true::boolean, 51::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000252'::character varying, '{bcrypt}$2a$10$SRu6UdPAO9.lsGelnCKIde4Jnt1qa61dg9/Y11QVDnyIlyzbCmKoW'::character varying, 252::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Argirov'::character varying, '100000253'::character varying, 22::integer, true::boolean, 51::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000253'::character varying, '{bcrypt}$2a$10$8VPtQEvtev3WM/ATpfcBj.aqckogjpqvI/.K5oZL3lb8W9/mLGVqO'::character varying, 253::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Vasev'::character varying, '100000254'::character varying, 28::integer, true::boolean, 51::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000254'::character varying, '{bcrypt}$2a$10$YMYVawg8v.cEk7Tx0QBT.eCmq5hOM/RjWSpNWoIIjb4MAeEG4zjbu'::character varying, 254::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Bonchev'::character varying, '100000255'::character varying, 52::integer, true::boolean, 51::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000255'::character varying, '{bcrypt}$2a$10$aGFOL9BS0fmhoJt0yyKUwu/QKlTA6gYCQKHP/UlmEGCaqhWANkCqO'::character varying, 255::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Bonchev'::character varying, '100000256'::character varying, 22::integer, true::boolean, 51::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000256'::character varying, '{bcrypt}$2a$10$Pp8sIK/H4pv1NdV4kaUxJ.mU3Ogju3S5Sdc60yKD/RCRXKBnIpfJO'::character varying, 256::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Tanasov'::character varying, '100000257'::character varying, 22::integer, true::boolean, 51::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000257'::character varying, '{bcrypt}$2a$10$WNEtdeqmOHQdOLrHJu/if.KhYrLVKMaznnHpwo3fH5YFPES/eZAEi'::character varying, 257::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Bonchev'::character varying, '100000258'::character varying, 55::integer, true::boolean, 51::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000258'::character varying, '{bcrypt}$2a$10$.Cfj3oQwqqPQugziFgGuHOFzhTTsYQpilg76zEqkf0OheI3yguUZ6'::character varying, 258::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Legal', 'Legal department description', 5::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (29::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Bozhilov'::character varying, '100000259'::character varying, 20::integer, true::boolean, 52::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000259'::character varying, '{bcrypt}$2a$10$/AAyPa5vAR/BxPiUnAUW3e0TcMmkj6TuIERu.1eKbKlrtCRyvpSPG'::character varying, 259::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (29::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Argirov'::character varying, '100000260'::character varying, 55::integer, true::boolean, 53::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000260'::character varying, '{bcrypt}$2a$10$DRx8UEx2x2z.TLNEcRHZOeFSo7/1WVwo2zG9p0L3Kd8gliXVsgH4C'::character varying, 260::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Yovkov'::character varying, '100000261'::character varying, 36::integer, true::boolean, 53::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000261'::character varying, '{bcrypt}$2a$10$ww2PCdOGb2MtsJbPxxVeueKHHYoBCWa1PiJ9rD2A11ZcYzXoONAry'::character varying, 261::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Valko'::character varying, 'Bonchev'::character varying, '100000262'::character varying, 44::integer, true::boolean, 53::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000262'::character varying, '{bcrypt}$2a$10$CI3VQhWq7wh4B4GmwE0wfOn.B.KPu8Sq.tKP/lvkX4xWRw5ngeADW'::character varying, 262::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Tanasov'::character varying, '100000263'::character varying, 44::integer, true::boolean, 53::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000263'::character varying, '{bcrypt}$2a$10$gBr7hPBb6DeQniakuQbKzOo.LF59IR42hG8ijBvVdYnFahkoeR9Yy'::character varying, 263::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Bonchev'::character varying, '100000264'::character varying, 34::integer, true::boolean, 53::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000264'::character varying, '{bcrypt}$2a$10$P5cF7AoaaRe0YVUYfdmAr.IQqIGkLCF8YAe80xQrykU3sUKrqOsXa'::character varying, 264::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Bozhilov'::character varying, '100000265'::character varying, 28::integer, true::boolean, 53::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000265'::character varying, '{bcrypt}$2a$10$LTyzU5e41G76M6GP6dIXUOcEUwoxT12UIlYzeG66Z8JTbH9lwI4h6'::character varying, 265::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Bozhilov'::character varying, '100000266'::character varying, 53::integer, true::boolean, 53::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000266'::character varying, '{bcrypt}$2a$10$wTpynEG/AC/HPeYaoQKyOuHrmQgRKXTxdKuvNUoz1M67qBBwYIgcG'::character varying, 266::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Tanasov'::character varying, '100000267'::character varying, 27::integer, true::boolean, 53::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000267'::character varying, '{bcrypt}$2a$10$pA6Qy9DGVKxNny37u1g5luKk8tbw9z5hi12IbPh/gb.1Wjb5Pl/Ne'::character varying, 267::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Yovkov'::character varying, '100000268'::character varying, 27::integer, true::boolean, 53::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000268'::character varying, '{bcrypt}$2a$10$g/JBpg1A2b7NCAhHK8k27eIYxf.A.IZGZR1pT1EXtkP3jdYDHaJSC'::character varying, 268::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Goranov'::character varying, '100000269'::character varying, 47::integer, true::boolean, 53::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000269'::character varying, '{bcrypt}$2a$10$n5C4o5b9mrgFaHu7lj/3AeGKyZA7vAFyuaJuzj80j9cq6AEeVx8wW'::character varying, 269::bigint, true::boolean);
INSERT INTO departments (department_name, department_description, directorate, active)
VALUES ('Provision', 'Provision department description', 5::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (30::bigint, true::boolean, 'HEADS'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Yovkov'::character varying, '100000270'::character varying, 43::integer, true::boolean, 54::bigint, 'HEAD_OF_DEPARTMENT'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000270'::character varying, '{bcrypt}$2a$10$GxxdrPfZ9mAuVIXRdn06DefYg/Wsv/CPKHqoKRgkTl.N3zUKeWew.'::character varying, 270::bigint, true::boolean);
INSERT INTO subdepartments (parent, active, subdepartment_type)
VALUES (30::bigint, true::boolean, 'EMPLOYEES'::subdepartment_type);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Bonchev'::character varying, '100000271'::character varying, 21::integer, true::boolean, 55::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000271'::character varying, '{bcrypt}$2a$10$bJZBOz8EZX2gGBKcvgJNbugWIU7dfAqRsUgHgGUFt/HMYGP9AdeC2'::character varying, 271::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Boyan'::character varying, 'Vasev'::character varying, '100000272'::character varying, 48::integer, true::boolean, 55::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000272'::character varying, '{bcrypt}$2a$10$PKGU.pC/VDUeaInisQyt.uhMKtGo7gGkT2lIo/5zisKBu5eVzsxDW'::character varying, 272::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Stoyan'::character varying, 'Argirov'::character varying, '100000273'::character varying, 40::integer, true::boolean, 55::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000273'::character varying, '{bcrypt}$2a$10$3Or66IXdF4KVektwr65PnOvsqXF/5wh72oRHgMLpLpKuSmM.RMJre'::character varying, 273::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Tanasov'::character varying, '100000274'::character varying, 21::integer, true::boolean, 55::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000274'::character varying, '{bcrypt}$2a$10$EuA5ECSTf0rjqK9ll79Yy.BXdcX.nydZo1cIF6kNmxY9GH52cA9Dq'::character varying, 274::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Kiril'::character varying, 'Bonchev'::character varying, '100000275'::character varying, 41::integer, true::boolean, 55::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000275'::character varying, '{bcrypt}$2a$10$blCgMcJZd1Uy4aMG8CRlA.eMKbM0kF8XA8AU/L/nkug9hi6tyzjw2'::character varying, 275::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Goranov'::character varying, '100000276'::character varying, 49::integer, true::boolean, 55::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000276'::character varying, '{bcrypt}$2a$10$fS8neCTqiO4m57EqTjChiOtkQXZMwMXDMf/C/eCZA75OsE15Lo6BW'::character varying, 276::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Petar'::character varying, 'Tanasov'::character varying, '100000277'::character varying, 36::integer, true::boolean, 55::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000277'::character varying, '{bcrypt}$2a$10$285lHfJgWBznjJGKOHOfN.gCBmoa8pag22suc5rfriy94YeyZjWj.'::character varying, 277::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Filip'::character varying, 'Goranov'::character varying, '100000278'::character varying, 39::integer, true::boolean, 55::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000278'::character varying, '{bcrypt}$2a$10$XdXc1rYa4VWa.DbyhHzj6utlC2xsPJx8fQRT7tGuzW6sK/NXdHd4S'::character varying, 278::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Yanko'::character varying, 'Argirov'::character varying, '100000279'::character varying, 33::integer, true::boolean, 55::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000279'::character varying, '{bcrypt}$2a$10$muMQnZONMZb3QSxYZewG3uxIyFSZXqYfiRrRrlhLdXOOCxT9mmYEq'::character varying, 279::bigint, true::boolean);
INSERT INTO employees (employee_name, employee_surname, employee_personal_id, employee_age, active, subdepartment, employee_position)
VALUES ('Andrey'::character varying, 'Emilov'::character varying, '100000280'::character varying, 35::integer, true::boolean, 55::bigint, 'EMPLOYEE'::position_nomenclature);
INSERT INTO users (username, password, employee_id, active)
VALUES ('100000280'::character varying, '{bcrypt}$2a$10$7.slAFh7AZDLJKedMJg01up4H6cdwU5Fu5flU6QCjoH6i4Q7VvE6m'::character varying, 280::bigint, true::boolean);
