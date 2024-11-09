CREATE TABLE users_roles
(
    users_id BIGINT NOT NULL,
    role_id BIGINT NOT NULL,
    PRIMARY KEY (users_id, role_id),
    FOREIGN KEY (users_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE
);
