CREATE TABLE IF NOT EXISTS AUTHOR (
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Content (
    --id INTEGER AUTO_INCREMENT,
    id SERIAL PRIMARY KEY,
    hits INTEGER,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(20) NOT NULL,
    content_type VARCHAR(50) NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    url VARCHAR(255),
    author_id INT,
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES AUTHOR(author_id)

    --PRIMARY KEY (id)
);

-- INSERT INTO Content(title, hits, desc, status, content_type, date_created)
-- VALUES (5, 'My Spring Data blog post', 'A post aboput how spring data works', 'IDEA', 'ARTICLE', CURRENT_TIMESTAMP);