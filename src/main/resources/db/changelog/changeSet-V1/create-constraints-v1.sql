alter table if exists answers
    add constraint FKqqs3r5kvu71axifgjyp634g57 foreign key (ans_que_id) references questions;
alter table if exists questions
    add constraint FK5dyf8fbuj0e51y0kilvq2lie3 foreign key (que_lvl_id) references levels;
alter table if exists questions
    add constraint FKolw8jf7kefkpt8ha86jras9ri foreign key (que_prof_id) references profiles;
