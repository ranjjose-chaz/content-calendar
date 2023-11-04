CREATE TABLE IF NOT EXISTS Content (
    id INTEGER AUTO_INCREMENT,
    hits INTEGER,
    title VARCHAR(255) NOT NULL,
    desc TEXT,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255),
    PRIMARY KEY (id)
);

-- INSERT INTO Content(title, hits, desc, status, content_type, date_created)
-- VALUES (5, 'My Spring Data blog post', 'A post aboput how spring data works', 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP);