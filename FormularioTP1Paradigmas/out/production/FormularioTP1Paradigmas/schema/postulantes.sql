CREATE TABLE postulantes (
     id INTEGER PRIMARY KEY AUTOINCREMENT,
     nombre TEXT NOT NULL,
     email TEXT NOT NULL UNIQUE,
     telefono TEXT,
     direccion TEXT,
     experiencia TEXT,
     educacion TEXT,
     habilidades TEXT
);
