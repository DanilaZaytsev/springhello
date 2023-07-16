CREATE TABLE IF NOT EXISTS recipients (
    id            VARCHAR(36) PRIMARY KEY DEFAULT public.gen_random_uuid(),
    channel       VARCHAR(255) NOT NULL,
    address       VARCHAR(1024),
    full_name VARCHAR(1000)
    );

ALTER TABLE notifications ADD CONSTRAINT fk_notifications_recipient_uid
foreign key (recipient_uid) references recipients(id);