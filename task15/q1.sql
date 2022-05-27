CREATE TABLE games (
	id SERIAL PRIMARY KEY,
	name VARCHAR(20),
	creation_date DATE
);

CREATE TABLE complexity (
	id SERIAL PRIMARY KEY,
	name VARCHAR(20)
);

CREATE TABLE levels (
	id SERIAL PRIMARY KEY,
	complexity_id INTEGER REFERENCES complexity (id),
	name VARCHAR(20),
	game_id INTEGER REFERENCES games (id)
);