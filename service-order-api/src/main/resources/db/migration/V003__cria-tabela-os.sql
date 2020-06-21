create table order_service (
	id bigint not null auto_increment,
    client_id bigint not null,
    descr text not null,
    price decimal(10,2) not null,
    status varchar(20) not null,
    date_opening datetime not null,
    date_closing datetime,
    
    primary key (id)
);

alter table order_service add constraint fk_order_service_client
foreign key (client_id) references client(id);