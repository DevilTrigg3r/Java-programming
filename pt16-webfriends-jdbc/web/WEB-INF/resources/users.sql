CREATE TABLE `users` (
`username` varchar(50) NOT NULL,
`password` varchar(50) NOT NULL,
`role` varchar(50) NOT NULL,
PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

insert into users VALUES('dawbio2','dawbio2','admin');
insert into users VALUES('daw2','daw2','basic');
insert into users VALUES('dawbio1','dawbio1','admin');

