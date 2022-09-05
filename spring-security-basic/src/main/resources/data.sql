

INSERT  INTO users (username , password , enabled) VALUES ( 'admin', '{bcrypt}$2a$10$LEST5sxTuNLTCN5zCbwSPeG0aYjebCZjYtT/dw3rexPAohgT0ToTK', 1);

INSERT  INTO authorities VALUES ('admin', 'USER');
INSERT  INTO authorities VALUES ('admin', 'ADMIN');


INSERT  INTO users (username , password , enabled) VALUES ( 'user', '{pbkdf2}0626c51afbed463b2ebad3f4eb8ec834751c33c9c9794d0f5bfd56a3e7546b421b89e1c09412015a', 1);

INSERT  INTO authorities VALUES ('user', 'USER');


INSERT  INTO users (username , password , enabled) VALUES ( 'manager', '{scrypt}$e0801$Nj81nzcZsYqoDaZcCap6q0PynYrFoUG+HnOvQ/vbJ6uNqLQwO7eg3dIWrOTVrYncjfx8+vCm3X4dVvq+COb5RQ==$NeyQ7moSFzqHMXOYguzloWkkncveqZmEi00LBbCz2Qc=', 1);

INSERT  INTO authorities VALUES ('manager', 'USER');
INSERT  INTO authorities VALUES ('manager', 'MANAGER');

