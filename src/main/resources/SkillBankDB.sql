.open SkillBank.db

CREATE TABLE USER (
    user_id INT,
    username VARCHAR(30),

    PRIMARY KEY (user_id)
);

CREATE TABLE SKILL (
    user_id INT,
    skill_id INT,
    skill_name VARCHAR(30),
    hours DOUBLE CHECK (hours >= 0),

    UNIQUE (skill_name),
    PRIMARY KEY (user_id, skill_id)
);

PRAGMA foreign_keys=1;