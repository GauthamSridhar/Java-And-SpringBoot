create table task_db (
        id integer not null,
        name varchar(50),
        description varchar(100),
        due_date date,
        status varchar(50),
        activity varchar(50),

        primary key (id)
    );


insert
    into
        task_db
        (id,name,description,due_date,status,activity)
    values
        (1,"ABC","CDEF","2024-10-10","PENDING","ACTIVE");

insert
    into
        task_db
        (id,name,description,due_date,status,activity)
    values
        (2,"GHI","KLMNO","2024-10-12","COMPLETED","ACTIVE");

