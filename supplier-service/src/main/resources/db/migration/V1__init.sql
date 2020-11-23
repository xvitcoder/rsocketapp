create table supplier (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    created_on TIMESTAMP NOT NULL,
    changed_on TIMESTAMP,
    unique(name)
)