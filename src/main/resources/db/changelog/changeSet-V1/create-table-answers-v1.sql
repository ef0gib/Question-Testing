create table answers
(
    ans_id int8 generated by default as identity,
    ans_name varchar(255),
    ans_que_id int8,
    primary key (ans_id)
)
