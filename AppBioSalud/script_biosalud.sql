-- ===============================================
-- SCRIPT PARA LA BASE DE DATOS DE APPBIOSALUD
-- ===============================================

CREATE DATABASE IF NOT EXISTS appbiosalud;
USE appbiosalud;

-- ========================
-- TABLA PACIENTE
-- ========================
CREATE TABLE paciente (
  id_paciente INT AUTO_INCREMENT PRIMARY KEY,
  dni VARCHAR(20) UNIQUE NOT NULL,
  nombres VARCHAR(100) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  fecha_nacimiento DATE,
  telefono VARCHAR(50),
  email VARCHAR(100)
);

-- ========================
-- TABLA MEDICO
-- ========================
CREATE TABLE medico (
  id_medico INT AUTO_INCREMENT PRIMARY KEY,
  nombres VARCHAR(100),
  apellidos VARCHAR(100),
  especialidad VARCHAR(100),
  cmp VARCHAR(50),
  telefono VARCHAR(50)
);

-- ========================
-- TABLA USUARIO
-- ========================
CREATE TABLE usuario (
  id_usuario INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(50) UNIQUE NOT NULL,
  password_hash VARCHAR(64) NOT NULL,
  rol VARCHAR(20)
);

-- ========================
-- TABLA TECNICO LABORATORIO
-- ========================
CREATE TABLE tecnico_laboratorio (
  id_tecnico INT AUTO_INCREMENT PRIMARY KEY,
  nombres VARCHAR(100) NOT NULL,
  apellidos VARCHAR(100) NOT NULL,
  especialidad VARCHAR(100),
  telefono VARCHAR(50)
);

-- ========================
-- TABLA ORDEN DE LABORATORIO
-- ========================
CREATE TABLE orden_laboratorio (
  id_orden INT AUTO_INCREMENT PRIMARY KEY,
  fecha_orden DATETIME,
  tipo_examen VARCHAR(255),
  observaciones TEXT,
  id_paciente INT,
  id_medico INT,
  estado VARCHAR(50) DEFAULT 'PENDIENTE',
  FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente),
  FOREIGN KEY (id_medico) REFERENCES medico(id_medico)
);

-- ========================
-- TABLA TOMA DE MUESTRA
-- ========================
CREATE TABLE toma_muestra (
  id_muestra INT AUTO_INCREMENT PRIMARY KEY,
  fecha_hora DATETIME,
  tipo_muestra VARCHAR(50),
  id_orden INT,
  id_tecnico INT,
  FOREIGN KEY (id_orden) REFERENCES orden_laboratorio(id_orden),
  FOREIGN KEY (id_tecnico) REFERENCES tecnico_laboratorio(id_tecnico)
);

-- ========================
-- TABLA RESULTADO DE LABORATORIO
-- ========================
CREATE TABLE resultado_laboratorio (
  id_resultado INT AUTO_INCREMENT PRIMARY KEY,
  fecha_resultado DATETIME,
  descripcion TEXT,
  valores_json TEXT,
  conclusiones TEXT,
  id_orden INT,
  validado BOOLEAN DEFAULT FALSE,
  FOREIGN KEY (id_orden) REFERENCES orden_laboratorio(id_orden)
);

-- ========================
-- TABLA FACTURA
-- ========================
CREATE TABLE factura (
  id_factura INT AUTO_INCREMENT PRIMARY KEY,
  fecha_emision DATETIME,
  monto_total DECIMAL(10,2),
  metodo_pago VARCHAR(50),
  id_paciente INT,
  FOREIGN KEY (id_paciente) REFERENCES paciente(id_paciente)
);

-- ========================
-- TABLA DETALLE FACTURA
-- ========================
CREATE TABLE detalle_factura (
  id_detalle INT AUTO_INCREMENT PRIMARY KEY,
  id_factura INT,
  descripcion_servicio VARCHAR(255),
  cantidad INT,
  precio_unitario DECIMAL(10,2),
  FOREIGN KEY (id_factura) REFERENCES factura(id_factura)
);

-- ========================
-- USUARIO DE PRUEBA
-- ========================
INSERT INTO usuario (username, password_hash, rol)
VALUES (
    'admin',
    SHA2('admin123', 256),
    'ADMIN'
);

