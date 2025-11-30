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

-- ===============================================
-- PROCEDIMIENTOS ALMACENADOS PARA PACIENTES
-- ===============================================

-- Procedimiento para insertar paciente
DELIMITER //
CREATE PROCEDURE sp_insertar_paciente(
    IN p_dni VARCHAR(20),
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_fecha_nacimiento DATE,
    IN p_telefono VARCHAR(50),
    IN p_email VARCHAR(100)
)
BEGIN
    INSERT INTO paciente (dni, nombres, apellidos, fecha_nacimiento, telefono, email)
    VALUES (p_dni, p_nombres, p_apellidos, p_fecha_nacimiento, p_telefono, p_email);
END //
DELIMITER ;

-- Procedimiento para actualizar paciente
DELIMITER //
CREATE PROCEDURE sp_actualizar_paciente(
    IN p_id_paciente INT,
    IN p_dni VARCHAR(20),
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_fecha_nacimiento DATE,
    IN p_telefono VARCHAR(50),
    IN p_email VARCHAR(100)
)
BEGIN
    UPDATE paciente 
    SET dni = p_dni,
        nombres = p_nombres,
        apellidos = p_apellidos,
        fecha_nacimiento = p_fecha_nacimiento,
        telefono = p_telefono,
        email = p_email
    WHERE id_paciente = p_id_paciente;
END //
DELIMITER ;

-- Procedimiento para eliminar paciente
DELIMITER //
CREATE PROCEDURE sp_eliminar_paciente(
    IN p_id_paciente INT
)
BEGIN
    DELETE FROM paciente WHERE id_paciente = p_id_paciente;
END //
DELIMITER ;

-- Procedimiento para buscar paciente por ID
DELIMITER //
CREATE PROCEDURE sp_buscar_paciente_por_id(
    IN p_id_paciente INT
)
BEGIN
    SELECT * FROM paciente WHERE id_paciente = p_id_paciente;
END //
DELIMITER ;

-- Procedimiento para buscar paciente por DNI
DELIMITER //
CREATE PROCEDURE sp_buscar_paciente_por_dni(
    IN p_dni VARCHAR(20)
)
BEGIN
    SELECT * FROM paciente WHERE dni = p_dni;
END //
DELIMITER ;

-- Procedimiento para buscar pacientes por apellidos (búsqueda parcial)
DELIMITER //
CREATE PROCEDURE sp_buscar_paciente_por_apellidos(
    IN p_apellidos VARCHAR(100)
)
BEGIN
    SELECT * FROM paciente WHERE apellidos LIKE p_apellidos;
END //
DELIMITER ;

-- Procedimiento para listar todos los pacientes
DELIMITER //
CREATE PROCEDURE sp_listar_pacientes()
BEGIN
    SELECT * FROM paciente ORDER BY apellidos, nombres;
END //
DELIMITER ;

-- Procedimiento para contar pacientes
DELIMITER //
CREATE PROCEDURE sp_contar_pacientes()
BEGIN
    SELECT COUNT(*) as total FROM paciente;
END //
DELIMITER ;

--Procedimiento para listar medicos
DELIMITER //
CREATE PROCEDURE sp_medico_listar()
BEGIN
    SELECT * FROM medico;
END //
DELIMITER ;

--Procedimiento para actualizar medicos
DELIMITER //
CREATE PROCEDURE sp_medico_actualizar(
    IN p_id INT,
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_especialidad VARCHAR(100),
    IN p_cmp VARCHAR(50),
    IN p_telefono VARCHAR(50)
)
BEGIN
    UPDATE medico
    SET nombres = p_nombres,
        apellidos = p_apellidos,
        especialidad = p_especialidad,
        cmp = p_cmp,
        telefono = p_telefono
    WHERE id_medico = p_id;
END //
DELIMITER ;

--Procedimiento para contar medicos
DELIMITER //
CREATE PROCEDURE sp_medico_contar(OUT total INT)
BEGIN
    SELECT COUNT(*) INTO total FROM medico;
END //
DELIMITER ;

--Procedimiento para eliminar medicos
DELIMITER //
CREATE PROCEDURE sp_medico_eliminar(IN p_id INT)
BEGIN
    DELETE FROM medico WHERE id_medico = p_id;
END //
DELIMITER ;

--Procedimiento para buscar medicos
DELIMITER //
CREATE PROCEDURE sp_medico_obtenerPorID(IN p_id INT)
BEGIN
    SELECT * FROM medico WHERE id_medico = p_id;
END //
DELIMITER ;

--Procedimiento para registrar medico
DELIMITER //
CREATE PROCEDURE sp_medico_crear(
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_especialidad VARCHAR(100),
    IN p_cmp VARCHAR(50),
    IN p_telefono VARCHAR(50)
)
BEGIN
    INSERT INTO medico (nombres, apellidos, especialidad, cmp, telefono)
    VALUES (p_nombres, p_apellidos, p_especialidad, p_cmp, p_telefono);
END //
DELIMITER ;

--procedimiento para insertar medico
DELIMITER //
CREATE PROCEDURE sp_medico_insertar(
    IN p_nombres VARCHAR(100),
    IN p_apellidos VARCHAR(100),
    IN p_especialidad VARCHAR(100),
    IN p_cmp VARCHAR(50),
    IN p_telefono VARCHAR(50)
)
BEGIN
    INSERT INTO medico (nombres, apellidos, especialidad, cmp, telefono)
    VALUES (p_nombres, p_apellidos, p_especialidad, p_cmp, p_telefono);
END //
DELIMITER ;

//Tipos de Examenes 
CREATE PROCEDURE sp_tipos_examen()
BEGIN
  SELECT DISTINCT tipo_examen FROM orden_laboratorio 
  WHERE tipo_examen IS NOT NULL AND tipo_examen <> ''
  ORDER BY tipo_examen;
END //
DELIMITER ;


-- [2] PROCEDIMIENTO DE REPORTE DE EXÁMENES 
//llenar las tablas y operaciones

DELIMITER //
CREATE PROCEDURE sp_reporte_examenes (
  IN p_tipoExamen VARCHAR(255),
  IN p_fechaInicio DATE,
  IN p_fechaFin DATE
)
BEGIN
  -- Definir el patrón de búsqueda para el tipo de examen
  SET @tipoPattern = IF(p_tipoExamen IS NULL OR p_tipoExamen = '', '%', p_tipoExamen);

  -- Tabla 1: Detalle de órdenes (para TablaReportes en Java)
  SELECT 
    o.id_orden, 
    o.tipo_examen, 
    DATE(o.fecha_orden) AS fecha_orden, -- Formateamos la fecha a solo DATE
    DATEDIFF(r.fecha_resultado, o.fecha_orden) AS tiempo_entrega
  FROM orden_laboratorio o
  LEFT JOIN resultado_laboratorio r ON o.id_orden = r.id_orden
  WHERE o.tipo_examen LIKE @tipoPattern -- Usa el patrón de búsqueda
    AND DATE(o.fecha_orden) BETWEEN p_fechaInicio AND p_fechaFin -- Filtro de fecha corregido
  ORDER BY o.fecha_orden;

  -- Tabla 2: Resumen (Totales y Promedio) (para TablaReportes1 en Java)
  SELECT 
    COUNT(o.id_orden) AS total_examenes, -- Contamos las órdenes
    COALESCE(AVG(DATEDIFF(r.fecha_resultado, o.fecha_orden)), 0.0) AS tiempo_promedio -- COALESCE para evitar NULL
  FROM orden_laboratorio o
  LEFT JOIN resultado_laboratorio r ON o.id_orden = r.id_orden
  WHERE o.tipo_examen LIKE @tipoPattern
    AND DATE(o.fecha_orden) BETWEEN p_fechaInicio AND p_fechaFin;
END //
DELIMITER ;
