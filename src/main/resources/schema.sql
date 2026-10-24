-- 1. Ensure your custom schema exists
create schema if not exists app;

-- 2. Create the courses table inside the app schema
create table if not exists app.courses
(
    id bigserial primary key,
    title text,
    description text,
    published boolean default false
);

-- 3. Create sequence for the AlbumInfo entity if using SEQUENCE strategy
create sequence if not exists app.album_info_details_seq
    increment by 50
    start with 1;

-- 4. Create the album_info_details table inside the app schema
create table if not exists app.album_info_details (
                                                      album_id          bigint primary key default nextval('app.album_info_details_seq'),
    album_name        text,
    album_description text,
    album_price       numeric(19, 2),
    date_created      timestamp default current_timestamp,
    last_updated      timestamp default current_timestamp
    );

-- 5. Safe insert for courses (bypasses ON CONFLICT syntax requirements)
insert into app.courses (title, description, published)
select 'Spring Boot 4 Fundamentals', 'Master modern backend microservices and enterprise patterns.', true
    where not exists (
    select 1 from app.courses where title = 'Spring Boot 4 Fundamentals'
);

insert into app.courses (title, description, published)
select 'Agentic AI Architecture', 'Build multi-agent workflows with Bedrock and MCP.', false
    where not exists (
    select 1 from app.courses where title = 'Agentic AI Architecture'
);

-- 6. Safe insert for album info details
insert into app.album_info_details (album_name, album_description, album_price)
select 'Java 25 Masterclass', 'Comprehensive guide to modern Java features.', 49.99
    where not exists (
    select 1 from app.album_info_details where album_name = 'Java 25 Masterclass'
);

insert into app.album_info_details (album_name, album_description, album_price)
select 'Spring Boot 4 Enterprise', 'Building cloud-native microservices.', 59.99
    where not exists (
    select 1 from app.album_info_details where album_name = 'Spring Boot 4 Enterprise'
);
