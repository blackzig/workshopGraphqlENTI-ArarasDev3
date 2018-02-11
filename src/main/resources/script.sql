/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Michel
 * Created: 11/02/2018
 */

create table operator(
id varchar(255) not null primary key,
name varchar(255) not null,
email varchar(255) not null,
login varchar(255) not null,
password varchar(255) not null,
active boolean not null,
logged boolean not null,
logged_in timestamp,
logged_out timestamp,
pass varchar(10) not null
)engine=innodb;

create table type_user(
id varchar(255) not null primary key,
function_operator varchar(255) not null,
FOREIGN KEY (id) REFERENCES operator (id) on update cascade
)engine=innodb;

INSERT INTO operator VALUES("2a093097-261b-4c82-8da9-ae8e0f64cf91", 
"Michel Adriano Medeiros", "michel.medeiros@ti.rc.sp.gov.br", 
"michel", sha2("teste",256), 1, 0, now(), now(), "1234567890");

INSERT INTO type_user VALUES("2a093097-261b-4c82-8da9-ae8e0f64cf91", "TI");