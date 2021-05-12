
INSERT INTO public.category(
            category_id, category)
    VALUES (1, 'Warning');
    INSERT INTO public.category(
            category_id, category)
    VALUES (2, 'Error');
    INSERT INTO public.category(
            category_id, category)
    VALUES (3, 'Unavaliable service');


INSERT INTO public.attachments(
            attachment_id, item_id, attachment)
    VALUES (1, 1,  pg_read_binary_file('postgresql.conf'));
    INSERT INTO public.attachments(
            attachment_id, item_id, attachment)
    VALUES (2,2, 'postmaster.opts');
    INSERT INTO public.attachments(
            attachment_id, item_id, attachment)
    VALUES (3, 3, 'postmaster.pid');


    commit;



INSERT INTO public.comments(
            comment_text, comment_id)
    VALUES ('Comment1', 1);
    
INSERT INTO public.comments(
            comment_text, comment_id)
    VALUES ('Comment2', 2);

    INSERT INTO public.comments(
            comment_text, comment_id)
    VALUES ('Comment3', 3);

    commit;




INSERT INTO public.roles(
            role_id, role_name, description)
    VALUES (1, 'Admin', 'Admin user');

INSERT INTO public.roles(
            role_id, role_name, description)
    VALUES (2, 'User', 'Simple user');

INSERT INTO public.roles(
            role_id, role_name, description)
    VALUES (3, 'Consumer', 'Consumer user');



INSERT INTO public.rules(
            rule_id, rule_name, description)
    VALUES (1, 'Simple', 'Simple rule');

INSERT INTO public.rules(
            rule_id, rule_name, description)
    VALUES (2, 'Complex', 'Complex rule');

    INSERT INTO public.rules(
            rule_id, rule_name, description)
    VALUES (3, 'Ordinary', 'Ordinary rule');

    commit;
    

INSERT INTO public.states(
            state_id, state)
    VALUES (1, 'Opened');
    
INSERT INTO public.states(
            state_id, state)
    VALUES (2, 'Closed');
    INSERT INTO public.states(
            state_id, state)
    VALUES (3, 'In progress');

    commit;



INSERT INTO public.users(
            user_id, username, password, role)
    VALUES (1, 'Carlos', '123456', 1);
INSERT INTO public.users(
            user_id, username, password, role)
    VALUES (2, 'Romero', '123456', 2);
    INSERT INTO public.users(
            user_id, username, password, role)
    VALUES (3, 'Diego', '123456', 3);
    commit;



INSERT INTO public.items(
            item_id, state_id, attach_id, category_id, user_id, comment_id)
    VALUES (1,1, 1, 1, 1, 1);
INSERT INTO public.items(
            item_id, state_id, attach_id, category_id, user_id, comment_id)
    VALUES (2,2, 2, 2, 2, 1);

    INSERT INTO public.items(
            item_id, state_id, attach_id, category_id, user_id, comment_id)
    VALUES (3,2, 3, 2, 3, 1);

    INSERT INTO public.items(
            item_id, state_id, attach_id, category_id, user_id, comment_id)
    VALUES (4,1, 1, 1, 3, 1);

    commit;
    




