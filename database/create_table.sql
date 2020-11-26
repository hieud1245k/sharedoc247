use sharedoc247;

create table user(
	id bigint not null primary key auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    full_name varchar(255) not null,
    gmail varchar(255) not null,
    phone_number varchar(10) not null,
    balance int not null,
    status int not null, 
    role_id int not null,
    created_at timestamp null,
	updated_at timestamp null,
    deleted_at timestamp null,
    updated_by bigint null
);

create table role (
	id int not null primary key auto_increment,
    role_name varchar(255) not null,
    role_code varchar(255) not null,
	created_at timestamp null,
	updated_at timestamp null,
    deleted_at timestamp null,
    updated_by bigint null
);

create table category (
	id int not null primary key auto_increment,
    category_name varchar(255) not null,
    category_code varchar(255) not null,
	created_at timestamp null,
	updated_at timestamp null,
    deleted_at timestamp null,
    updated_by bigint null
);

create table document (
	id bigint not null primary key auto_increment,
    document_name varchar(255) not null,
    document_data Nvarchar(3072) not null,
    status int not null,
    cost int not null,
    category_id int not null,
    user_id bigint not null,
	created_at timestamp null,
	updated_at timestamp null,
    deleted_at timestamp null,
    updated_by bigint null
);

create table transaction (
	id bigint not null primary key auto_increment,
    document_id bigint not null,
    assign_by bigint not null,
    assign_at timestamp null,
	created_at timestamp null,
	updated_at timestamp null,
    deleted_at timestamp null,
    updated_by bigint null
);

alter table user add constraint fk_user_role foreign key (role_id) references role(id);
alter table document add constraint fk_document_category foreign key (category_id) references category(id);
alter table document add constraint fk_document_user foreign key (user_id) references user(id);
alter table transaction add constraint fk_transaction_document foreign key (document_id) references document(id);
alter table transaction add constraint fk_transaction_user_assign foreign key (assign_by) references user(id);       