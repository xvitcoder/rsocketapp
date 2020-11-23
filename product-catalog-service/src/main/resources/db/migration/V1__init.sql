create table product_catalog (
    id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    supplier_id BIGINT NOT NULL,
    created_on TIMESTAMP NOT NULL,
    changed_on TIMESTAMP,
    unique(name, supplier_id)
)